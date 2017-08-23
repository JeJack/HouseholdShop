package org.adam.householdshop.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Embedded
	@NotNull
	private Address address;
	
	@Min(0)
	@Max(100)
	@NotNull
	private short floor;
	
	@DecimalMin("10,00")
	@Digits(integer=3, fraction=2)
	@NotNull
	private double area;
	
	@ElementCollection
	private List<String> photoURls = new ArrayList();
	
	@NotNull
	@Min(1)
	@Max(10)
	private short numberOfRooms;
	
	@NotNull
	private boolean balcony;
	
	private String description;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public short getFloor() {
		return floor;
	}
	public void setFloor(short floor) {
		this.floor = floor;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public List<String> getPhotoURls() {
		return photoURls;
	}
	public void setPhotoURls(List<String> photoURls) {
		this.photoURls = photoURls;
	}
	public short getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(short numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public boolean isBalcony() {
		return balcony;
	}
	public void setBalcony(boolean balcony) {
		this.balcony = balcony;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
