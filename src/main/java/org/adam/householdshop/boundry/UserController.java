package org.adam.householdshop.boundry;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.adam.householdshop.common.UserId;
import org.adam.householdshop.modules.finder.services.UserFinderService;

@Path("user")
@RequestScoped
public class UserController {
	
	private final UserFinderService userFinder;
	
	public UserController(UserFinderService userFinder) {
		this.userFinder = userFinder;
	}

	@GET
	@Path("/{id}")
	public Response findOne(@PathParam("id") String uuid, @HeaderParam("content-type") String projection) {
		return Response.ok().entity(userFinder.findOne(new UserId(uuid), uuid)).build();
	}
	
	@GET
	public Response findAll(@HeaderParam("content-type") String projection) {
		return Response.ok().entity(userFinder.findAll(projection)).build();
	}
}
