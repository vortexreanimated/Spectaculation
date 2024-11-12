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
import java.util.Arrays;
import java.util.List;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

public class AnimationSequence implements Sequence {
	private final List<DelayedAnimation> animations;

	public AnimationSequence(DelayedAnimation... animations) {
		this.animations = Arrays.asList(animations);
	}

	public void append(DelayedAnimation sound) {
		animations.add(sound);
	}

	@Override
	public void play(Location location) {
		for (DelayedAnimation animation : animations)
			animation.play(location);
	}

	@Override
	public void play(Entity entity) {
		for (DelayedAnimation animation : animations)
			animation.play(entity);
	}

	public static class DelayedAnimation {
		private final Effect effect;
		private final int data;
		private final long delay;
		private final float speed;
		private final int particleCount;

		public DelayedAnimation(Effect effect, int data, long delay, float speed, int particleCount) {
			this.effect = effect;
			this.data = data;
			this.delay = delay;
			this.speed = speed;
			this.particleCount = particleCount;
		}

		public void play(Location location) {
			new BukkitRunnable() {
				@Override
				public void run() {
					location.getWorld().spigot().playEffect(location, effect, 1, data, 0.0f, 0.0f, 0.0f, speed,
							particleCount, 16);
				}
			}.runTaskLater(Spectaculation.getPlugin(), delay);
		}

		public void play(Entity entity) {
			play(entity.getLocation());
		}
	}
}
