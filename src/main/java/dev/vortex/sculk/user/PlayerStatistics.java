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
package dev.vortex.sculk.user;

import lombok.Getter;
import lombok.Setter;
import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.item.armor.ArmorSet;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class PlayerStatistics
{
    private final UUID uuid;
    private final DoublePlayerStatistic maxHealth;
    private final DoublePlayerStatistic defense;
    private final DoublePlayerStatistic strength;
    private final DoublePlayerStatistic speed;
    private final DoublePlayerStatistic critChance;
    private final DoublePlayerStatistic critDamage;
    private final DoublePlayerStatistic magicFind;
    private final DoublePlayerStatistic intelligence;
    private final DoublePlayerStatistic trueDefense;
    @Setter
    private double healthRegenerationPercentBonus;
    @Setter
    private double manaRegenerationPercentBonus;
    @Setter
    private ArmorSet armorSet;
    private Map<Integer, BukkitTask> itemTicker;

    public PlayerStatistics(UUID uuid, DoublePlayerStatistic maxHealth, DoublePlayerStatistic defense,
                            DoublePlayerStatistic strength, DoublePlayerStatistic speed,
                            DoublePlayerStatistic critChance, DoublePlayerStatistic critDamage,
                            DoublePlayerStatistic magicFind,
                            DoublePlayerStatistic intelligence, DoublePlayerStatistic trueDefense,
                            double healthRegenerationPercentBonus,
                            double manaRegenerationPercentBonus, ArmorSet armorSet)
    {
        this.uuid = uuid;
        this.maxHealth = maxHealth;
        this.defense = defense;
        this.strength = strength;
        this.speed = speed;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.magicFind = magicFind;
        this.intelligence = intelligence;
        this.trueDefense = trueDefense;
        this.healthRegenerationPercentBonus = healthRegenerationPercentBonus;
        this.manaRegenerationPercentBonus = manaRegenerationPercentBonus;
        this.armorSet = armorSet;
        this.itemTicker = new HashMap<>();
    }

    public void tickItem(int slot, long interval, Runnable runnable)
    {
        itemTicker.put(slot, new BukkitRunnable()
        {
            public void run()
            {
                if (Bukkit.getPlayer(uuid) == null)
                {
                    cancel();
                    return;
                }
                runnable.run();
            }
        }.runTaskTimer(Spectaculation.getPlugin(), 0, interval));
    }

    public void cancelTickingItem(int slot)
    {
        if (itemTicker.containsKey(slot))
            itemTicker.get(slot).cancel();
        itemTicker.remove(slot);
    }

    public void zeroAll(int slot)
    {
        maxHealth.zero(slot);
        defense.zero(slot);
        strength.zero(slot);
        intelligence.zero(slot);
        speed.zero(slot);
        critChance.zero(slot);
        critDamage.zero(slot);
        magicFind.zero(slot);
        trueDefense.zero(slot);
        cancelTickingItem(slot);
    }

    @Override
    public String toString()
    {
        return maxHealth.addAll() + ", " + defense.addAll() + ", " + strength.addAll() + ", " + speed.addAll() + ", " + critChance.addAll() + ", " +
            critDamage.addAll() + ", " + magicFind.addAll() + ", " + intelligence.addAll();
    }

    public void boostManaRegeneration(double percent, long ticks)
    {
        manaRegenerationPercentBonus += percent;
        new BukkitRunnable()
        {
            public void run()
            {
                manaRegenerationPercentBonus -= percent;
            }
        }.runTaskLater(Spectaculation.getPlugin(), ticks);
    }

    public void boostHealthRegeneration(double percent, long ticks)
    {
        healthRegenerationPercentBonus += percent;
        new BukkitRunnable()
        {
            public void run()
            {
                healthRegenerationPercentBonus -= percent;
            }
        }.runTaskLater(Spectaculation.getPlugin(), ticks);
    }

    public static PlayerStatistics blank(UUID uuid)
    {
        return new PlayerStatistics(uuid, new DoublePlayerStatistic(100.0), new DoublePlayerStatistic(),
                new DoublePlayerStatistic(), new DoublePlayerStatistic(1.0),
                new DoublePlayerStatistic(0.3), new DoublePlayerStatistic(0.5), new DoublePlayerStatistic(),
                new DoublePlayerStatistic(), new DoublePlayerStatistic(),
                0.0, 0.0, null);
    }
}
