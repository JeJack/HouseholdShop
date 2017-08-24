package org.adam.householdshop.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class OrfinaryUser extends AbstractUser {
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Offer> publishedOffers;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.REFRESH)
	private List<Offer> observedOffers;
	
	public List<Offer> getPublishedOffers() {
		return publishedOffers;
	}
	public List<Offer> getObservedOffers() {
		return observedOffers;
	}
	public void setPublishedOffers(List<Offer> publishedOffers) {
		this.publishedOffers = publishedOffers;
	}
	public void setObservedOffers(List<Offer> observedOffers) {
		this.observedOffers = observedOffers;
	}
}
