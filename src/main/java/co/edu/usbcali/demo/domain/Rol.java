package co.edu.usbcali.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "rol", schema = "public")
public class Rol implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_identification", unique = true, nullable = false)
	@NotNull
	private String userIdentification;

	@Email
	@Column(name = "email", nullable = false)
	private String email;
	@NotNull
	@NotEmpty
	@Size(max = 20)
	@Column(name = "identification_type", nullable = false)
	private String identificationType;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "password", nullable = false)
	private String password;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "register", nullable = false)
	private String register;
	@NotNull
	@Column(name = "role", nullable = false)
	private Integer role;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "state", nullable = false)
	private String state;
	@NotNull
	@Column(name = "valid_register", nullable = false)
	private Date validRegister;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	private List<Admin> admins = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	private List<Doctor> doctors = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rol")
	private List<Patient> patients = new ArrayList<>();

	public Rol() {
	}

	public Rol(@NotNull String userIdentification, @Email String email,
			@NotNull @NotEmpty @Size(max = 20) String identificationType,
			@NotNull @NotEmpty @Size(max = 255) String password, @NotNull @NotEmpty @Size(max = 1) String register,
			@NotNull Integer role, @NotNull @NotEmpty @Size(max = 1) String state, @NotNull Date validRegister,
			List<Admin> admins, List<Doctor> doctors, List<Patient> patients) {
		super();
		this.userIdentification = userIdentification;
		this.email = email;
		this.identificationType = identificationType;
		this.password = password;
		this.register = register;
		this.role = role;
		this.state = state;
		this.validRegister = validRegister;
		this.admins = admins;
		this.doctors = doctors;
		this.patients = patients;
	}

	public String getUserIdentification() {
		return userIdentification;
	}

	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
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

	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}