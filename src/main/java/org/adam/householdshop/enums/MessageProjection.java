package org.adam.householdshop.enums;

import java.util.ArrayList;
import java.util.List;

public enum MessageProjection implements Projection {
	CUSTOMER("m.id", "o.id", "o.title", "u.login", "m.title", "m.description"),
	SALESMAN("m.id", "o.id", "o.title", "u.phone_number", "m.title", "m.description");

	private final List<String> fields;

	MessageProjection(String... fields) {
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
