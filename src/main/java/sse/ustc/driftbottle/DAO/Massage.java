package sse.ustc.driftbottle.DAO;

import java.util.HashSet;
import java.util.Set;

/**
 * Massage entity. @author MyEclipse Persistence Tools
 */

public class Massage implements java.io.Serializable {

	// Fields

	private Integer massageId;
	private Bottle bottle;
	private Integer userId;
	private Integer massageType;
	private Integer senderUserId;
	private Set accessories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Massage() {
	}

	/** minimal constructor */
	public Massage(Bottle bottle, Integer userId) {
		this.bottle = bottle;
		this.userId = userId;
	}

	/** full constructor */
	public Massage(Bottle bottle, Integer userId, Integer massageType,
			Integer senderUserId, Set accessories) {
		this.bottle = bottle;
		this.userId = userId;
		this.massageType = massageType;
		this.senderUserId = senderUserId;
		this.accessories = accessories;
	}

	// Property accessors

	public Integer getMassageId() {
		return this.massageId;
	}

	public void setMassageId(Integer massageId) {
		this.massageId = massageId;
	}

	public Bottle getBottle() {
		return this.bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMassageType() {
		return this.massageType;
	}

	public void setMassageType(Integer massageType) {
		this.massageType = massageType;
	}

	public Integer getSenderUserId() {
		return this.senderUserId;
	}

	public void setSenderUserId(Integer senderUserId) {
		this.senderUserId = senderUserId;
	}

	public Set getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set accessories) {
		this.accessories = accessories;
	}

}