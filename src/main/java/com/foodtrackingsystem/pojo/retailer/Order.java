/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.retailer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author asus
 */
public class Order {

	private Set<Item> itemDir;
	private Date date;

	public Order() {
		this.date = new Date();
		this.itemDir = new HashSet<Item>();
	}
	
	public Set<Item> getItemDir() {
		return itemDir;
	}


	public void setItemDir(Set<Item> itemDir) {
		this.itemDir = itemDir;
	}


	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return String.valueOf(itemDir.size());
	}

}
