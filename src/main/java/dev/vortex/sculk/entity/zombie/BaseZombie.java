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
package dev.vortex.sculk.entity.zombie;

import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SEntityType;
import dev.vortex.sculk.entity.ZombieStatistics;
import dev.vortex.sculk.slayer.SlayerQuest;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public abstract class BaseZombie implements ZombieStatistics, EntityFunction
{
    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager)
    {
        if (!(damager instanceof Player)) return;
        Player player = (Player) damager;
        User user = User.getUser(player.getUniqueId());
        SlayerQuest quest = user.getSlayerQuest();
        if (quest == null) return;
        if (quest.getSpawned() != 0) return;
        Location k = killed.getLocation().clone();
        if (SUtil.random(0, 8) == 0 && quest.getType().getTier() >= 3)
        {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.REVENANT_SYCOPHANT).setTarget(player), 12);
            return;
        }
        if (SUtil.random(0, 16) == 0 && quest.getType().getTier() >= 4)
        {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.REVENANT_CHAMPION).setTarget(player), 12);
            return;
        }
        if (SUtil.random(0, 45) == 0 && quest.getType().getTier() >= 4)
        {
            SlayerQuest.playMinibossSpawn(k, player);
            SUtil.delay(() -> new SEntity(k, SEntityType.DEFORMED_REVENANT).setTarget(player), 12);
        }
    }
}