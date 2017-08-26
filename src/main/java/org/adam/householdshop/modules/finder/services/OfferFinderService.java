package org.adam.householdshop.modules.finder.services;

import java.util.Map;

import org.adam.householdshop.common.Identity;
import org.adam.householdshop.enums.OfferProjection;
import org.adam.householdshop.modules.finder.Repository;
import org.adam.householdshop.modules.repository.OfferRepository;

public class OfferFinderService implements FinderService {

	private final Repository repository;

	public OfferFinderService(OfferRepository repository) {
		this.repository = repository;
	}
	
	/* (non-Javadoc)
	 * @see org.adam.householdshop.modules.finder.services.FinderService#findOne(org.adam.householdshop.common.OfferId, java.lang.String)
	 */
	@Override
	public Map<String, Object> findOne(Identity offerId, String projection) {
		return repository.findOne(offerId.toUUID(), OfferProjection.valueOf(projection));
	}

	/* (non-Javadoc)
	 * @see org.adam.householdshop.modules.finder.services.FinderService#findAll(java.lang.String)
	 */
	@Override
	public Map<String, Map<String, Object>> findAll(String projection) {
		return repository.findAll(OfferProjection.valueOf(projection));
	}


}
