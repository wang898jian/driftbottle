package sse.ustc.driftbottle.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String realName;
	private String userAddress;
	private Set friendses = new HashSet(0);
	private Set bottles = new HashSet(0);
	private Set loginformations = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
	}

	/** minimal constructor */
	public Userinfo(Integer userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	/** full constructor */
	public Userinfo(Integer userId, String userName, String realName,
			String userAddress, Set friendses, Set bottles, Set loginformations) {
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.userAddress = userAddress;
		this.friendses = friendses;
		this.bottles = bottles;
		this.loginformations = loginformations;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Set getFriendses() {
		return this.friendses;
	}

	public void setFriendses(Set friendses) {
		this.friendses = friendses;
	}

	public Set getBottles() {
		return this.bottles;
	}

	public void setBottles(Set bottles) {
		this.bottles = bottles;
	}

	public Set getLoginformations() {
		return this.loginformations;
	}

	public void setLoginformations(Set loginformations) {
		this.loginformations = loginformations;
	}

}