/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "transportationTable")
public class Transportation {
	@Id
	@GenericGenerator(name = "transportationGenerator", strategy = "increment")
	@GeneratedValue(generator = "transportationGenerator")
	@Column(name = "transportationId", unique = true, nullable = false)
	private long transportationId;

	@OneToOne
	@JoinColumn(name = "food" ,unique=true)
	private Food food;

	@Column
	private String startDate;

	@Column
	private String endDate;

	@Column
	private String lon1;

	@Column
	private String lat1;

	@Column
	private String lon2;

	@Column
	private String lat2;

	@OneToOne
	@JoinColumn(name = "processor")
	private User processor;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "transportationCompany")
	private TransportationCompany transportationCompany;

	public Transportation() {
	}

	public long getTransportationId() {
		return transportationId;
	}

	public void setTransportationId(long transportationId) {
		this.transportationId = transportationId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLon1() {
		return lon1;
	}

	public void setLon1(String lon1) {
		this.lon1 = lon1;
	}

	public String getLat1() {
		return lat1;
	}

	public void setLat1(String lat1) {
		this.lat1 = lat1;
	}

	public String getLon2() {
		return lon2;
	}

	public void setLon2(String lon2) {
		this.lon2 = lon2;
	}

	public String getLat2() {
		return lat2;
	}

	public void setLat2(String lat2) {
		this.lat2 = lat2;
	}

	public User getProcessor() {
		return processor;
	}

	public void setProcessor(User processor) {
		this.processor = processor;
	}

	public TransportationCompany getTransportationCompany() {
		return transportationCompany;
	}

	public void setTransportationCompany(TransportationCompany transportationCompany) {
		this.transportationCompany = transportationCompany;
	}
}
