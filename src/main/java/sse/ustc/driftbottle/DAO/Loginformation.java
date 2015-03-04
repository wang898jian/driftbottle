package sse.ustc.driftbottle.DAO;

/**
 * Loginformation entity. @author MyEclipse Persistence Tools
 */

public class Loginformation implements java.io.Serializable {

	// Fields

	private String userName;
	private Userinfo userinfo;
	private String passWd;

	// Constructors

	/** default constructor */
	public Loginformation() {
	}

	/** minimal constructor */
	public Loginformation(String userName, Userinfo userinfo) {
		this.userName = userName;
		this.userinfo = userinfo;
	}

	/** full constructor */
	public Loginformation(String userName, Userinfo userinfo, String passWd) {
		this.userName = userName;
		this.userinfo = userinfo;
		this.passWd = passWd;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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