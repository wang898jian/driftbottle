package sse.ustc.driftbottle.data;

/**
 * Accessory entity. @author MyEclipse Persistence Tools
 */

public class Accessory implements java.io.Serializable {

	// Fields

	private AccessoryId id;
	private Integer accessoryType;
	private String accessoryUrl;

	// Constructors

	/** default constructor */
	public Accessory() {
	}

	/** minimal constructor */
	public Accessory(AccessoryId id) {
		this.id = id;
	}

	/** full constructor */
	public Accessory(AccessoryId id, Integer accessoryType, String accessoryUrl) {
		this.id = id;
		this.accessoryType = accessoryType;
		this.accessoryUrl = accessoryUrl;
	}

	// Property accessors

	public AccessoryId getId() {
		return this.id;
	}

	public void setId(AccessoryId id) {
		this.id = id;
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