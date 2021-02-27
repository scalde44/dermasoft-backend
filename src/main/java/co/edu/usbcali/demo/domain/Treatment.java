package co.edu.usbcali.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Entity
@Table(name = "treatment", schema = "public")
public class Treatment implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "treatment_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer treatmentId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_id")
	@NotNull
	private Appointment appointment;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@NotNull
	private Product product;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "description", nullable = false)
	private String description;
	@NotNull
	@Column(name = "duration", nullable = false)
	private Integer duration;
	@NotNull
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "state", nullable = false)
	private String state;
	@NotNull
	@Column(name = "valid_register", nullable = false)
	private Date validRegister;

	public Treatment() {
	}

	public Treatment(Integer treatmentId, @NotNull Appointment appointment, @NotNull Product product,
			@NotNull @NotEmpty @Size(max = 255) String description, @NotNull Integer duration,
			@NotNull Integer quantity, @NotNull @NotEmpty @Size(max = 1) String state, @NotNull Date validRegister) {
		super();
		this.treatmentId = treatmentId;
		this.appointment = appointment;
		this.product = product;
		this.description = description;
		this.duration = duration;
		this.quantity = quantity;
		this.state = state;
		this.validRegister = validRegister;
	}

	public Integer getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(Integer treatmentId) {
		this.treatmentId = treatmentId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Date getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(Date validRegister) {
		this.validRegister = validRegister;
	}

}
