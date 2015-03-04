package sse.ustc.driftbottle.pojo;

/**
 * MassageId entity. @author MyEclipse Persistence Tools
 */

public class MassageId implements java.io.Serializable {

	// Fields

	private Integer bottleId;
	private Integer massageId;
	private Integer userId;

	// Constructors

	/** default constructor */
	public MassageId() {
	}

	/** full constructor */
	public MassageId(Integer bottleId, Integer massageId, Integer userId) {
		this.bottleId = bottleId;
		this.massageId = massageId;
		this.userId = userId;
	}

	// Property accessors

	public Integer getBottleId() {
		return this.bottleId;
	}

	public void setBottleId(Integer bottleId) {
		this.bottleId = bottleId;
	}

	public Integer getMassageId() {
		return this.massageId;
	}

	public void setMassageId(Integer massageId) {
		this.massageId = massageId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MassageId))
			return false;
		MassageId castOther = (MassageId) other;

		return ((this.getBottleId() == castOther.getBottleId()) || (this
				.getBottleId() != null && castOther.getBottleId() != null && this
				.getBottleId().equals(castOther.getBottleId())))
				&& ((this.getMassageId() == castOther.getMassageId()) || (this
						.getMassageId() != null
						&& castOther.getMassageId() != null && this
						.getMassageId().equals(castOther.getMassageId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBottleId() == null ? 0 : this.getBottleId().hashCode());
		result = 37 * result
				+ (getMassageId() == null ? 0 : this.getMassageId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}