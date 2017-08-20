package org.adam.householdshop.model.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="offer")
public class Offer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Embedded
	@NotNull
	private Address address;
	
	@NotNull
	private short floor;
	
	@NotNull
	private double area;
	
	@NotNull
	private List<String> photoURls;
	
	@NotNull
	private short numberOfRooms;
	
	@NotNull
	private boolean balcony;
	
	@NotNull
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
}
