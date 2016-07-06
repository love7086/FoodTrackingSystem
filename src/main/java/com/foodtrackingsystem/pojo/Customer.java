/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "customerTable")
@PrimaryKeyJoinColumn(name = "userId")
public class Customer extends User {

	@Column
	private String customerName;

	public Customer() {
		super();
		this.setRole("customer");

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
