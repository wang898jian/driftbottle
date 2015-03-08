package sse.ustc.driftbottle.DAO;

/**
 * Accessory entity. @author MyEclipse Persistence Tools
 */

public class Accessory implements java.io.Serializable {

	// Fields

	private Integer accessoryId;
	private Bottle bottle;
	private Massage massage;
	private Userinfo userinfo;
	private Integer accessoryType;
	private String accessoryUrl;

	// Constructors

	/** default constructor */
	public Accessory() {
	}

	/** minimal constructor */
	public Accessory(Bottle bottle, Massage massage, Userinfo userinfo) {
		this.bottle = bottle;
		this.massage = massage;
		this.userinfo = userinfo;
	}

	/** full constructor */
	public Accessory(Bottle bottle, Massage massage, Userinfo userinfo,
			Integer accessoryType, String accessoryUrl) {
		this.bottle = bottle;
		this.massage = massage;
		this.userinfo = userinfo;
		this.accessoryType = accessoryType;
		this.accessoryUrl = accessoryUrl;
	}

	// Property accessors

	public Integer getAccessoryId() {
		return this.accessoryId;
	}

	public void setAccessoryId(Integer accessoryId) {
		this.accessoryId = accessoryId;
	}

	public Bottle getBottle() {
		return this.bottle;
	}

	public void setBottle(Bottle bottle) {
		this.bottle = bottle;
	}

	public Massage getMassage() {
		return this.massage;
	}

	public void setMassage(Massage massage) {
		this.massage = massage;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
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