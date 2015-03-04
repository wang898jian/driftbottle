package sse.ustc.driftbottle.DAO;

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
	private String userState;
	private Friends friends;
	private Set bottles = new HashSet(0);
	private Loginformation loginformation;

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
			String userAddress, String userState, Friends friends, Set bottles,
			Loginformation loginformation) {
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.userAddress = userAddress;
		this.userState = userState;
		this.friends = friends;
		this.bottles = bottles;
		this.loginformation = loginformation;
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

	public String getUserState() {
		return this.userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public Friends getFriends() {
		return this.friends;
	}

	public void setFriends(Friends friends) {
		this.friends = friends;
	}

	public Set getBottles() {
		return this.bottles;
	}

	public void setBottles(Set bottles) {
		this.bottles = bottles;
	}

	public Loginformation getLoginformation() {
		return this.loginformation;
	}

	public void setLoginformation(Loginformation loginformation) {
		this.loginformation = loginformation;
	}

}