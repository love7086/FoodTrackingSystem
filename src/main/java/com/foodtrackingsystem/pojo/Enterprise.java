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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author asus
 */
@Entity
@Table(name = "enterpriseTable")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public abstract class Enterprise {

	@Id
	@GenericGenerator(name="enterpriseGenerator",strategy="increment")
	@GeneratedValue(generator="enterpriseGenerator")
	@Column(name = "enterpriseId", unique = true, nullable = false)
	private long enterpriseId;

	@Column(name = "location")
	private String location;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise",orphanRemoval=true)
	private Set<User> userDir = new HashSet<User>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enterprise")
	private Set<WorkRequest> workRequests = new HashSet<WorkRequest>();

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "networkId")
	private Network network;

	public enum EnterpriseType {

		Restaurant("Restaurant"), SuperMarket("SuperMarket"), TransportationCompany("TransportationCompany"), Supplier(
				"Supplier"), Market("Market");
		private String value;

		public String getValue() {
			return value;
		}

		private EnterpriseType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

	}

	public Enterprise() {
		userDir = new HashSet<User>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<User> getUserDir() {
		return userDir;
	}

	public void setUserDir(Set<User> userDir) {
		this.userDir = userDir;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Override
	public String toString() {
		return String.valueOf(name);
	}

}
