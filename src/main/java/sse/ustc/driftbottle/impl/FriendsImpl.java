package sse.ustc.driftbottle.impl;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import sse.ustc.driftbottle.DAO.Bottle;
import sse.ustc.driftbottle.DAO.BottleDAO;
import sse.ustc.driftbottle.DAO.Friends;
import sse.ustc.driftbottle.DAO.FriendsDAO;
import sse.ustc.driftbottle.DAO.Message;
import sse.ustc.driftbottle.DAO.MessageDAO;
import sse.ustc.driftbottle.DAO.Userinfo;
import sse.ustc.driftbottle.DAO.UserinfoDAO;

@Entity
@Path("/contMyfrd")
public class FriendsImpl {
	@POST
	@Path("/addFriends")
	@Produces(MediaType.TEXT_PLAIN)
	public String addFriends(@FormParam("userId") Integer userId,
			@FormParam("friendId") Integer friendId) {
		FriendsDAO friendsDAO = new FriendsDAO();
		Friends tmp = new Friends();
		tmp.setUserId(userId);
		List<Friends> friendsList = friendsDAO.findByProperty("userId", tmp);
		for (Friends friends : friendsList) {
			if (friends.getFriendId()==friendId) {
				return "false";
			}
		}
		UserinfoDAO userinfoDAO = new UserinfoDAO();
		
		Userinfo userinfo = new Userinfo();
		userinfo.setId(userId);
		userinfo = (Userinfo)userinfoDAO.findByProperty("userId", userinfo).get(0);
		
		Userinfo friendInfo = new Userinfo();
		friendInfo.setId(friendId);
		friendInfo = (Userinfo)userinfoDAO.findByProperty("userId", friendInfo).get(0);
		
		tmp.setFriendId(friendId);
		tmp.setFriendName(friendInfo.getUserName());
		tmp.setUserinfo(userinfo);
		tmp.setUserId(userId);
		friendsDAO.attachDirty(tmp);
		return "true";
	}
	
}
