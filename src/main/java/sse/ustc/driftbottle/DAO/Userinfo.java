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
	private String firstBottleTime;
	private String lastBottleTime;
	private Set bottlesForSenderUserId = new HashSet(0);
	private Set messagesForUserId = new HashSet(0);
	private Friends friends;
	private Set bottlesForUserId = new HashSet(0);
	private Loginformation loginformation;
	private Set accessories = new HashSet(0);
	private Set messagesForSenderUserId = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo() {
		userId = -1;
	}

	/** minimal constructor */
	public Userinfo(Integer userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	/** full constructor */
	public Userinfo(Integer userId, String userName, String realName,
			String userAddress, String userState, String firstBottleTime,
			String lastBottleTime, Set bottlesForSenderUserId,
			Set messagesForUserId, Friends friends, Set bottlesForUserId,
			Loginformation loginformation, Set accessories,
			Set messagesForSenderUserId) {
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.userAddress = userAddress;
		this.userState = userState;
		this.firstBottleTime = firstBottleTime;
		this.lastBottleTime = lastBottleTime;
		this.bottlesForSenderUserId = bottlesForSenderUserId;
		this.messagesForUserId = messagesForUserId;
		this.friends = friends;
		this.bottlesForUserId = bottlesForUserId;
		this.loginformation = loginformation;
		this.accessories = accessories;
		this.messagesForSenderUserId = messagesForSenderUserId;
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

	public String getFirstBottleTime() {
		return this.firstBottleTime;
	}

	public void setFirstBottleTime(String firstBottleTime) {
		this.firstBottleTime = firstBottleTime;
	}

	public String getLastBottleTime() {
		return this.lastBottleTime;
	}

	public void setLastBottleTime(String lastBottleTime) {
		this.lastBottleTime = lastBottleTime;
	}

	public Set getBottlesForSenderUserId() {
		return this.bottlesForSenderUserId;
	}

	public void setBottlesForSenderUserId(Set bottlesForSenderUserId) {
		this.bottlesForSenderUserId = bottlesForSenderUserId;
	}

	public Set getMessagesForUserId() {
		return this.messagesForUserId;
	}

	public void setMessagesForUserId(Set messagesForUserId) {
		this.messagesForUserId = messagesForUserId;
	}

	public Friends getFriends() {
		return this.friends;
	}

	public void setFriends(Friends friends) {
		this.friends = friends;
	}

	public Set getBottlesForUserId() {
		return this.bottlesForUserId;
	}

	public void setBottlesForUserId(Set bottlesForUserId) {
		this.bottlesForUserId = bottlesForUserId;
	}

	public Loginformation getLoginformation() {
		return this.loginformation;
	}

	public void setLoginformation(Loginformation loginformation) {
		this.loginformation = loginformation;
	}

	public Set getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set accessories) {
		this.accessories = accessories;
	}

	public Set getMessagesForSenderUserId() {
		return this.messagesForSenderUserId;
	}

	public void setMessagesForSenderUserId(Set messagesForSenderUserId) {
		this.messagesForSenderUserId = messagesForSenderUserId;
	}

}