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
package dev.vortex.sculk.slayer;

import com.google.common.util.concurrent.AtomicDouble;
import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SEntityType;
import dev.vortex.sculk.sequence.SoundSequenceType;
import dev.vortex.sculk.util.SUtil;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.*;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SlayerQuest implements ConfigurationSerializable
{
    private final SlayerBossType type;
    private final long started;
    @Setter
    private double xp;
    @Setter
    private long spawned;
    @Setter
    private long killed;
    @Setter
    private long died;
    @Setter
    private SEntityType lastKilled;
    @Setter
    private SEntity entity;

    public SlayerQuest(SlayerBossType type, long started)
    {
        this.type = type;
        this.started = started;
        this.entity = null;
    }

    private SlayerQuest(SlayerBossType type, long started, double xp, long spawned, long killed, long died, SEntityType lastKilled)
    {
        this.type = type;
        this.started = started;
        this.xp = xp;
        this.spawned = spawned;
        this.killed = killed;
        this.died = died;
        this.lastKilled = lastKilled;
        this.entity = null;
    }

    @Override
    public Map<String, Object> serialize()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type.getNamespace());
        map.put("started", started);
        map.put("xp", xp);
        map.put("spawned", spawned);
        map.put("killed", killed);
        map.put("died", died);
        map.put("lastKilled", lastKilled.name());
        return map;
    }

    public static SlayerQuest deserialize(Map<String, Object> map)
    {
        return new SlayerQuest(SlayerBossType.getByNamespace(String.valueOf(map.get("type"))),
                ((Number) map.get("started")).longValue(),
                ((Number) map.get("xp")).doubleValue(),
                ((Number) map.get("spawned")).longValue(),
                ((Number) map.get("killed")).longValue(),
                ((Number) map.get("died")).longValue(),
                SEntityType.valueOf(String.valueOf(map.get("lastKilled"))));
    }

    public static void playMinibossSpawn(Location location, Entity sound)
    {
        Location clone = location.clone();
        World world = location.getWorld();
        if (sound != null) {
            SoundSequenceType.SLAYER_MINIBOSS_SPAWN.play(sound);
        }
        else {
            SoundSequenceType.SLAYER_MINIBOSS_SPAWN.play(clone);
        }
        AtomicDouble additive = new AtomicDouble();
        SUtil.runIntervalForTicks(() ->
                world.spigot().playEffect(clone.clone().add(0.0, additive.getAndAdd(0.5), 0.0), Effect.EXPLOSION_LARGE, 1,
                        0, 0.0f, 0.0f, 0.0f, 0.0f, 1, 16), 3, 12);
    }

    public static void playBossSpawn(Location location, Entity sound)
    {
        Location clone = location.clone();
        World world = location.getWorld();
        if (sound != null) {
            SoundSequenceType.SLAYER_BOSS_SPAWN.play(sound);
        }
        else {
            SoundSequenceType.SLAYER_BOSS_SPAWN.play(clone);
        }
        SUtil.runIntervalForTicks(() ->
        {
            for (int i = 0; i < 50; i++)
            {
                world.playEffect(clone, Effect.SPELL, Effect.SPELL.getData());
                world.playEffect(clone, Effect.FLYING_GLYPH, Effect.FLYING_GLYPH.getData());
                world.playEffect(clone, Effect.WITCH_MAGIC, Effect.WITCH_MAGIC.getData());
            }
        }, 5, 28);
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                world.playEffect(clone, Effect.EXPLOSION_HUGE, Effect.EXPLOSION_HUGE.getData());
            }
        }.runTaskLater(Spectaculation.getPlugin(), 28);
    }
}
