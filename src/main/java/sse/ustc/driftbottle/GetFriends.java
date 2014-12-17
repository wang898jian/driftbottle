package sse.ustc.driftbottle;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sse.ustc.driftbottle.data.Friends;

@Path("/myresource")
public class GetFriends{

	// TODO: update the class to suit your needs

	// The Java method will process HTTP GET requests
	@GET
	// The Java method will produce content identified by the MIME Media
	@Produces({MediaType.APPLICATION_JSON})
	public Friends getFriends() {
		Friends a = new Friends();
		return a;
	}
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON,MediaType.MULTIPART_FORM_DATA})
	public Friends getMuliFriends() {
		Friends a = new Friends();
		return a;
	}
}
