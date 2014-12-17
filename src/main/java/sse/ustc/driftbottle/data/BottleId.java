package sse.ustc.driftbottle.data;

/**
 * BottleId entity. @author MyEclipse Persistence Tools
 */

public class BottleId implements java.io.Serializable {

	// Fields

	private Integer bottleId;
	private Userinfo userinfo;

	// Constructors

	/** default constructor */
	public BottleId() {
	}

	/** full constructor */
	public BottleId(Integer bottleId, Userinfo userinfo) {
		this.bottleId = bottleId;
		this.userinfo = userinfo;
	}

	// Property accessors

	public Integer getBottleId() {
		return this.bottleId;
	}

	public void setBottleId(Integer bottleId) {
		this.bottleId = bottleId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BottleId))
			return false;
		BottleId castOther = (BottleId) other;

		return ((this.getBottleId() == castOther.getBottleId()) || (this
				.getBottleId() != null && castOther.getBottleId() != null && this
				.getBottleId().equals(castOther.getBottleId())))
				&& ((this.getUserinfo() == castOther.getUserinfo()) || (this
						.getUserinfo() != null
						&& castOther.getUserinfo() != null && this
						.getUserinfo().equals(castOther.getUserinfo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getBottleId() == null ? 0 : this.getBottleId().hashCode());
		result = 37 * result
				+ (getUserinfo() == null ? 0 : this.getUserinfo().hashCode());
		return result;
	}

}