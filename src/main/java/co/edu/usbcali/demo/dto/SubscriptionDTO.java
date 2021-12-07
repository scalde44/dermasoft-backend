package co.edu.usbcali.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class SubscriptionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String name;
	@NotNull
	private Double price;
	@NotNull
	private Integer duration;
	private Integer subscriptionId;

	public SubscriptionDTO() {
	}

	public SubscriptionDTO(@NotNull @NotEmpty @Size(max = 255) String description,
			@NotNull @NotEmpty @Size(max = 255) String name, @NotNull Double price, @NotNull Integer duration,
			Integer subscriptionId) {
		super();
		this.description = description;
		this.name = name;
		this.price = price;
		this.duration = duration;
		this.subscriptionId = subscriptionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

}
