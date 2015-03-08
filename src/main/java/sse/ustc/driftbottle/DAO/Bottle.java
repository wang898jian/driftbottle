package sse.ustc.driftbottle.DAO;

import java.util.HashSet;
import java.util.Set;

/**
 * Bottle entity. @author MyEclipse Persistence Tools
 */

public class Bottle implements java.io.Serializable {

	// Fields

	private Integer bottleId;
	private Userinfo userinfoByUserId;
	private Userinfo userinfoBySenderUserId;
	private Integer bottleType;
	private Set accessories = new HashSet(0);
	private Set massages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Bottle() {
	}

	/** minimal constructor */
	public Bottle(Integer bottleId, Userinfo userinfoByUserId) {
		this.bottleId = bottleId;
		this.userinfoByUserId = userinfoByUserId;
	}

	/** full constructor */
	public Bottle(Integer bottleId, Userinfo userinfoByUserId,
			Userinfo userinfoBySenderUserId, Integer bottleType,
			Set accessories, Set massages) {
		this.bottleId = bottleId;
		this.userinfoByUserId = userinfoByUserId;
		this.userinfoBySenderUserId = userinfoBySenderUserId;
		this.bottleType = bottleType;
		this.accessories = accessories;
		this.massages = massages;
	}

	// Property accessors

	public Integer getBottleId() {
		return this.bottleId;
	}

	public void setBottleId(Integer bottleId) {
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

	public Set getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set accessories) {
		this.accessories = accessories;
	}

	public Set getMassages() {
		return this.massages;
	}

	public void setMassages(Set massages) {
		this.massages = massages;
	}

}