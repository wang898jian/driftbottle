package sse.ustc.driftbottle.impl;

import java.io.File;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sse.ustc.driftbottle.DAO.Bottle;
import sse.ustc.driftbottle.DAO.BottleDAO;
import sse.ustc.driftbottle.DAO.Friends;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import com.sun.research.ws.wadl.Application;

@Entity
@Path("/mybottle")
public class BottleImpl {
	@GET
	@Path("/getbottle")
	@Produces({ MediaType.APPLICATION_JSON })
	public Bottle getBottle(@FormParam("userid") String userId) {
		BottleDAO tmpBottleDAO = new BottleDAO();
		
	}
	
	@POST
	@Path("/sendbottle")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sendBottle() {
		
	}
}
