package sse.ustc.driftbottle.data;

/**
 * Loginformation entity. @author MyEclipse Persistence Tools
 */

public class Loginformation implements java.io.Serializable {

	// Fields

	private Integer userId;
	private Userinfo userinfo;
	private String passWd;

	// Constructors

	/** default constructor */
	public Loginformation() {
	}

	/** minimal constructor */
	public Loginformation(Integer userId, Userinfo userinfo) {
		this.userId = userId;
		this.userinfo = userinfo;
	}

	/** full constructor */
	public Loginformation(Integer userId, Userinfo userinfo, String passWd) {
		this.userId = userId;
		this.userinfo = userinfo;
		this.passWd = passWd;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPassWd() {
		return this.passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

}