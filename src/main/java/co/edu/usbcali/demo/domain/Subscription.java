package co.edu.usbcali.demo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "subscription", schema = "public")
public class Subscription implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "subscription_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subscriptionId;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "description", nullable = false)
	private String description;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "name", nullable = false)
	private String name;
	@NotNull
	@Column(name = "price", nullable = false)
	private Double price;
	@NotNull
	@Column(name = "duration", nullable = false)
	private Integer duration;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscription")
	private List<DoctorSubscription> doctorSubscriptions = new ArrayList<>();

	public Subscription() {
	}

	public Subscription(Integer subscriptionId, @NotNull @NotEmpty @Size(max = 255) String description,
			@NotNull @NotEmpty @Size(max = 255) String name, @NotNull Double price, @NotNull Integer duration) {
		this.subscriptionId = subscriptionId;
		this.description = description;
		this.name = name;
		this.price = price;
		this.duration = duration;
	}

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
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

	public List<DoctorSubscription> getDoctorSubscriptions() {
		return doctorSubscriptions;
	}

	public void setDoctorSubscriptions(List<DoctorSubscription> doctorSubscriptions) {
		this.doctorSubscriptions = doctorSubscriptions;
	}

}