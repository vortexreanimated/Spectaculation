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
package dev.vortex.sculk.sequence;

import dev.vortex.sculk.Spectaculation;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;

public class SoundSequence implements Sequence
{
    private final List<DelayedSound> sounds;

    public SoundSequence(DelayedSound... sounds)
    {
        this.sounds = Arrays.asList(sounds);
    }

    public void append(DelayedSound sound)
    {
        sounds.add(sound);
    }

    @Override
    public void play(Location location)
    {
        for (DelayedSound sound : sounds)
            sound.play(location);
    }

    @Override
    public void play(Entity entity)
    {
        for (DelayedSound sound : sounds)
            sound.play(entity);
    }

    public static class DelayedSound
    {
        private final Sound sound;
        private final float volume;
        private final float pitch;
        private final long delay;

        public DelayedSound(Sound sound, float volume, float pitch, long delay)
        {
            this.sound = sound;
            this.volume = volume;
            this.pitch = pitch;
            this.delay = delay;
        }

        public DelayedSound(Sound sound, float volume, float pitch)
        {
            this(sound, volume, pitch, 0);
        }

        public void play(Location location)
        {
            new BukkitRunnable()
            {
                @Override
                public void run()
                {
                    location.getWorld().playSound(location, sound, volume, pitch);
                }
            }.runTaskLater(Spectaculation.getPlugin(), delay);
        }

        public void play(Entity entity)
        {
            play(entity.getLocation());
        }
    }
}
