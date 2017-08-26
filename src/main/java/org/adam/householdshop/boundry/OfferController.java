package org.adam.householdshop.boundry;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.adam.householdshop.OfferId;
import org.adam.householdshop.modules.finder.OfferFinderService;

@Path("offer")
@RequestScoped
public class OfferController {
	
	private final OfferFinderService offerFinder;
	
	public OfferController(OfferFinderService offerFinder) {
		this.offerFinder = offerFinder;
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") String id, @HeaderParam("content") String projection) {
		
		return Response.status(200)
				.entity(offerFinder.findOne(new OfferId(id), projection))
				.build();
	}
	
	@GET
	public Response findAll(@HeaderParam("content") String projection) {
		return Response.status(200)
				.entity(offerFinder.findAll(projection))
				.build();
	}
}
