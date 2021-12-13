package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class DoctorSubscriptionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer doctorSubscriptionId;
	private Date membershipDate;
	private String state;
	private Integer doctorId;
	private Integer subscriptionId;

	public DoctorSubscriptionDTO() {
	}

	public DoctorSubscriptionDTO(Integer doctorSubscriptionId, Date membershipDate, String state, Integer doctorId,
			Integer subscriptionId) {
		this.doctorSubscriptionId = doctorSubscriptionId;
		this.membershipDate = membershipDate;
		this.state = state;
		this.doctorId = doctorId;
		this.subscriptionId = subscriptionId;
	}

	public Integer getDoctorSubscriptionId() {
		return doctorSubscriptionId;
	}

	public void setDoctorSubscriptionId(Integer doctorSubscriptionId) {
		this.doctorSubscriptionId = doctorSubscriptionId;
	}

	public Date getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(Date membershipDate) {
		this.membershipDate = membershipDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

}
