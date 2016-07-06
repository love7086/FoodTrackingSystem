/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.retailer;

import java.util.HashSet;
import java.util.Set;

import com.foodtrackingsystem.pojo.Food;

/**
 *
 * @author asus
 */
public class Inventory {

	private Set<Item> inventory;

	public Inventory() {
		inventory = new HashSet<Item>();
	}

	public Item addItem(Food food) {
		Item item = new Item();
		item.setFood(food);
		inventory.add(item);
		return item;
	}

	public void removeItem(Item item) {
		inventory.remove(item);
	}

	public Set<Item> getInventory() {
		return inventory;
	}

}
