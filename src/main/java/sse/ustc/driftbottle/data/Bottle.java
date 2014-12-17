package sse.ustc.driftbottle.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Bottle entity. @author MyEclipse Persistence Tools
 */

public class Bottle implements java.io.Serializable {

	// Fields

	private BottleId id;
	private Integer bottleType;
	private Integer senderUserId;
	private Set massages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Bottle() {
	}

	/** minimal constructor */
	public Bottle(BottleId id) {
		this.id = id;
	}

	/** full constructor */
	public Bottle(BottleId id, Integer bottleType, Integer senderUserId,
			Set massages) {
		this.id = id;
		this.bottleType = bottleType;
		this.senderUserId = senderUserId;
		this.massages = massages;
	}

	// Property accessors

	public BottleId getId() {
		return this.id;
	}

	public void setId(BottleId id) {
		this.id = id;
	}

	public Integer getBottleType() {
		return this.bottleType;
	}

	public void setBottleType(Integer bottleType) {
		this.bottleType = bottleType;
	}

	public Integer getSenderUserId() {
		return this.senderUserId;
	}

	public void setSenderUserId(Integer senderUserId) {
		this.senderUserId = senderUserId;
	}

	public Set getMassages() {
		return this.massages;
	}

	public void setMassages(Set massages) {
		this.massages = massages;
	}

}