package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class AppointmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer appointmentId;
	@NotNull
	private Date date;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	@NotNull
	private Integer duration;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String reason;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String state;
	@NotNull
	private Date validRegister;
	private Integer doctorI;
	private Integer patientI;

	public AppointmentDTO() {
	}

	public AppointmentDTO(Integer appointmentId, @NotNull Date date,
			@NotNull @NotEmpty @Size(max = 255) String description, @NotNull Integer duration,
			@NotNull @NotEmpty @Size(max = 255) String reason, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull Date validRegister, Integer doctorI, Integer patientI) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.description = description;
		this.duration = duration;
		this.reason = reason;
		this.state = state;
		this.validRegister = validRegister;
		this.doctorI = doctorI;
		this.patientI = patientI;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(Date validRegister) {
		this.validRegister = validRegister;
	}

	public Integer getDoctorI() {
		return doctorI;
	}

	public void setDoctorI(Integer doctorI) {
		this.doctorI = doctorI;
	}

	public Integer getPatientI() {
		return patientI;
	}

	public void setPatientI(Integer patientI) {
		this.patientI = patientI;
	}

}
