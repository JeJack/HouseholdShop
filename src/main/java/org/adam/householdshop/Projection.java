package org.adam.householdshop;

import java.util.ArrayList;
import java.util.List;

public enum Projection {
	CUSTOMER("offer_id", "floor", "balcony", "area", "number_of_rooms", "city", "street", "postal_code", "house_number", "price"), 
	SALESMAN("offer_id", "floor", "balcony", "area", "number_of_rooms", "city", "street", "postal_code", "house_number", "price");

	private final List<String> fields;

	Projection(String... fields) {
		this.fields = new ArrayList<>();
		for (String field : fields) {
			this.fields.add(field);
		}
	}
	
	public String toString() {
		int length = fields.toString().length();
		return fields.toString().substring(1, length - 1);
	}

	public List<String> getFields() {
		return fields;
	}
}
