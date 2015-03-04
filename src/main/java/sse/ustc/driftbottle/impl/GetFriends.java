package sse.ustc.driftbottle.impl;

import java.io.File;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sse.ustc.driftbottle.DAO.FriendsDAO;
import sse.ustc.driftbottle.DAO.LoginformationDAO;
import sse.ustc.driftbottle.pojo.Friends;
import sse.ustc.driftbottle.pojo.Loginformation;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

@Entity
@Path("/myresource")
public class GetFriends {
	// TODO: update the class to suit your needs
	// The Java method will process HTTP GET requests
	@GET
	// The Java method will produce content identified by the MIME Media
	@Produces({ MediaType.APPLICATION_JSON })
	public Friends getFriends() {
		Friends a = new Friends();
		// 存库的实现
		FriendsDAO aDao = new FriendsDAO();
		aDao.save(a);
		return a;
	}

	@GET
	@Path("/list")
	@Produces({ MediaType.MULTIPART_FORM_DATA })
	public FormDataMultiPart getMuliFriends() {
		Friends a = new Friends();
		File f = new File("F:/project_bottle/DriftBottle.sql");
		FileDataBodyPart b = new FileDataBodyPart("file", f,
				MediaType.APPLICATION_JSON_TYPE);
		FormDataMultiPart a1 = new FormDataMultiPart();
		a1.bodyPart(b);
		File d = new File("F:/project_bottle/11121.txt");
		FileDataBodyPart c = new FileDataBodyPart("file", d,
				MediaType.APPLICATION_JSON_TYPE);
		a1.bodyPart(c);
		return a1;
	}

	@GET
	@Path("/226")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getString() {
		String c11 = new String("we are best!");
		return c11;
	}

	@POST
	@Path("/loginUser")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean loginUser(@FormParam("userName") String userName,
			@FormParam("passwd") String passwd) {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		System.out.println(userName);
		System.out.println(passwd);
		Loginformation logInfo = new Loginformation();
		logInfo.setUserName(userName);
		logInfo.setPassWd(passwd);
		LoginformationDAO logInforDao = new LoginformationDAO();
		if (logInforDao.findById(userName) == null) {
			return false;
		} else {
			return true;// 应该把状态置为online
		}
	}

	@POST
	@Path("/registUser")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean registUser(@FormParam("username") String userName,
			@FormParam("passwd") String passwd) {
		System.out.println(userName);
		System.out.println(passwd);
		Loginformation logInfo = new Loginformation();
		logInfo.setUserName(userName);
		logInfo.setPassWd(passwd);
		LoginformationDAO logInforDao = new LoginformationDAO();
		if (logInforDao.findByProperty("userName", userName) == null) {
			logInforDao.save(logInfo);
			return true;
		} else
			return false;
	}

//	@POST
//	@Path("/addJson")
//	@Produces(MediaType.TEXT_PLAIN)
//	@Consumes({ MediaType.APPLICATION_JSON })
//	public String addJson(userTest name) {
//		// File f = new File("c:/project_bottle/DriftBottle.txt");
//		System.out.println(name.getName());
//		System.out.println(name.getPassword());
//		return "asdfasdfasd";
//	}

	@POST
	@Path("/addJson1")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({ MediaType.APPLICATION_JSON })
	public String addJson1(@PathParam("Name") int name,
			@PathParam("Password") int password) {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		System.out.println(name);
		System.out.println(password);
		return "asdfasdfasd";
	}

	@POST
	@Path("/addJson2")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({ MediaType.APPLICATION_JSON })
	public String addJPG(@PathParam("Name") String name,
			@PathParam("Password") String password) {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		System.out.println(name);
		System.out.println(password);
		return "asdfasdfasd";
	}

	@POST
	@Path("/addJson3")
	@Produces(MediaType.TEXT_PLAIN)
	public String addImage(@FormParam("Name") File name) {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		System.out.println(name);
		return "asdfasdfasd";
	}
}
