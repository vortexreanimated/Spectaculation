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

import dev.vortex.sculk.util.SUtil;

public enum GUIType {
	CRAFTING_TABLE(CraftingTableGUI.class), ITEM_BROWSE(ItemBrowserGUI.class), ANVIL(AnvilGUI.class), REFORGE_ANVIL(
			ReforgeAnvilGUI.class), BANKER(BankerGUI.class), BANKER_DEPOSIT(DepositGUI.class), BANKER_WITHDRAWAL(
					WithdrawalGUI.class), SKYBLOCK_MENU(SkyBlockMenuGUI.class), SKYBLOCK_PROFILE(
							SkyBlockProfileGUI.class), QUIVER(QuiverGUI.class), LIFT(LiftGUI.class), SLAYER(
									SlayerGUI.class), REVENANT_HORROR(RevenantHorrorGUI.class), TARANTULA_BROODFATHER(
											TarantulaBroodfatherGUI.class), SVEN_PACKMASTER(
													SvenPackmasterGUI.class), COLLECTION_MENU(
															CollectionMenuGUI.class), SKILL_MENU(
																	SkillMenuGUI.class), PETS(
																			PetsGUI.class), FARM_MERCHANT(
																					FarmMerchantGUI.class), ACTIVE_EFFECTS(
																							ActiveEffectsGUI.class), AUCTION_HOUSE(
																									AuctionHouseGUI.class), AUCTIONS_BROWSER(
																											AuctionsBrowserGUI.class), CREATE_AUCTION(
																													CreateAuctionGUI.class), AUCTION_CONFIRM(
																															AuctionConfirmGUI.class), MANAGE_AUCTIONS(
																																	ManageAuctionsGUI.class), YOUR_BIDS(
																																			YourBidsGUI.class),;

	private final Class<? extends GUI> gui;

	GUIType(Class<? extends GUI> gui) {
		this.gui = gui;
	}

	public GUI getGUI() {
		try {
			return gui.newInstance();
		} catch (IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public GUI getGUI(Object... params) {
		return SUtil.instance(GUI.class, params);
	}

	public static GUI getGUI(String title) {
		for (GUIType type : values()) {
			if (type.getGUI().getTitle().contains(title)) {
				return type.getGUI();
			}
		}
		return null;
	}
}
