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
package dev.vortex.sculk.entity;

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.util.ArrayList;
import java.util.List;

public interface EntityFunction
{
    default void onDeath(SEntity sEntity, Entity killed, Entity damager) {}
    default void onDamage(SEntity sEntity, Entity damager, EntityDamageByEntityEvent e, AtomicDouble damage) {}
    default List<EntityDrop> drops()
    {
        return new ArrayList<>();
    }
    default boolean tick(LivingEntity entity)
    {
        return false;
    }
    default void onSpawn(LivingEntity entity, SEntity sEntity) {}
    default void onAttack(EntityDamageByEntityEvent e) {}
    default void onTarget(SEntity sEntity, EntityTargetLivingEntityEvent e) {}
}
