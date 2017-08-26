package org.adam.householdshop.modules.finder;

import java.util.Map;

import org.adam.householdshop.OfferId;
import org.adam.householdshop.Projection;

public class OfferFinderService {

	private final OfferRepository repository;

	public OfferFinderService(OfferRepository repository) {
		this.repository = repository;
	}
	
	public Map<String, Object> findOne(OfferId offerId, String projection) {
		return repository.findOne(offerId.toUUID(), Projection.valueOf(projection));
	}

	public Map<String, Map<String, Object>> findAll(String projection) {
		return repository.findAll(Projection.valueOf(projection));
	}


}
