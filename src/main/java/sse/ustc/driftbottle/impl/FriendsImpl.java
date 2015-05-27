package sse.ustc.driftbottle.impl;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import javax.activation.MimetypesFileTypeMap;
import javax.persistence.Entity;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sse.ustc.driftbottle.DAO.Accessory;
import sse.ustc.driftbottle.DAO.AccessoryDAO;
import sse.ustc.driftbottle.DAO.Bottle;
import sse.ustc.driftbottle.DAO.BottleDAO;
import sse.ustc.driftbottle.DAO.Friends;
import sse.ustc.driftbottle.DAO.Loginformation;
import sse.ustc.driftbottle.DAO.LoginformationDAO;
import sse.ustc.driftbottle.DAO.Message;
import sse.ustc.driftbottle.DAO.MessageDAO;
import sse.ustc.driftbottle.DAO.Userinfo;
import sse.ustc.driftbottle.DAO.UserinfoDAO;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.multipart.file.FileDataBodyPart;
@Entity
@Path("/myresource")
public class FriendsImpl {
	// TODO: update the class to suit your needs
	// The Java method will process HTTP GET requests
	// @GET
	// // The Java method will produce content identified by the MIME Media
	// @Produces({ MediaType.APPLICATION_JSON })
	// public Friends getFriends() {
	// Friends a = new Friends();
	// // 存库的实现
	// FriendsDAO aDao = new FriendsDAO();
	// aDao.save(a);
	// return a;
	// }
	//

	//
	// @GET
	// @Path("/226ddd")
	// @Produces({ MediaType.TEXT_PLAIN })
	// public String getString() {
	// String userName = "nam5";
	// String passwd = "123456";
	// System.out.println(userName);
	// System.out.println(passwd);
	// Loginformation logInfo = new Loginformation();
	// logInfo.setUserName(userName);
	// logInfo.setPassWd(passwd);
	// LoginformationDAO logInforDao = new LoginformationDAO();
	// UserinfoDAO relatinfoDAO = new UserinfoDAO();
	// Userinfo relatinfo = new Userinfo();
	// relatinfo.setUserName(userName);
	// if (logInforDao.findByProperty("userName", userName).isEmpty()) {
	// relatinfoDAO.save(relatinfo);
	// logInforDao.save(logInfo);
	// return relatinfo.getUserId().toString();
	// } else
	// return "false";
	// }

	@POST
	@Path("/sendBottle")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendBottle(@FormParam("bottleId") String bottleID,
			@FormParam("bottleType") Integer bottleType,
			@FormParam("senderId") Integer senderID) {
		System.out.println(bottleID);
		System.out.println(bottleType);
		System.out.println(senderID);
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		Userinfo userinfo = userinfoDAO.findById(senderID);
		if (userinfo == null) {
			System.out.println("can't find user!");
			return "-1";
		}
		BottleDAO bottleDAO = new BottleDAO();
		Bottle bottle = new Bottle();
		bottle.setBottleId(bottleID);
		bottle.setBottleType(bottleType);
		bottle.setUserinfoBySenderUserId(userinfo);
		bottleDAO.attachDirty(bottle);
		return "true";
	}

	@POST
	@Path("/sendMessage")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	// bottleID messageID text senderUserID
	public String sendMassage(Message message) {
		System.out.print(message.getText());
		System.out.println("ooooaaaa");
		BottleDAO bottleDAO = new BottleDAO();
		Bottle bottle;
		if (bottleDAO.findByProperty("bottleId", message.getBottleId())
				.isEmpty()) {
			return "can't find the bottle!";
		} else {
			bottle = (Bottle) bottleDAO.findByProperty("bottleId",
					message.getBottleId()).get(0);
		}
		message.setBottle(bottle);
		bottleDAO.attachDirty(bottle);
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.attachDirty(message);
		return "true";
	}

