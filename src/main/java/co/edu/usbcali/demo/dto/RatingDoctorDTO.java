package co.edu.usbcali.demo.dto;

import java.time.LocalDate;

public class RatingDoctorDTO {
	private Integer ratingValue;
	private String ratingDescription;
	private String firstName;
	private String lastName;
	private String image;
	private LocalDate validRegister;

	public RatingDoctorDTO() {
		super();
	}

	public RatingDoctorDTO(Integer ratingValue, String ratingDescription, String firstName, String lastName,
			String image, LocalDate validRegister) {
		super();
		this.ratingValue = ratingValue;
		this.ratingDescription = ratingDescription;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.validRegister = validRegister;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(LocalDate validRegister) {
		this.validRegister = validRegister;
	}
}
