package org.adam.householdshop.modules.finder.services;

import java.util.Map;

import org.adam.householdshop.common.Identity;
import org.adam.householdshop.enums.UserProjection;
import org.adam.householdshop.modules.finder.Repository;
import org.adam.householdshop.modules.repository.UserRepository;

public class UserFinderService implements FinderService {
	
	private final Repository repository;

	public UserFinderService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Map<String, Object> findOne(Identity userId, String projection) {
		return repository.findOne(userId.toUUID(), UserProjection.valueOf(projection));
	}

	@Override
	public Map<String, Map<String, Object>> findAll(String projection) {
		return repository.findAll(UserProjection.valueOf(projection));
	}

}
