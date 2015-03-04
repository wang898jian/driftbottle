package sse.ustc.driftbottle.pojo;

/**
 * Friends entity. @author MyEclipse Persistence Tools
 */

public class Friends implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Userinfo userinfo;
	private Integer friendId;
	private String friendName;

	// Constructors

	/** default constructor */
	public Friends() {
	}

	/** minimal constructor */
	public Friends(Integer userId, Userinfo userinfo) {
		this.userId = userId;
		this.userinfo = userinfo;
	}

	/** full constructor */
	public Friends(Integer userId, Userinfo userinfo, Integer friendId,
			String friendName) {
		this.userId = userId;
		this.userinfo = userinfo;
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

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
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