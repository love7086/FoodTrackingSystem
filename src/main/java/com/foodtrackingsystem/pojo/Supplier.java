/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author asus
 */
@Entity
@Table(name="supplierTable")
@PrimaryKeyJoinColumn(name="enterpriseId")
public class Supplier extends Enterprise {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
	private Set<Food> foodDir;

	public Supplier() {
		super();
		this.foodDir = new HashSet<Food>();
	}

	public Set<Food> getFoodDir() {
		return foodDir;
	}

	public void setFoodDir(Set<Food> foodDir) {
		this.foodDir = foodDir;
	}



}
