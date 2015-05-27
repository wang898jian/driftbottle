package sse.ustc.driftbottle.DAO;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils.Null;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields
	private Integer Id;
	private String messageId;
	private Bottle bottle;
	private String bottleId;
	private Userinfo userinfoByUserId;
	private Userinfo userinfoBySenderUserId;
	private Integer userId;
	private Integer senderUserId;
	private String text;
	private Set accessories = new HashSet(0);

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(String messageId, Bottle bottle, Userinfo userinfoByUserId,
			String text) {
		this.messageId = messageId;
		this.bottle = bottle;
		this.userinfoByUserId = userinfoByUserId;
		this.text = text;
	}

	/** tmp constructor */
	public Message(String messageId) {
		this.messageId = messageId;
	}

	/** full constructor */
	public Message(String messageId, Bottle bottle, Userinfo userinfoByUserId,
			Userinfo userinfoBySenderUserId, String text, Set accessories) {
		this.messageId = messageId;
		this.bottle = bottle;
		this.userinfoByUserId = userinfoByUserId;
		this.userinfoBySenderUserId = userinfoBySenderUserId;
		this.text = text;
		this.accessories = accessories;
	}

	// Property accessors

	public Boolean isEmpty() {
		if (messageId.equals(null)) {
			return true;
		} else {
			return false;
		}
	}

	public String getMessageId() {
		return this.messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public Bottle getBottle() {
		return this.bottle;
	}

	public String getBottleId() {
		return this.bottleId;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Set getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set accessories) {
		this.accessories = accessories;
	}

	public Integer getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(Integer senderUserId) {
		this.senderUserId = senderUserId;
	}

	public void setBottleId(String bottleId) {
		this.bottleId = bottleId;
	}

}