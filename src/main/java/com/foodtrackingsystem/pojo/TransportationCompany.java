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
@Table(name = "transportationCompanyTable")
@PrimaryKeyJoinColumn(name = "enterpriseId")
public class TransportationCompany extends Enterprise {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transportationCompany")
	private Set<Transportation> transportationDir;

	public TransportationCompany() {
		super();
		this.transportationDir = new HashSet<Transportation>();

	}

	public Set<Transportation> getTransportationDir() {
		return transportationDir;
	}
}
