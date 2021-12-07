package co.edu.usbcali.demo.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Entity
@Table(name = "doctor_subscription", schema = "public")
public class DoctorSubscription implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "doctor_subscription_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorSubscriptionId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	@NotNull
	private Doctor doctor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subscription_id")
	@NotNull
	private Subscription subscription;
	@NotNull
	@Column(name = "membership_date", nullable = false)
	private LocalDate membershipDate;
	@Length(max = 1)
	@Column(name = "state", nullable = false)
	private String state;

	public DoctorSubscription() {
	}

	public DoctorSubscription(Integer doctorSubscriptionId, @NotNull Doctor doctor, @NotNull Subscription subscription,
			@NotNull LocalDate membershipDate, String state) {
		super();
		this.doctorSubscriptionId = doctorSubscriptionId;
		this.doctor = doctor;
		this.subscription = subscription;
		this.membershipDate = membershipDate;
		this.state = state;
	}

	public Integer getDoctorSubscriptionId() {
		return doctorSubscriptionId;
	}

	public void setDoctorSubscriptionId(Integer doctorSubscriptionId) {
		this.doctorSubscriptionId = doctorSubscriptionId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public LocalDate getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(LocalDate membershipDate) {
		this.membershipDate = membershipDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
