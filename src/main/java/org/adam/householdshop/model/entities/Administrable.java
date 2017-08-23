package org.adam.householdshop.model.entities;

import org.adam.householdshop.model.enums.Month;

public interface Administrable {

	public void removeUser(OrfinaryUser user);
	public void editUser(OrfinaryUser user);
	public String generaterRaport(Month month);
		
}
