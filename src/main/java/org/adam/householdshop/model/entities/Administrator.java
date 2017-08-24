package org.adam.householdshop.model.entities;

import javax.persistence.Entity;

import org.adam.householdshop.model.enums.Month;

@Entity
public class Administrator extends AbstractUser implements Administrable {

	@Override
	public void removeUser(OrfinaryUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editUser(OrfinaryUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public String generaterRaport(Month month) {
		// TODO Auto-generated method stub
		return null;
	}

}
