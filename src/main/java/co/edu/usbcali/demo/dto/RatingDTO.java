package co.edu.usbcali.demo.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RatingDTO {
	private Long ratingId;
	@NotNull
	private Integer appointmentId;
	@NotNull
	@Min(1)
	@Max(5)
	private Integer ratingValue;
	@NotNull
	private String ratingDescription;

	public RatingDTO() {
	}

	public RatingDTO(Long ratingId, @NotNull Integer appointmentId, @NotNull @Min(1) @Max(5) Integer ratingValue,
			@NotNull String ratingDescription) {
		super();
		this.ratingId = ratingId;
		this.appointmentId = appointmentId;
		this.ratingValue = ratingValue;
		this.ratingDescription = ratingDescription;
	}

	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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

}
