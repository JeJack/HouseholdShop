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

	public Object findAll(String projection) {
		// TODO Auto-generated method stub
		return null;
	}


}
