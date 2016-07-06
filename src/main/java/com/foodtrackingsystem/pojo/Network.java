/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "networkTable")
public class Network {

	@Id
	@GenericGenerator(name = "networkGenerator", strategy = "increment")
	@GeneratedValue(generator = "networkGenerator")
	@Column(name = "networkId", unique = true, nullable = false)
	private long networkId;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "network", orphanRemoval = true)
	private Set<Enterprise> enterpriseDir;

	public Network() {
		this.enterpriseDir = new HashSet<Enterprise>();
	}

	public String getName() {
		return name;
	}

	public long getNetworkId() {
		return networkId;
	}

	public void setNetworkId(long networkId) {
		this.networkId = networkId;
	}

	public void setEnterpriseDir(Set<Enterprise> enterpriseDir) {
		this.enterpriseDir = enterpriseDir;
	}

	public Set<Enterprise> getEnterpriseDir() {
		return enterpriseDir;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
