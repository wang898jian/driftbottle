package sse.ustc.driftbottle.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sse.ustc.driftbottle.DAO.Bottle;
import sse.ustc.driftbottle.DAO.BottleDAO;
import sse.ustc.driftbottle.DAO.Friends;
import sse.ustc.driftbottle.DAO.FriendsDAO;
import sse.ustc.driftbottle.DAO.Loginformation;
import sse.ustc.driftbottle.DAO.LoginformationDAO;
import sse.ustc.driftbottle.DAO.Message;
import sse.ustc.driftbottle.DAO.MessageDAO;
import sse.ustc.driftbottle.DAO.Userinfo;
import sse.ustc.driftbottle.DAO.UserinfoDAO;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.file.FileDataBodyPart;

@Entity
@Path("/myresource")
public class FriendsImpl {
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
	@Path("/226ddd")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getString() {
		String userName = "nam5";
		String passwd = "123456";
		System.out.println(userName);
		System.out.println(passwd);
		Loginformation logInfo = new Loginformation();
		logInfo.setUserName(userName);
		logInfo.setPassWd(passwd);
		LoginformationDAO logInforDao = new LoginformationDAO();
		UserinfoDAO relatinfoDAO = new UserinfoDAO();
		Userinfo relatinfo = new Userinfo();
		relatinfo.setUserName(userName);
		if (logInforDao.findByProperty("userName", userName).isEmpty()) {
			relatinfoDAO.save(relatinfo);
			logInforDao.save(logInfo);
			return relatinfo.getUserId().toString();
		} else
			return "false";
	}

	@GET
	@Path("/loginUserTest")
	@Produces(MediaType.TEXT_PLAIN)
	public String loginUser() {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		String userName = "13675517749";
		String passwd = "123456";
		System.out.println(userName);
		System.out.println(passwd);

		LoginformationDAO logInforDao = new LoginformationDAO();
		Loginformation tmpInfo = (Loginformation) logInforDao.findByProperty(
				"userName", userName).get(0);

		if (tmpInfo.getUserName().isEmpty()) {
			System.out.println("input is null!");
			return "false";
		} else {
			if (!tmpInfo.getPassWd().equals(passwd)) {
				System.out.println("passwd is wrong!");
				return "false";
			} else {
				UserinfoDAO userinfo = new UserinfoDAO();
				Userinfo logInfo = (Userinfo) userinfo.findByUserName(userName)
						.get(0);
				System.out.println("find logInfo!");
				if (userinfo.findByUserName(userName).isEmpty()) {
					logInfo = new Userinfo();
				}
				logInfo.setUserName(userName);
				logInfo.setUserState("online");
				userinfo.attachDirty(logInfo);
				return "true";
			}
		}
	}
	
	
	@POST
	@Path("/sendBottle")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendBottle(
			@FormParam("bottleId") String bottleID,
			@FormParam("bottleType") Integer bottleType,
			@FormParam("senderUserId") Integer senderID) {
		UserinfoDAO userinfoDAO =new UserinfoDAO();
		Userinfo userinfo = userinfoDAO.findById(senderID);
		BottleDAO bottleDAO = new BottleDAO();
		Bottle bottle = new Bottle();
		bottle.setBottleId(bottleID);
		bottle.setBottleType(bottleType);
		bottle.setUserinfoBySenderUserId(userinfo);
		bottleDAO.attachDirty(bottle);
		return "false";
	}
	
	@POST
	@Path("/sendMessage")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String sendMassage(Message message) {
		System.out.print(message.getText());
		System.out.println("ooooaaaa");
		BottleDAO bottleDAO = new BottleDAO();
		Bottle bottle;
		if (bottleDAO.findById(message.getBottleId()).isEmpty()==false) {
			bottle = bottleDAO.findById(message.getBottleId());
		}else {
			bottle = new Bottle();
		}
		bottle.setBottleId(message.getBottleId());
		bottleDAO.attachDirty(bottle);
		message.setBottle(bottle);
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.attachDirty(message);
		return "true";
	}
	
	@POST
	@Path("/loginUser")
	@Produces(MediaType.TEXT_PLAIN)
	public String loginUser(@FormParam("userName") String userName,
			@FormParam("passwd") String passwd) {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		System.out.println(userName);
		System.out.println(passwd);

		LoginformationDAO logInforDao = new LoginformationDAO();
		Loginformation tmpInfo = (Loginformation) logInforDao.findByProperty(
				"userName", userName).get(0);

		if (tmpInfo.getUserName().isEmpty()) {
			System.out.println("input is null!");
			return "false";
		} else {
			if (!tmpInfo.getPassWd().equals(passwd)) {
				System.out.println("passwd is wrong!");
				return "false";
			} else {
				UserinfoDAO userinfo = new UserinfoDAO();
				Userinfo logInfo = (Userinfo) userinfo.findByUserName(userName)
						.get(0);
				System.out.println("find logInfo!");
				if (userinfo.findByUserName(userName).isEmpty()) {
					logInfo = new Userinfo();
				}
				logInfo.setUserName(userName);
				logInfo.setUserState("online");
				userinfo.attachDirty(logInfo);
				return "true";
			}
		}
	}

