package sse.ustc.driftbottle.DAO;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Bottle entity. @author MyEclipse Persistence Tools
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Bottle implements java.io.Serializable {

	// Fields
	@JsonIgnore
	private Integer Id;
	private String bottleId;

	private Integer bottleType;

	private Integer senderUserId;

	public Integer getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId() {
		this.senderUserId = userinfoBySenderUserId.getUserId();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setSenderUserId(Integer senderUserId) {
		this.senderUserId = senderUserId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserId() {
		try {
			this.userId = userinfoByUserId.getUserId();
		} catch (Exception e) {
		}
	}

	private Integer userId;
	@JsonIgnore
	private Userinfo userinfoByUserId;
	@JsonIgnore
	private Userinfo userinfoBySenderUserId;

	private Set messages = new HashSet(0);
	private Set accessories = new HashSet(0);

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

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
		try {
			userId = this.userinfoByUserId.getUserId();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.userinfoByUserId = userinfoByUserId;
	}

	public Userinfo getUserinfoBySenderUserId() {
		return this.userinfoBySenderUserId;
	}

	public void setUserinfoBySenderUserId(Userinfo userinfoBySenderUserId) {
		try {
			senderUserId = userinfoBySenderUserId.getUserId();
		} catch (Exception e) {
			// TODO: handle exception
		}
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