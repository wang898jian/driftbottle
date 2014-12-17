package sse.ustc.driftbottle.data;

import java.util.HashSet;
import java.util.Set;

/**
 * Massage entity. @author MyEclipse Persistence Tools
 */

public class Massage implements java.io.Serializable {

	// Fields

	private MassageId id;
	private Integer massageType;
	private Integer senderUserId;
	private Set accessories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Massage() {
	}

	/** minimal constructor */
	public Massage(MassageId id) {
		this.id = id;
	}

	/** full constructor */
	public Massage(MassageId id, Integer massageType, Integer senderUserId,
			Set accessories) {
		this.id = id;
		this.massageType = massageType;
		this.senderUserId = senderUserId;
		this.accessories = accessories;
	}

	// Property accessors

	public MassageId getId() {
		return this.id;
	}

	public void setId(MassageId id) {
		this.id = id;
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