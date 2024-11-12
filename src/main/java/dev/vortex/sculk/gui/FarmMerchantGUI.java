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
package dev.vortex.sculk.gui;

import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;

public class FarmMerchantGUI extends ShopGUI {
	private static final SItem[] ITEMS = new SItem[]{SUtil.setSItemAmount(SItem.of(SMaterial.WHEAT), 3),
			SUtil.setSItemAmount(SItem.of(SMaterial.CARROT_ITEM), 3),
			SUtil.setSItemAmount(SItem.of(SMaterial.POTATO_ITEM), 3),
			SUtil.setSItemAmount(SItem.of(SMaterial.MELON), 10),
			SUtil.setSItemAmount(SItem.of(SMaterial.SUGAR_CANE), 3), SItem.of(SMaterial.PUMPKIN),
			SItem.of(SMaterial.COCOA_BEANS), SItem.of(SMaterial.RED_MUSHROOM), SItem.of(SMaterial.BROWN_MUSHROOM),
			SUtil.setSItemAmount(SItem.of(SMaterial.SAND), 2), SItem.of(SMaterial.CACTUS)};

	public FarmMerchantGUI(int page) {
		super("Farm Merchant", page, ITEMS);
	}

	public FarmMerchantGUI() {
		this(1);
	}
}
