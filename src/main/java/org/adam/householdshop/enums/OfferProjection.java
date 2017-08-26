package org.adam.householdshop.enums;

import java.util.ArrayList;
import java.util.List;

/* TODO pole informujące o statusie mieszkania */

public enum OfferProjection implements Projection {
	CUSTOMER("id", "floor", "balcony", "area", "number_of_rooms", "city", "street", "postal_code", "house_number", "price", "description"),
	ADMINISTRATOR("area", "price"),
	SALESMAN("id", "floor", "balcony", "area", "number_of_rooms", "city", "street", "postal_code", "house_number", "price", "status", "description");

	private final List<String> fields;

	OfferProjection(String... fields) {
		this.fields = new ArrayList<>();
		for (String field : fields) {
			this.fields.add(field);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.adam.householdshop.Projection#toString()
	 */
	@Override
	public String toString() {
		int length = fields.toString().length();
		return fields.toString().substring(1, length - 1);
	}

	/* (non-Javadoc)
	 * @see org.adam.householdshop.Projection#getFields()
	 */
	@Override
	public List<String> getFields() {
		return fields;
	}
}
