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
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	private Integer price;

	public PatientAppointmentDTO() {
		super();
	}

	public PatientAppointmentDTO(@NotNull Date date, String firstName, String lastName,
			@NotNull @NotEmpty @Size(max = 255) String description, Integer price) {
		super();
		this.date = date;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.price = price;
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
}
