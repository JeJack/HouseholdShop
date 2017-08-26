package org.adam.householdshop.modules.finder;

import java.util.Map;
import java.util.UUID;

import org.adam.householdshop.enums.Projection;

public interface Repository {

	Map<String, Map<String, Object>> findAll(Projection projection);

	Map<String, Object> findOne(UUID id, Projection projection);

}