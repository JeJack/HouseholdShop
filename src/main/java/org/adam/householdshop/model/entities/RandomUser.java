package org.adam.householdshop.model.entities;

import java.util.List;

public class RandomUser extends User {
	private List<Offer> publishedOffers;
	private List<Offer> observedOffers;
	
	public List<Offer> getPublishedOffers() {
		return publishedOffers;
	}
	public List<Offer> getObservedOffers() {
		return observedOffers;
	}
}
