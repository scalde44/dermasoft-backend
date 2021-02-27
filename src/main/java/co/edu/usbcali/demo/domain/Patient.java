package co.edu.usbcali.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "patient", schema = "public")
public class Patient implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "patient_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	@NotNull
	private City city;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eps_id")
	@NotNull
	private Eps eps;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_identification")
	@NotNull
	private Rol rol;

	@Column(name = "approved")
	private String approved;
	@Column(name = "birthdate")
	private Date birthdate;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "height")
	private Integer height;
	@Column(name = "image")
	private String image;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "last_name2")
	private String lastName2;
	@Column(name = "marital_status")
	private String maritalStatus;
	@Column(name = "ocupation")
	private String ocupation;
	@Column(name = "phone")
	private String phone;
	@Column(name = "verified")
	private String verified;
	@Column(name = "weight")
	private Integer weight;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private List<Appointment> appointments = new ArrayList<>();

	public Patient() {
	}

	public Patient(Integer patientId, @NotNull City city, @NotNull Eps eps, @NotNull Rol rol, String approved,
			Date birthdate, String firstName, String gender, Integer height, String image, String lastName,
			String lastName2, String maritalStatus, String ocupation, String phone, String verified, Integer weight,
			List<Appointment> appointments) {
		super();
		this.patientId = patientId;
		this.city = city;
		this.eps = eps;
		this.rol = rol;
		this.approved = approved;
		this.birthdate = birthdate;
		this.firstName = firstName;
		this.gender = gender;
		this.height = height;
		this.image = image;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.maritalStatus = maritalStatus;
		this.ocupation = ocupation;
		this.phone = phone;
		this.verified = verified;
		this.weight = weight;
		this.appointments = appointments;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

}