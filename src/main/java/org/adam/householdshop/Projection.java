package org.adam.householdshop;

public enum Projection {
	CUSTOMER, SALESMAN;

	public static String get(Projection projection) {
		switch (projection) {
			case CUSTOMER: return "";
			case SALESMAN: return "";
		}
		return null;
	}

}
