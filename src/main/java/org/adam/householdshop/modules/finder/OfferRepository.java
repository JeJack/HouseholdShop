package org.adam.householdshop.modules.finder;

import java.util.Map;
import java.util.UUID;

import org.adam.householdshop.Projection;

public interface OfferRepository {

	Map<String, Object> findOne(UUID uuid, Projection valueOf);

	Map<String, Map<String, Object>> findAll(Projection projection);

}
