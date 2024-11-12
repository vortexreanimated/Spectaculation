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

import java.util.ArrayList;

/**
 * Small class that adds stack-like methods to ArrayList
 * 
 * @param <T>
 */
public class StackArrayList<T> extends ArrayList<T> {
	/**
	 * Appends an element to the end of the ArrayList
	 * 
	 * @param element
	 *            The element for insertion
	 * @return Index of the element that was just pushed
	 */
	public int push(T element) {
		add(element);
		return size() - 1;
	}

	/**
	 * Shifts the ArrayList to the left, pushing off the first element
	 * 
	 * @return The element that was pushed off
	 */
	public T shift() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Could not shift because the Collection is empty");
		}
		T el = getFirst();
		removeFirst();
		return el;
	}

	/**
	 * Pops off the last element in the ArrayList
	 * 
	 * @return The element that was just popped off
	 */
	public T pop() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Could not pop off last element because the Collection is empty");
		}
		T el = get(size() - 1);
		remove(size() - 1);
		return el;
	}

	/**
	 * Gets the first element in the ArrayList
	 * 
	 * @return The element
	 */
	public T first() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Could not get the first element because the Collection is empty");
		}
		return getFirst();
	}

	/**
	 * Gets the last element in the ArrayList
	 * 
	 * @return The element
	 */
	public T last() {
		if (isEmpty()) {
			throw new ArrayIndexOutOfBoundsException("Could not get the last element because the Collection is empty");
		}
		return get(size() - 1);
	}
}
