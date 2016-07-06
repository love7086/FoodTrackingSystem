/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.workRequest;

import java.util.Date;

import com.foodtrackingsystem.pojo.Food;
import com.foodtrackingsystem.pojo.Supplier;
import com.foodtrackingsystem.pojo.WorkRequest;

/**
 *
 * @author asus
 */
public class FoodRequest extends WorkRequest {

	private Food food;
	private Date deadline;
	private Supplier supplier;

	public FoodRequest() {
		super();
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return food.getName();
	}

	public Supplier getSupplier() {
		return supplier;
	}

}