	// @GET
	// @Path("/sendMessage")
	// @Produces(MediaType.TEXT_PLAIN)
	// // bottleID messageID text senderUserID
	// public String sendMassageTmp() {
	// Message message = new Message();
	// message.setBottleId("78565");
	// message.setMessageId("15132151");
	// message.setText("21351231");
	// message.setSenderUserId(7);
	// System.out.print(message.getText());
	// System.out.println("ooooaaaa");
	// BottleDAO bottleDAO = new BottleDAO();
	// Bottle bottle;
	// if (bottleDAO.findByProperty("bottleId", message.getBottleId())
	// .isEmpty()) {
	// return "can't find the bottle!";
	// } else {
	// bottle = (Bottle) bottleDAO.findByProperty("bottleId",
	// message.getBottleId()).get(0);
	// }
	// if (bottle.getId() == null) {
	// System.out.println("132151321");
	// }
	// System.out.println(bottle.getId());
	// System.out.println(bottle.getBottleId());
	// message.setBottle(bottle);
	// System.out.println(message.getBottle().getBottleId());
	// bottleDAO.attachDirty(bottle);
	// MessageDAO messageDAO = new MessageDAO();
	// messageDAO.attachDirty(message);
	// return "true";
	// }

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
		System.out.println("flag is here!");
		if (tmpInfo.getUserName().isEmpty()) {
			System.out.println("input is null!");
			return "-1";
		} else {
			System.out.println("input is not null!");
			if (tmpInfo.getPassWd().equals(passwd) == false) {
				System.out.println("passwd is wrong!");
				return "-1";
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
				System.out.println(logInfo.getUserId());
				return logInfo.getUserId().toString();
			}
		}
	}

	@POST
	@Path("/sendAccessory")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_HTML)
	public String sendAccessory(
			@FormDataParam("accessory") InputStream file,
			@FormDataParam("accessory") FormDataContentDisposition fileDisposition,
			@FormDataParam("accessoryId") String accessoryId,
			@FormDataParam("messageId") String messageId) {

		String fileFullName = fileDisposition.getFileName();
		String expandName = fileFullName.substring(fileFullName.indexOf("."),
				fileFullName.length());
		System.out.println(expandName);
		System.out.println(fileFullName);
		System.out.println(accessoryId);
		System.out.println(messageId);
		int i = 10;
		System.out.println("0" + i);

		try {
			OutputStream outputStream = new FileOutputStream(new File(
					"C:\\upload", accessoryId + expandName));
			int length = 0;

			byte[] buff = new byte[256];

			while (-1 != (length = file.read(buff))) {
				outputStream.write(buff, 0, length);
			}
			file.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return e.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return e.toString();
		}

		// 没有异常，逻辑存库
		Accessory accessory = new Accessory();
		accessory.setAccessoryId(accessoryId);
		accessory.setAccessoryType(expandName);
		MessageDAO messageDAO = new MessageDAO();
		Message message = (Message) messageDAO.findByProperty("messageId",
				messageId).get(0);
		if (message.isEmpty()) {
			System.out.println("can't find message, ID:" + messageId);
			return "can't find message";
		}
		messageDAO.attachDirty(message);
		accessory.setMessage(message);
		AccessoryDAO accessoryDAO = new AccessoryDAO();
		accessoryDAO.attachDirty(accessory);
		return "true";
	}

	@POST
	@Path("/getAccessory")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public FormDataMultiPart getAccessory(
			@FormParam("messageId") String messageId) {
		AccessoryDAO accessoryDAO = new AccessoryDAO();
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		List<Accessory> accessories = accessoryDAO.findByProperty("messageId",
				messageId);
		Integer i = 0;
		for (; i < accessories.size(); i++) {
			Accessory accessoryTmp = accessories.get(i);
			File tmpFile = new File("C:\\upload", accessoryTmp.getAccessoryId()
					+ accessoryTmp.getAccessoryType());
			FileDataBodyPart TmpBodyPart = new FileDataBodyPart(i.toString(),
					tmpFile);
			formDataMultiPart.bodyPart(TmpBodyPart);
		}
		formDataMultiPart.field("numbOfFile", i.toString());
		return formDataMultiPart;
	}

	@GET
	@Path("{imageName}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public void getAccessory(@Context HttpServletResponse response,
			@PathParam("imageName") String imageName) throws Exception{
	File pathsavefile = new File("C:\\upload", imageName);
	response.reset(); 
	response.setContentType("APPLICATION/OCTET-STREAM"); 
	imageName=response.encodeURL(new String(imageName.getBytes(),"UTF-8"));//转码 
	response.setHeader("Content-Disposition", "attachment; filename=\""+imageName+"\"");
	ServletOutputStream out = response.getOutputStream(); 
	InputStream inStream=new FileInputStream(pathsavefile); 
	byte[] b = new byte[1024]; 
	int len; 
	while((len=inStream.read(b)) >0) 
	out.write(b,0,len); 
	response.setStatus( response.SC_OK ); 
	response.flushBuffer(); 
	out.close(); 
	inStream.close();
	return;
	}
	
	
	@POST
	@Path("/getMessage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@FormParam("bottleId") String bottleId) {
		MessageDAO messageDAO = new MessageDAO();
		List<Message> messages = messageDAO
				.findByProperty("bottleId", bottleId);
		return messages;
	}

	
	
	@POST
	@Path("/getUserBottle")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bottle> getUserBottle(
			@FormParam("senderUserId") String senderUserId) {
		BottleDAO bottleDAO = new BottleDAO();
		List<Bottle> bottles = bottleDAO.findByProperty("senderUserId",
				senderUserId);
		return bottles;
	}

	@POST
	@Path("/getRandomBottle")
	@Produces(MediaType.APPLICATION_JSON)
	public Bottle getRandomBottle(@FormParam("userId") String userId) {
		BottleDAO bottleDAO = new BottleDAO();
		List<Bottle> bottles = bottleDAO.findByProperty("userId", "");
		Integer sizeInteger = bottles.size();
		Random random = new Random();
		Bottle bottle;
		Integer numb = 0;
		do {
			Integer tmpInteger = Math.abs(random.nextInt() % sizeInteger);
			bottle = bottles.get(tmpInteger);
			numb++;
		} while (bottle.getUserinfoBySenderUserId().getUserId().equals(userId)
				|| numb < sizeInteger);
		if (numb > sizeInteger) {
			bottle.setId(-1);
		}
		return bottle;
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
}
