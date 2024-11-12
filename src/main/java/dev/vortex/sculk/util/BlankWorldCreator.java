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
package dev.vortex.sculk.util;

import java.util.Random;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.ChunkGenerator;

public class BlankWorldCreator extends WorldCreator // todo: fix this
{
	public BlankWorldCreator(String name) {
		super(name);
	}

	@Override
	public ChunkGenerator generator() {
		return new ChunkGenerator() {
			@Override
			public ChunkData generateChunkData(World world, Random random, int x, int z, BiomeGrid biome) {
				return this.createChunkData(world);
			}

			@Override
			public byte[] generate(World world, Random random, int x, int z) {
				return new byte[32768];
			}

			@Override
			public byte[][] generateBlockSections(World world, Random random, int x, int z, BiomeGrid biomes) {
				return new byte[16][16];
			}

			@Override
			public short[][] generateExtBlockSections(World world, Random random, int x, int z, BiomeGrid biomes) {
				return new short[world.getMaxHeight() / 16][];
			}
		};
	}
}
