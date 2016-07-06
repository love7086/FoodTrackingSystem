/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.retailer;

import com.foodtrackingsystem.pojo.Food;

/**
 *
 * @author asus
 */
public class Item {

	private Food food;
	private int amout;
	private double price;

	public Item() {
	}

	public int getAmout() {
		return amout;
	}

	public void setAmout(int amout) {
		this.amout = amout;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
		this.amout = food.getQuantity();
	}

	@Override
	public String toString() {
		return food.getName();
	}

}
