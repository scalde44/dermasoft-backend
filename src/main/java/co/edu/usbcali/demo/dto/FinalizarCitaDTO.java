package co.edu.usbcali.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FinalizarCitaDTO {
	@NotNull
	private Date date;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	private String firstNamePatient;
	private String lastNamePatient;
	private String eps;
	private String gender;

	public FinalizarCitaDTO() {
		super();
	}

	public FinalizarCitaDTO(@NotNull Date date, @NotNull @NotEmpty @Size(max = 255) String description,
			String firstNamePatient, String lastNamePatient, String eps, String gender) {
		super();
		this.date = date;
		this.description = description;
		this.firstNamePatient = firstNamePatient;
		this.lastNamePatient = lastNamePatient;
		this.eps = eps;
		this.gender = gender;
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

	public String getFirstNamePatient() {
		return firstNamePatient;
	}

	public void setFirstNamePatient(String firstNamePatient) {
		this.firstNamePatient = firstNamePatient;
	}

	public String getLastNamePatient() {
		return lastNamePatient;
	}

	public void setLastNamePatient(String lastNamePatient) {
		this.lastNamePatient = lastNamePatient;
	}

	public String getEps() {
		return eps;
	}

	public void setEps(String eps) {
		this.eps = eps;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
