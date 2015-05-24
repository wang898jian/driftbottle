package sse.ustc.driftbottle.DAO;

import java.util.HashSet;
import java.util.Set;

/**
 * Bottle entity. @author MyEclipse Persistence Tools
 */

public class Bottle implements java.io.Serializable {

	// Fields
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	private String bottleId;
	private Userinfo userinfoByUserId;
	private Userinfo userinfoBySenderUserId;
	private Integer bottleType;
	private Set messages = new HashSet(0);
	private Set accessories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Bottle() {
	}

	/** minimal constructor */
	public Bottle(String bottleId, Userinfo userinfoByUserId) {
		this.bottleId = bottleId;
		this.userinfoByUserId = userinfoByUserId;
	}

	/** full constructor */
	public Bottle(String bottleId, Userinfo userinfoByUserId,
			Userinfo userinfoBySenderUserId, Integer bottleType, Set messages,
			Set accessories) {
		this.bottleId = bottleId;
		this.userinfoByUserId = userinfoByUserId;
		this.userinfoBySenderUserId = userinfoBySenderUserId;
		this.bottleType = bottleType;
		this.messages = messages;
		this.accessories = accessories;
	}

	// Property accessors
	public Boolean isEmpty() {
		if (bottleId.equals(null)) {
			return true;
		} else {
			return false;
		}
	}

	public String getBottleId() {
		return this.bottleId;
	}

	public void setBottleId(String bottleId) {
		this.bottleId = bottleId;
	}

	public Userinfo getUserinfoByUserId() {
		return this.userinfoByUserId;
	}

	public void setUserinfoByUserId(Userinfo userinfoByUserId) {
		this.userinfoByUserId = userinfoByUserId;
	}

	public Userinfo getUserinfoBySenderUserId() {
		return this.userinfoBySenderUserId;
	}

	public void setUserinfoBySenderUserId(Userinfo userinfoBySenderUserId) {
		this.userinfoBySenderUserId = userinfoBySenderUserId;
	}

	public Integer getBottleType() {
		return this.bottleType;
	}

	public void setBottleType(Integer bottleType) {
		this.bottleType = bottleType;
	}

	public Set getMessages() {
		return this.messages;
	}

	public void setMessages(Set messages) {
		this.messages = messages;
	}

	public Set getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set accessories) {
		this.accessories = accessories;
	}

}