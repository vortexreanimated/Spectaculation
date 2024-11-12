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

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class AnimationSequenceType {
	private static final List<AnimationSequenceType> TYPES = new ArrayList<>();

	private final String namespace;
	private final AnimationSequence sequence;

	public AnimationSequenceType(String namespace, AnimationSequence sequence) {
		this.namespace = namespace;
		this.sequence = sequence;
		TYPES.add(this);
	}

	public String getNamespace() {
		return namespace;
	}

	public AnimationSequence getSequence() {
		return sequence;
	}

	public void play(Location location) {
		sequence.play(location);
	}

	public void play(Entity entity) {
		sequence.play(entity);
	}

	public static AnimationSequenceType getByNamespace(String namespace) {
		for (AnimationSequenceType type : TYPES) {
			if (namespace.toLowerCase().equals(type.namespace.toLowerCase())) {
				return type;
			}
		}
		return null;
	}
}
