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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rating", schema = "public")
public class Rating {
	@Id
	@Column(name = "rating_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ratingId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_id")
	@NotNull
	private Appointment appointment;

	@Column(name = "rating_value", nullable = false)
	@Min(1)
	@Max(5)
	private Integer ratingValue;

	@Column(name = "rating_description", nullable = false)
	private String ratingDescription;

	@Column(name = "valid_register", nullable = false)
	private LocalDate validRegister;

	public Rating() {
	}

	public Rating(Long ratingId, @NotNull Appointment appointment, @Min(1) @Max(5) Integer ratingValue,
			String ratingDescription, LocalDate validRegister) {
		super();
		this.ratingId = ratingId;
		this.appointment = appointment;
		this.ratingValue = ratingValue;
		this.ratingDescription = ratingDescription;
		this.validRegister = validRegister;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Integer getRatingValue() {
		return ratingValue;
	}

	public void setRatingValue(Integer ratingValue) {
		this.ratingValue = ratingValue;
	}

	public String getRatingDescription() {
		return ratingDescription;
	}

	public void setRatingDescription(String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

	public LocalDate getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(LocalDate validRegister) {
		this.validRegister = validRegister;
	}

	@PrePersist
	private void prePersistFunction() {
		this.validRegister = LocalDate.now();
	}

}
