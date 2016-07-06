/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "foodTable")
public class Food {
	@Id
	@GenericGenerator(name = "foodGenerator", strategy = "increment")
	@GeneratedValue(generator = "foodGenerator")
	@Column(name = "foodId", unique = true, nullable = false)
	private long foodId;

	@Column(unique=true)
	private String name;

	@Column
	private String harvestDate;

	@Column
	private String description;

	@Column
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "supplier")
	private Supplier supplier;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "food", orphanRemoval = true)
	private Set<Comment> comments;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "food", cascade = CascadeType.ALL)
	private Transportation transportation;
	public Food() {
//		this.comments = new HashSet<Comment>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getHarvestDate() {
		return harvestDate;
	}

	public void setHarvestDate(String harvestDate) {
		this.harvestDate = harvestDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return name;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}
	
}
