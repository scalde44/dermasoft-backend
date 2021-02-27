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
public class TreatmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	@NotNull
	private Integer duration;
	@NotNull
	private Integer quantity;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String state;
	@NotNull
	private Integer treatmentId;
	@NotNull
	private Date validRegister;
	private Integer appointmentI;
	private Integer productI;

	public TreatmentDTO() {
	}

	public TreatmentDTO(@NotNull @NotEmpty @Size(max = 255) String description, @NotNull Integer duration,
			@NotNull Integer quantity, @NotNull @NotEmpty @Size(max = 1) String state, @NotNull Integer treatmentId,
			@NotNull Date validRegister, Integer appointmentI, Integer productI) {
		super();
		this.description = description;
		this.duration = duration;
		this.quantity = quantity;
		this.state = state;
		this.treatmentId = treatmentId;
		this.validRegister = validRegister;
		this.appointmentI = appointmentI;
		this.productI = productI;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Date getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(Date validRegister) {
		this.validRegister = validRegister;
	}

	public Integer getAppointmentI() {
		return appointmentI;
	}

	public void setAppointmentI(Integer appointmentI) {
		this.appointmentI = appointmentI;
	}

	public Integer getProductI() {
		return productI;
	}

	public void setProductI(Integer productI) {
		this.productI = productI;
	}

}
