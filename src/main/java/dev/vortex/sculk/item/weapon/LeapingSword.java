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
package dev.vortex.sculk.item.weapon;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.item.*;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LeapingSword implements ToolStatistics, MaterialFunction, Ability
{
    @Override
    public int getBaseDamage()
    {
        return 150;
    }

    @Override
    public double getBaseStrength()
    {
        return 100;
    }

    @Override
    public double getBaseCritDamage()
    {
        return 0.25;
    }

    @Override
    public String getDisplayName()
    {
        return "Leaping Sword";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.SWORD;
    }

    @Override
    public String getLore()
    {
        return null;
    }

    @Override
    public String getAbilityName()
    {
        return "Leap";
    }

    @Override
    public String getAbilityDescription()
    {
        return "Leap into the air and deal damage to any nearby enemies upon landing on the ground. Damaged enemies will also be frozen for 1 second.";
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem)
    {
        player.setVelocity(player.getLocation().getDirection().multiply(3).setY(2));
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if (player.getLocation().subtract(0, 0.5, 0).getBlock().getType() == Material.AIR) return;
                player.getWorld().playSound(player.getLocation(), Sound.EXPLODE, 2f, 1f);
                player.playEffect(player.getLocation(), Effect.EXPLOSION_LARGE, Effect.EXPLOSION_LARGE.getData());
                //for (Entity entity : player.getNearbyEntities(5, 5, 5))
                //    entity.
                this.cancel();
            }
        }.runTaskTimer(Spectaculation.getPlugin(), 10, 2);
    }

    @Override
    public int getAbilityCooldownTicks()
    {
        return 20;
    }

    @Override
    public int getManaCost()
    {
        return 50;
    }
}