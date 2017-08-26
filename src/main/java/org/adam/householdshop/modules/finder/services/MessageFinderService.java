package org.adam.householdshop.modules.finder.services;

import java.util.Map;

import org.adam.householdshop.common.Identity;
import org.adam.householdshop.enums.MessageProjection;
import org.adam.householdshop.enums.OfferProjection;
import org.adam.householdshop.modules.finder.Repository;
import org.adam.householdshop.modules.repository.MessageRepository;

public class MessageFinderService implements FinderService {

	private final Repository repository;

	public MessageFinderService(MessageRepository repository) {
		this.repository = repository;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.adam.householdshop.modules.finder.services.FinderService#findOne(org.
	 * adam.householdshop.common.OfferId, java.lang.String)
	 */
	@Override
	public Map<String, Object> findOne(Identity messageId, String projection) {
		return repository.findOne(messageId.toUUID(), OfferProjection.valueOf(projection));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.adam.householdshop.modules.finder.services.FinderService#findAll(java
	 * .lang.String)
	 */
	@Override
	public Map<String, Map<String, Object>> findAll(String projection) {
		return repository.findAll(MessageProjection.valueOf(projection));
	}

}
