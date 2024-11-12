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
package dev.vortex.sculk.item.armor;

import dev.vortex.sculk.item.*;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class BigBounceBoots implements LeatherArmorStatistics, TickingMaterial, FlightStatistics, Ability
{
    @Override
    public String getAbilityName()
    {
        return "Big Double Jump";
    }

    @Override
    public String getAbilityDescription()
    {
        return "Allows you to Double Jump high!";
    }

    @Override
    public int getAbilityCooldownTicks()
    {
        return 0;
    }

    @Override
    public AbilityActivation getAbilityActivation()
    {
        return AbilityActivation.FLIGHT;
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem)
    {
        GameMode gameMode = player.getGameMode();
        if (gameMode == GameMode.CREATIVE || gameMode == GameMode.SPECTATOR) {
            return;
        }
        player.setVelocity(player.getVelocity().clone().setY(1.5));
    }

    @Override
    public int getManaCost()
    {
        return 50;
    }

    @Override
    public String getDisplayName()
    {
        return "Big Bounce Boots";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.BOOTS;
    }

    @Override
    public double getBaseDefense()
    {
        return 75;
    }

    @Override
    public double getBaseSpeed()
    {
        return 0.2;
    }

    @Override
    public double getBaseIntelligence()
    {
        return 100;
    }

    @Override
    public void tick(SItem item, Player owner)
    {
        SUtil.toggleAllowFlightNoCreative(owner.getUniqueId(), owner.getLocation().clone().subtract(0, 0.2, 0).getBlock().getType() == Material.AIR);
    }

    @Override
    public boolean enableFlight()
    {
        return true;
    }

    @Override
    public int getColor()
    {
        return 0x91B2E3;
    }
}