	@POST
	@Path("/sendFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendFile(FormDataMultiPart multiPart) throws IOException {
		if (multiPart == null) {
			System.out.println("multipart is Null!");
			return "false";
		}
		List<FormDataBodyPart> l= multiPart.getFields("file");
		Integer bottleID = Integer.parseInt(multiPart.getField("bottleID")
				.getValue());
		String name = multiPart.getField("type").getValue();
		String data = multiPart.getField("body").getValue();
		File fp = new File("accessory");
		System.out.println("i am in!");
		if (fp.mkdir())
			;
		File file = new File("accessory/" + bottleID + "/" + name);
		if (!file.exists()) {
			file.createNewFile();
		} else {
			return "the file" + name + " has already exist!";
		}
		FileWriter fileWritter = new FileWriter(file.getName(), true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write(data);
		bufferWritter.close();
		System.out.println("Done");
		return "success";
	}
	
	@POST
	@Path("/sendFile2")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendFile2(FormDataMultiPart multiPart) throws IOException {
		if (multiPart == null) {
			System.out.println("multipart is Null!");
			return "false";
		}
		List<FormDataBodyPart> l= multiPart.getFields("file");
		for (FormDataBodyPart p : l) {
			InputStream is=p.getValueAs(InputStream.class);
			FormDataContentDisposition detail=p.getFormDataContentDisposition();
			String rootPath=new File("").getAbsolutePath();
			rootPath+= File.separator+"webapps";

			//拼接文件目录
			String imageFileLocation = rootPath + File.separator+"res"+ File.separator
					+ System.currentTimeMillis() + "."
					+ p.getMediaType();
			File image=writeToFile(is, imageFileLocation);}
		return "success";
	}
	@POST
	@Path("/registUser")
	@Produces(MediaType.TEXT_PLAIN)
	public String registUser(@FormParam("userName") String userName,
			@FormParam("passwd") String passwd) {
		System.out.println(userName);
		System.out.println(passwd);
		Loginformation logInfo = new Loginformation();
		logInfo.setUserName(userName);
		logInfo.setPassWd(passwd);
		LoginformationDAO logInforDao = new LoginformationDAO();
		UserinfoDAO relatinfoDAO = new UserinfoDAO();
		Userinfo relatinfo = new Userinfo();
		relatinfo.setUserName(userName);
		if (logInforDao.findByProperty("userName", userName).isEmpty()) {
			relatinfoDAO.save(relatinfo);
			logInforDao.save(logInfo);
			return relatinfo.getUserId().toString();
		} else {
			return "false";
		}
	}

	@POST
	@Path("/saveFile")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String saveFile(@FormDataParam("file") InputStream imageInputStream,
			@FormDataParam("file") FormDataContentDisposition imageDetail,
			@FormParam("bottleID") String bottleID,
			@FormParam("accessoryID") String accessoryID) throws IOException {
		String rootPath = new File("").getAbsolutePath();
		rootPath += File.separator + "webapps";

		// 拼接文件目录
		String imageFileLocation = rootPath + File.separator + "res"
				+ File.separator + System.currentTimeMillis() + "."
				+ imageDetail.getType();
		File image = writeToFile(imageInputStream, imageFileLocation);
		return "success";
	}

	public static File writeToFile(InputStream is, String uploadedFileLocation) {
		// TODO Auto-generated method stub
		File file = new File(uploadedFileLocation);
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			byte buffer[] = new byte[4 * 1024];
			while ((is.read(buffer)) != -1) {
				os.write(buffer);
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(uploadedFileLocation + "文件大小" + file.length());
		if (file.length() < 5) {
			file.delete();
			return null;
		}
		return file;

	}

	@POST
	@Path("/addJson1")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({MediaType.APPLICATION_JSON})
	public String addJson1(@PathParam("Name") int name,
			@PathParam("Password") int password,
			@PathParam("messageId") String messageID,
			@PathParam("bottleId") String bottleID,
			@PathParam("senderUserId") Integer senderID,
			@PathParam("text") String text) {
		// File f = new File("c:/project_bottle/DriftBottle.txt");
		System.out.println(name);
		System.out.println(password);
		System.out.println(messageID);
		System.out.println(bottleID);
		System.out.println(senderID);
		System.out.println(text);
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
