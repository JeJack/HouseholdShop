package org.adam.householdshop.boundry;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.adam.householdshop.common.MessageId;
import org.adam.householdshop.modules.finder.services.MessageFinderService;

@Path("message")
@RequestScoped
public class MessageController {

	private final MessageFinderService messageFinder;

	public MessageController(MessageFinderService messageFinder) {
		this.messageFinder = messageFinder;
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") String id, @HeaderParam("content-type") String projection) {

		return Response.status(200).entity(messageFinder.findOne(new MessageId(id), projection)).build();
	}

	@GET
	public Response findAll(@HeaderParam("content") String projection) {
		return Response.status(200).entity(messageFinder.findAll(projection)).build();
	}
}
