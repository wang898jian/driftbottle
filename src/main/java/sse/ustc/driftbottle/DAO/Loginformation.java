package sse.ustc.driftbottle.DAO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Loginformation entity. @author MyEclipse Persistence Tools
 */
@XmlRootElement
public class Loginformation implements java.io.Serializable {

	// Fields

	private String userName;
	private String passWd;

	// Constructors

	/** default constructor */
	public Loginformation() {
	}

	/** minimal constructor */
	public Loginformation(String userName, Userinfo userinfo) {
		this.userName = userName;

	}

	/** full constructor */
	public Loginformation(String userName, Userinfo userinfo, String passWd) {
		this.userName = userName;

		this.passWd = passWd;
	}

	// Property accessors

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPassWd() {
		return this.passWd;
	}

	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}

}