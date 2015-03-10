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
	private String text;
	private Integer senderUserId;
	private Set accessories = new HashSet(0);

	// Constructors

	/** default constructor */
	public Massage() {
	}

	/** minimal constructor */
	public Massage(Bottle bottle, Integer userId, String text) {
		this.bottle = bottle;
		this.userId = userId;
		this.text = text;
	}

	/** full constructor */
	public Massage(Bottle bottle, Integer userId, String text,
			Integer senderUserId, Set accessories) {
		this.bottle = bottle;
		this.userId = userId;
		this.text = text;
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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