package sse.ustc.driftbottle.DAO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Friends entity. @author MyEclipse Persistence Tools
 */

public class TmpFriends implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Integer friendId;
	private String friendName;

	// Constructors

	/** default constructor */
	public TmpFriends() {
		userId=0;
		friendId = 23;
		friendName = "asdfgasdf";
	}

	/** minimal constructor */
	public TmpFriends(Integer userId) {
		this.userId = userId;

	}

	/** full constructor */
	public TmpFriends(Integer userId, Integer friendId,
			String friendName) {
		this.userId = userId;
		this.friendId = friendId;
		this.friendName = friendName;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return this.friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return this.friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

}