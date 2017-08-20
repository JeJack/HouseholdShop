package org.adam.householdshop.model.entities;

import org.adam.householdshop.model.enums.Month;

public interface Administrable {

	public void removeUser(RandomUser user);
	public void editUser(RandomUser user);
	public String generaterRaport(Month month);
		
}
