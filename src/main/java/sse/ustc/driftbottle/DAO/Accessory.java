package sse.ustc.driftbottle.DAO;

/**
 * Accessory entity. @author MyEclipse Persistence Tools
 */

public class Accessory implements java.io.Serializable {

	// Fields

	private String accessoryId;
	private Bottle bottle;
	private Userinfo userinfo;
	private Object message;
	private Integer accessoryType;
	private String accessoryUrl;

	// Constructors

	/** default constructor */
	public Accessory() {
	}

	/** minimal constructor */
	public Accessory(String accessoryId, Bottle bottle, Userinfo userinfo,
			Object message) {
		this.accessoryId = accessoryId;
		this.bottle = bottle;
		this.userinfo = userinfo;
		this.message = message;
	}

	/** full constructor */
	public Accessory(String accessoryId, Bottle bottle, Userinfo userinfo,
			Object message, Integer accessoryType, String accessoryUrl) {
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

	public Object getMessage() {
		return this.message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Integer getAccessoryType() {
		return this.accessoryType;
	}

	public void setAccessoryType(Integer accessoryType) {
		this.accessoryType = accessoryType;
	}

	public String getAccessoryUrl() {
		return this.accessoryUrl;
	}

	public void setAccessoryUrl(String accessoryUrl) {
		this.accessoryUrl = accessoryUrl;
	}

}