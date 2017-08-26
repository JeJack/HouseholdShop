package org.adam.householdshop.common;

import java.util.UUID;

public class UserId implements Identity {

	private final UUID uuid;
	
	public UserId(String id) {
		this.uuid = UUID.fromString(id);
	}

	public UUID toUUID() {
		return uuid;
	}

}
