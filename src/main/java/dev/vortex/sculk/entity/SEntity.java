/*
 * This file belongs to Sculk, a Hypixel Skyblock recreation.
 * Copyright (c) 2024 VortexReanimated
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, see <https://www.gnu.org/licenses/>.
 * 
 */
package dev.vortex.sculk.entity;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.end.EndermanStatistics;
import dev.vortex.sculk.entity.nms.SNMSEntity;
import dev.vortex.sculk.entity.wolf.WolfStatistics;
import dev.vortex.sculk.util.SUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.Getter;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.entity.*;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

@Getter
public class SEntity // 3, 4, 5
{
	private static final Spectaculation plugin = Spectaculation.getPlugin();

	private final SEntityType specType;
	private final LivingEntity entity;
	private final Map<UUID, Double> damageDealt;
	private BukkitTask task;
	private BukkitTask ticker;
	private Object genericInstance;
	private EntityStatistics statistics;
	private EntityFunction function;

	public SEntity(Location location, SEntityType specType, Object... params) {
		this.specType = specType;
		Object instance = specType.instance(params);
		this.genericInstance = instance;
		EntityFunction function = (EntityFunction) instance;
		EntityStatistics statistics = (EntityStatistics) instance;
		this.function = function;
		this.statistics = statistics;
		if (instance instanceof SNMSEntity sEntity) {
			this.entity = sEntity.spawn(location);
		} else {
			this.entity = (LivingEntity) location.getWorld().spawnEntity(location, specType.getCraftType());
		}
		this.damageDealt = new HashMap<>();
		if (statistics.getMovementSpeed() != -1.0) {
			((CraftLivingEntity) entity).getHandle().getAttributeInstance(GenericAttributes.MOVEMENT_SPEED)
					.setValue(statistics.getMovementSpeed());
		}
		Location move = this.entity.getLocation().clone();
		move.setYaw(((Double) SUtil.random(0.0, 360.0)).floatValue());
		this.entity.teleport(move);
		SEntityEquipment equipment = statistics.getEntityEquipment();
		EntityEquipment ee = this.entity.getEquipment();
		if (equipment != null) {
			ee.setHelmet(equipment.getHelmet());
			ee.setChestplate(equipment.getChestplate());
			ee.setLeggings(equipment.getLeggings());
			ee.setBoots(equipment.getBoots());
			ee.setItemInHand(equipment.getItemInHand());
		}
		this.entity.setRemoveWhenFarAway(statistics.removeWhenFarAway());
		function.onSpawn(entity, this);
		if (function.tick(entity)) {
			this.ticker = new BukkitRunnable() {
				@Override
				public void run() {
					if (entity.isDead()) {
						cancel();
					}
					function.tick(entity);
				}
			}.runTaskTimer(Spectaculation.getPlugin(), 0, 1);
		}
		if (statistics instanceof SlimeStatistics slimeStatistics && this.entity instanceof Slime slime) {
			slime.setSize(slimeStatistics.getSize());
		}
		if (statistics instanceof EndermanStatistics endermanStatistics && this.entity instanceof Enderman enderman) {
			enderman.setCarriedMaterial(endermanStatistics.getCarriedMaterial() != null
					? endermanStatistics.getCarriedMaterial()
					: new MaterialData(Material.AIR));
		}
		if (this.entity instanceof org.bukkit.entity.Ageable ageable1) {
			if (genericInstance instanceof Ageable ageable && ageable.isBaby()) {
				ageable1.setBaby();
			} else {
				ageable1.setAdult();
			}
		}
		if (statistics instanceof ZombieStatistics zombieStatistics && this.entity instanceof Zombie zombie) {
			zombie.setVillager(zombieStatistics.isVillager());
		}
		if (statistics instanceof JockeyStatistics jockeyStatistics) {
			this.entity.setPassenger(new SEntity(location, jockeyStatistics.getPassenger()).getEntity());
		}
		if (statistics instanceof WolfStatistics wolfStatistics && this.entity instanceof Wolf wolf) {
			wolf.setAngry(wolfStatistics.isAngry());
		}
		if (statistics instanceof SkeletonStatistics skeletonStatistics && this.entity instanceof Skeleton skeleton) {
			skeleton.setSkeletonType(
					skeletonStatistics.isWither() ? Skeleton.SkeletonType.WITHER : Skeleton.SkeletonType.NORMAL);
		}
		new BukkitRunnable() {
			@Override
			public void run() {
				if (!statistics.isVisible()) {
					((CraftLivingEntity) entity).getHandle().setInvisible(true);
				}
			}
		}.runTaskLater(Spectaculation.getPlugin(), 2);
		this.entity.setMaxHealth(statistics.getEntityMaxHealth());
		this.entity.setHealth(this.entity.getMaxHealth());
		this.entity.setMetadata("specEntityObject", new FixedMetadataValue(plugin, this));
		if (statistics.hasNameTag()) {
			if (entity instanceof EnderDragon) {
				entity.setCustomName(ChatColor.RED + statistics.getEntityName());
				return;
			}
			this.entity.setCustomNameVisible(true);
			this.task = new BukkitRunnable() {
				@Override
				public void run() {
					entity.setCustomName(ChatColor.RED + statistics.getEntityName() + " " + ChatColor.GREEN
							+ (int) entity.getHealth() + ChatColor.WHITE + "/" + ChatColor.GREEN
							+ (int) entity.getMaxHealth() + ChatColor.RED + "❤");
				}
			}.runTaskTimer(Spectaculation.getPlugin(), 0, 10);
		}
	}

	public SEntity(Entity e, SEntityType type, Object... params) {
		this(e.getLocation(), type, params);
	}

	public void addDamageFor(Player player, double damage) {
		UUID uuid = player.getUniqueId();
		if (damageDealt.containsKey(uuid)) {
			damage += damageDealt.get(uuid);
		}
		damageDealt.remove(uuid);
		damageDealt.put(uuid, damage);
	}

	public void setVisible(boolean visible) {
		new BukkitRunnable() {
			@Override
			public void run() {
				((CraftLivingEntity) entity).getHandle().setInvisible(!visible);
			}
		}.runTaskLater(Spectaculation.getPlugin(), 2);
	}

	public void setTarget(LivingEntity target) {
		if (!(entity instanceof Creature)) {
			return;
		}
		((Creature) entity).setTarget(target);
	}

	public void remove() {
		if (this.ticker != null) {
			this.ticker.cancel();
		}
		if (this.task != null) {
			this.task.cancel();
		}
		entity.remove();
	}

	public static SEntity findSEntity(Entity entity) {
		if (!entity.hasMetadata("specEntityObject") || entity.getMetadata("specEntityObject").size() == 0
				|| !(entity.getMetadata("specEntityObject").getFirst().value() instanceof SEntity)) {
			return null;
		}
		return (SEntity) entity.getMetadata("specEntityObject").getFirst().value();
	}
}
