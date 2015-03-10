package sse.ustc.driftbottle.impl;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.omg.PortableInterceptor.SUCCESSFUL;

import java.util.List;
import sse.ustc.driftbottle.DAO.Bottle;
import sse.ustc.driftbottle.DAO.BottleDAO;
import sse.ustc.driftbottle.DAO.Friends;
import sse.ustc.driftbottle.DAO.Massage;
import sse.ustc.driftbottle.DAO.MassageDAO;
import sse.ustc.driftbottle.DAO.TmpFriends;

@Entity
@Path("/mybottle")
public class BottleImpl {
	@POST
	@Path("/getMyBottles")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Bottle> getBottle(@FormParam("userId") String userId) {
		BottleDAO tmpBottleDAO = new BottleDAO();
		List<Bottle> bottles = tmpBottleDAO.findByProperty("userId", userId);
		return bottles;
	}
	
	@POST
	@Path("/getMyFriends")
	@Consumes({ MediaType.APPLICATION_JSON })
	public String getFriend(Friends friend) {
		System.out.println(friend.getFriendName());
		System.out.println(friend.getFriendId());
		System.out.println(friend.getUserId());
		return "true";
	}

	@POST
	@Path("/getOneBottle")
	@Produces({ MediaType.APPLICATION_JSON })
	public Bottle receiveBottle(@FormParam("userId") String userId) {
		BottleDAO tmpBottleDAO = new BottleDAO();
		Bottle bottle = (Bottle) tmpBottleDAO.findByPropertyNoMemb("userId",
				userId);
		return bottle;
	}

	@POST
	@Path("/sendNewBottle")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sendNewBottle(@FormParam("userId") String userId,
			@FormParam("bottleType") Integer bottleType,
			@FormParam("massageText") String text) {
		BottleDAO tmpBottleDAO = new BottleDAO();
		Bottle tmpBottle = new Bottle();
		tmpBottle.setBottleType(bottleType);
		tmpBottleDAO.save(tmpBottle);
		
		MassageDAO tmpMassageDAO = new MassageDAO();
		Massage tmpMassage = new Massage();
		tmpMassage.setText(text);
		tmpMassage.setBottle(tmpBottle);
		tmpMassageDAO.save(tmpMassage);

		return "false";
	}
	
	@POST
	@Path("/sendOtherBottle")
	@Produces({ MediaType.TEXT_PLAIN })
	public String sendOtherBottle(@FormParam("userId") String userId,
			@FormParam("bottleType") Integer bottleType,
			@FormParam("massageText") String text) {
		BottleDAO tmpBottleDAO = new BottleDAO();
		Bottle tmpBottle = new Bottle();
		tmpBottle.setBottleType(bottleType);
		tmpBottleDAO.save(tmpBottle);
		
		MassageDAO tmpMassageDAO = new MassageDAO();
		Massage tmpMassage = new Massage();
		tmpMassage.setText(text);
		tmpMassage.setBottle(tmpBottle);
		tmpMassageDAO.save(tmpMassage);

		return "true";
	}
}
