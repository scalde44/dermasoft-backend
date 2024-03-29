package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PatientAppointmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	private Date date;
	private String firstName;
	private String lastName;
	private String image;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	private Integer price;
	private Integer appointmentId;
	private String reason;
	private String state;
	private String rating;

	public PatientAppointmentDTO() {
		super();
	}

	public PatientAppointmentDTO(@NotNull Date date, String firstName, String lastName, String image,
			@NotNull @NotEmpty @Size(max = 255) String description, Integer price, Integer appointmentId, String reason,
			String state, String rating) {
		super();
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.description = description;
		this.price = price;
		this.appointmentId = appointmentId;
		this.reason = reason;
		this.state = state;
		this.rating = rating;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
