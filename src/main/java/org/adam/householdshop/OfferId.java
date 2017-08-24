package org.adam.householdshop;

import java.util.UUID;

/*
 * Należy zastanowić się nad umieszczeniem tej klasy wewnątrz systemu
 */
public class OfferId {

	private final UUID uuid;
	
	public OfferId(String id) {
		this.uuid = UUID.fromString(id);
	}

}
