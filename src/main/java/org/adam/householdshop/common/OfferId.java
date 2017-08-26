package org.adam.householdshop.common;

import java.util.UUID;

public class OfferId implements Identity {

	private final UUID uuid;
	
	public OfferId(String id) {
		this.uuid = UUID.fromString(id);
	}

	/* (non-Javadoc)
	 * @see org.adam.householdshop.common.Identity#toUUID()
	 */
	@Override
	public UUID toUUID() {
		return uuid;
	}

}
