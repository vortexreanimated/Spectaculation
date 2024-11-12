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
package dev.vortex.sculk.item;

import lombok.Getter;

@Getter
public class RarityValue<T> {
	private final T common;
	private final T uncommon;
	private final T rare;
	private final T epic;
	private final T legendary;
	private final T rest;

	public RarityValue(T common, T uncommon, T rare, T epic, T legendary, T rest) {
		this.common = common;
		this.uncommon = uncommon;
		this.rare = rare;
		this.epic = epic;
		this.legendary = legendary;
		this.rest = rest;
	}

	public T getForRarity(Rarity rarity) {
		switch (rarity) {
			case COMMON :
				return common;
			case UNCOMMON :
				return uncommon;
			case RARE :
				return rare;
			case EPIC :
				return epic;
			case LEGENDARY :
				return legendary;
			default :
				return rest;
		}
	}

	public static RarityValue<Integer> zeroInteger() {
		return new RarityValue<>(0, 0, 0, 0, 0, 0);
	}

	public static RarityValue<Double> zeroDouble() {
		return new RarityValue<>(0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
	}

	public static RarityValue<Integer> singleInteger(Integer i) {
		return new RarityValue<>(i, i, i, i, i, i);
	}

	public static RarityValue<Double> singleDouble(Double d) {
		return new RarityValue<>(d, d, d, d, d, d);
	}
}
