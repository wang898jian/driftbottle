package sse.ustc.driftbottle.DAO;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Accessory entity. @author MyEclipse Persistence Tools
 */
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Accessory implements java.io.Serializable {

	// Fields
	@JsonIgnore
	private Integer Id;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	private String accessoryId;
	@JsonIgnore
	private Bottle bottle;
	@JsonIgnore
	private Userinfo userinfo;
	@JsonIgnore
	private Message message;
	private String accessoryType;
	private String accessoryUrl;

	// Constructors

	/** default constructor */
	public Accessory() {
	}

	/** minimal constructor */
	public Accessory(String accessoryId, Bottle bottle, Userinfo userinfo,
			Message message) {
		this.accessoryId = accessoryId;
		this.bottle = bottle;
		this.userinfo = userinfo;
		this.message = message;
	}

	/** full constructor */
	public Accessory(String accessoryId, Bottle bottle, Userinfo userinfo,
			Message message, String accessoryType, String accessoryUrl) {
		this.accessoryId = accessoryId;
		this.bottle = bottle;
		this.userinfo = userinfo;
		this.message = message;
		this.accessoryType = accessoryType;
		this.accessoryUrl = accessoryUrl;
	}

	// Property accessors

	public String getAccessoryId() {
		return this.accessoryId;
	}

	public void setAccessoryId(String accessoryId) {
		this.accessoryId = accessoryId;
	}

	public Bottle getBottle() {
		return this.bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getAccessoryType() {
		return this.accessoryType;
	}

	public void setAccessoryType(String accessoryType) {
		this.accessoryType = accessoryType;
	}

	public String getAccessoryUrl() {
		return this.accessoryUrl;
	}

	public void setAccessoryUrl(String accessoryUrl) {
		this.accessoryUrl = accessoryUrl;
	}

}