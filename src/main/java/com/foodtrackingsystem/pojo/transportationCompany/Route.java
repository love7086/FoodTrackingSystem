/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodtrackingsystem.pojo.transportationCompany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author asus
 */
public class Route {

	private Set<Location> locationList;
	private Date endDate;

	public Route() {
		locationList = new HashSet<Location>();
	}

	public Location addLocation() {
		Location l = new Location();
		locationList.add(l);
		return l;
	}

	public void removeLocation(Location l) {
		locationList.remove(l);
	}

	public Set<Location> getLocationList() {
		return locationList;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
