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
package dev.vortex.sculk.item.pet;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.RarityValue;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.skill.CombatSkill;
import dev.vortex.sculk.skill.Skill;
import dev.vortex.sculk.util.SLog;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GungaPet extends Pet
{
    @Override
    public List<PetAbility> getPetAbilities(SItem instance)
    {
        int level = getLevel(instance);
        RarityValue<Double> annihCh = new RarityValue<>(10.0, 10.0, 10.0, 8.0, 6.0, 6.0);
        RarityValue<Integer> gingaCh = new RarityValue<>(50, 40, 30, 20, 10, 10);
        BigDecimal annih = BigDecimal.valueOf(1.0 / (annihCh.getForRarity(instance.getRarity()) - (level * 0.02))).setScale(1, RoundingMode.HALF_EVEN);
        BigDecimal pig = BigDecimal.valueOf(1.0 / (150.0 - level)).setScale(3, RoundingMode.HALF_EVEN);
        List<PetAbility> abilities = new ArrayList<>(Collections.singletonList(new PetAbility()
        {
            @Override
            public String getName()
            {
                return "GUNGA GINGA!";
            }

            @Override
            public List<String> getDescription(SItem instance)
            {
                return Arrays.asList("On damage you will occasionally", "spit straight facts in the chat.");
            }

            @Override
            public void onDamage(EntityDamageByEntityEvent e)
            {
                if (SUtil.random(0, gingaCh.getForRarity(instance.getRarity())) == 0)
                    ((Player) e.getDamager()).chat("GUNGA GINGA!");
            }
        }));
        if (instance.getRarity().isAtLeast(Rarity.RARE))
        {
            abilities.add(new PetAbility()
            {
                @Override
                public String getName()
                {
                    return "Self-Annihilation";
                }

                @Override
                public List<String> getDescription(SItem instance)
                {
                    return Arrays.asList("When hurt, you will have a", ChatColor.GREEN + annih.toPlainString() + "%" + ChatColor.GRAY + " chance to explode.");
                }

                @Override
                public void onHurt(EntityDamageByEntityEvent e, Entity damager)
                {
                    if (SUtil.random(0.0, 100.0) > annih.doubleValue())
                        return;
                    Player player = (Player) e.getEntity();
                    player.setHealth(player.getMaxHealth() * 0.1);
                    player.playSound(player.getLocation(), Sound.EXPLODE, 2f, 1f);
                    player.playEffect(player.getLocation(), Effect.EXPLOSION_HUGE, Effect.EXPLOSION_HUGE.getData());
                    player.setVelocity(player.getVelocity().clone().add(new Vector(0.0, 0.4, 0.0)));
                    player.sendMessage(ChatColor.RED + "Your pet has caused you to blow up!");
                }
            });
        }
        if (instance.getRarity().isAtLeast(Rarity.LEGENDARY))
        {
            abilities.add(new PetAbility()
            {
                @Override
                public String getName()
                {
                    return "Golden Pig";
                }

                @Override
                public List<String> getDescription(SItem instance)
                {
                    return Arrays.asList("Have a " + ChatColor.GREEN + pig.toPlainString() + "%" + ChatColor.GRAY + " chance",
                            "to quadruple your damage.");
                }

                @Override
                public void onDamage(EntityDamageByEntityEvent e)
                {
                    if (SUtil.random(0.0, 100.0) > pig.doubleValue())
                        return;
                    ((Player) e.getDamager()).playSound(e.getDamager().getLocation(), Sound.ZOMBIE_METAL, 1f, 1f);
                    e.setDamage(e.getDamage() * 4.0);
                }
            });
        }
        return abilities;
    }

    @Override
    public Skill getSkill()
    {
        return CombatSkill.INSTANCE;
    }

    @Override
    public String getURL()
    {
        return "c17a7f20579fec251ae86e589699c6a325521196a68ed04578fdaac29c7f7723";
    }

    @Override
    public String getDisplayName()
    {
        return "Gunga";
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.PET;
    }

    @Override
    public double getPerIntelligence()
    {
        return -0.3;
    }

    @Override
    public double getPerMagicFind()
    {
        return 0.04;
    }

    @Override
    public double getPerDefense()
    {
        return 0.5;
    }

    @Override
    public double getPerCritDamage()
    {
        return 0.03;
    }
}