package org.adam.householdshop.modules.finder.services;

import java.util.Map;

import org.adam.householdshop.common.Identity;

public interface FinderService {

	Map<String, Object> findOne(Identity offerId, String projection);

	Map<String, Map<String, Object>> findAll(String projection);

}