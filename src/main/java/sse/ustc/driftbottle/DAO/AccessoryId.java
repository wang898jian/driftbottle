package sse.ustc.driftbottle.DAO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * AccessoryId entity. @author MyEclipse Persistence Tools
 */
@XmlRootElement
public class AccessoryId implements java.io.Serializable {

	// Fields

	private Integer accessoryId;
	private Massage massage;

	// Constructors

	/** default constructor */
	public AccessoryId() {
	}

	/** full constructor */
	public AccessoryId(Integer accessoryId, Massage massage) {
		this.accessoryId = accessoryId;
		this.massage = massage;
	}

	// Property accessors

	public Integer getAccessoryId() {
		return this.accessoryId;
	}

	public void setAccessoryId(Integer accessoryId) {
		this.accessoryId = accessoryId;
	}

	public Massage getMassage() {
		return this.massage;
	}

	public void setMassage(Massage massage) {
		this.massage = massage;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AccessoryId))
			return false;
		AccessoryId castOther = (AccessoryId) other;

		return ((this.getAccessoryId() == castOther.getAccessoryId()) || (this
				.getAccessoryId() != null && castOther.getAccessoryId() != null && this
				.getAccessoryId().equals(castOther.getAccessoryId())))
				&& ((this.getMassage() == castOther.getMassage()) || (this
						.getMassage() != null && castOther.getMassage() != null && this
						.getMassage().equals(castOther.getMassage())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccessoryId() == null ? 0 : this.getAccessoryId()
						.hashCode());
		result = 37 * result
				+ (getMassage() == null ? 0 : this.getMassage().hashCode());
		return result;
	}

}