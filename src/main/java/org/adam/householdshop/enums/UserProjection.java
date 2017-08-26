package org.adam.householdshop.enums;

import java.util.ArrayList;
import java.util.List;

public enum UserProjection implements Projection {
	ADMINISTRATOR("id", "login", "password"),
	SALESMAN("id", "login");

	private final List<String> fields;

	UserProjection(String... fields) {
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
