/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.retailer;

import java.util.HashSet;
import java.util.Set;

import com.foodtrackingsystem.pojo.Enterprise;

/**
 *
 * @author asus
 */
public abstract class Retailer extends Enterprise {

	private Inventory inventory;
	private Set<Order> OrderHistory;

	public Retailer() {
		super();
		inventory = new Inventory();
		OrderHistory = new HashSet<Order>();

	}


	public Inventory getInventory() {
		return inventory;
	}

	public Set<Order> getOrderHistory() {
		return OrderHistory;
	}

	public Order addOrder(HashSet<Item> itemDir) {
		Order o = new Order();
		o.setItemDir(itemDir);
		OrderHistory.add(o);
		return o;
	}

	public void removeOrder(Order order) {
		OrderHistory.remove(order);
	}

//	@Override
//	public Organization addOrganization(OrganizationType organizationType) {
//		Organization o = null;
//		if (organizationType == OrganizationType.RetailerOrganization) {
//			o = new RetailerOrganization();
//		}
//		getOrganizationDir().add(o);
//		return o;
//	}

}
