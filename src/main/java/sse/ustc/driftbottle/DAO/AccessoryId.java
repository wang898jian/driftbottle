package sse.ustc.driftbottle.DAO;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * AccessoryId entity. @author MyEclipse Persistence Tools
 */
@XmlRootElement
public class AccessoryId implements java.io.Serializable {

	// Fields

	private Integer accessoryId;
	private Object message;

	// Constructors

	/** default constructor */
	public AccessoryId() {
	}

	/** full constructor */
	public AccessoryId(Integer accessoryId, Object message) {
		this.accessoryId = accessoryId;
		this.message = message;
	}

	// Property accessors

	public Integer getAccessoryId() {
		return this.accessoryId;
	}

	public void setAccessoryId(Integer accessoryId) {
		this.accessoryId = accessoryId;
	}

	public Object getMessage() {
		return this.message;
	}

	public void setMessage(Object massage) {
		this.message = message;
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
				&& ((this.getMessage() == castOther.getMessage()) || (this
						.getMessage() != null && castOther.getMessage() != null && this
						.getMessage().equals(castOther.getMessage())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccessoryId() == null ? 0 : this.getAccessoryId()
						.hashCode());
		result = 37 * result
				+ (getMessage() == null ? 0 : this.getMessage().hashCode());
		return result;
	}

}