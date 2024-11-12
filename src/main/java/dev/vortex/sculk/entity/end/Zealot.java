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
package dev.vortex.sculk.entity.end;

import com.google.common.util.concurrent.AtomicDouble;
import dev.vortex.sculk.entity.*;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.item.pet.Pet;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Zealot implements EndermanStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Zealot";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 13000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 1250.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.ENDER_PEARL, SUtil.random(3, 5)), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(new ItemStack(Material.ENDER_PEARL, SUtil.random(3, 5)), EntityDropType.GUARANTEED, 0.05));
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager)
    {
        Player player = (Player) damager;
        User user = User.getUser(player.getUniqueId());
        Pet pet = user.getActivePetClass();
        AtomicDouble chance = new AtomicDouble(420.0);
        if (pet != null) pet.runAbilities(ability -> ability.onZealotAttempt(chance), user.getActivePet());
        if (SUtil.random(1.0, chance.get()) != 1) return;
        player.playSound(player.getLocation(), Sound.WITHER_SPAWN, 1f, 1f);
        SUtil.sendTitle(player, ChatColor.RED + "SPECIAL ZEALOT");
        player.sendMessage(ChatColor.GREEN + "A special " + ChatColor.LIGHT_PURPLE + "Zealot" + ChatColor.GREEN + " has spawned nearby!");
        new SEntity(killed, SEntityType.SPECIAL_ZEALOT);
    }

    @Override
    public double getXPDropped()
    {
        return 40.0;
    }

    public static class SpecialZealot implements EndermanStatistics, EntityFunction
    {
        @Override
        public String getEntityName()
        {
            return "Zealot";
        }

        @Override
        public double getEntityMaxHealth()
        {
            return 2000.0;
        }

        @Override
        public double getDamageDealt()
        {
            return 1250.0;
        }

        @Override
        public List<EntityDrop> drops()
        {
            return Collections.singletonList(new EntityDrop(SItem.of(SMaterial.SUMMONING_EYE).getStack(), EntityDropType.RARE, 1.0));
        }

        @Override
        public MaterialData getCarriedMaterial()
        {
            return new MaterialData(Material.ENDER_PORTAL_FRAME);
        }

        @Override
        public double getXPDropped()
        {
            return 40.0;
        }
    }

    public static class EnderChestZealot implements EndermanStatistics, EntityFunction
    {
        @Override
        public String getEntityName()
        {
            return "Zealot";
        }

        @Override
        public double getEntityMaxHealth()
        {
            return 13000.0;
        }

        @Override
        public double getDamageDealt()
        {
            return 1250.0;
        }

        @Override
        public List<EntityDrop> drops()
        {
            return Arrays.asList(new EntityDrop(new ItemStack(Material.ENDER_PEARL, SUtil.random(3, 5)), EntityDropType.GUARANTEED, 1.0),
                    SUtil.getRandom(Arrays.asList(
                            new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.ENCHANTED_ENDER_PEARL).getStack(),
                                    SUtil.random(1, 2)), EntityDropType.OCCASIONAL, 1.0),
                            new EntityDrop(SMaterial.CRYSTAL_FRAGMENT, EntityDropType.OCCASIONAL, 1.0),
                            new EntityDrop(SMaterial.ENCHANTED_END_STONE, EntityDropType.OCCASIONAL, 1.0),
                            new EntityDrop(SMaterial.ENCHANTED_OBSIDIAN, EntityDropType.OCCASIONAL, 1.0))));
        }

        @Override
        public MaterialData getCarriedMaterial()
        {
            return new MaterialData(Material.ENDER_CHEST);
        }

        @Override
        public void onDeath(SEntity sEntity, Entity killed, Entity damager)
        {
            Player player = (Player) damager;
            User user = User.getUser(player.getUniqueId());
            Pet pet = user.getActivePetClass();
            AtomicDouble chance = new AtomicDouble(420.0);
            if (pet != null) pet.runAbilities(ability -> ability.onZealotAttempt(chance), user.getActivePet());
            if (SUtil.random(1.0, chance.get()) != 1) return;
            player.playSound(player.getLocation(), Sound.WITHER_SPAWN, 1f, 1f);
            SUtil.sendTitle(player, ChatColor.RED + "SPECIAL ZEALOT");
            player.sendMessage(ChatColor.GREEN + "A special " + ChatColor.LIGHT_PURPLE + "Zealot" + ChatColor.GREEN + " has spawned nearby!");
            new SEntity(killed, SEntityType.SPECIAL_ZEALOT);
        }

        @Override
        public double getXPDropped()
        {
            return 40.0;
        }
    }
}