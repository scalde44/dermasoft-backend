package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class PatientDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String approved;
	private Date birthdate;
	private String firstName;
	private String gender;
	private Integer height;
	private String image;
	private String lastName;
	private String lastName2;
	private String maritalStatus;
	private String ocupation;
	private Integer patientId;
	private String phone;
	private String verified;
	private Integer weight;
	private Integer cityI;
	private Integer epsI;
	private String userId;

	public PatientDTO() {
	}

	public PatientDTO(String approved, Date birthdate, String firstName, String gender, Integer height, String image,
			String lastName, String lastName2, String maritalStatus, String ocupation, Integer patientId, String phone,
			String verified, Integer weight, Integer cityI, Integer epsI, String userId) {
		super();
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
		this.patientId = patientId;
		this.phone = phone;
		this.verified = verified;
		this.weight = weight;
		this.cityI = cityI;
		this.epsI = epsI;
		this.userId = userId;
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

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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

	public Integer getCityI() {
		return cityI;
	}

	public void setCityI(Integer cityI) {
		this.cityI = cityI;
	}

	public Integer getEpsI() {
		return epsI;
	}

	public void setEpsI(Integer epsI) {
		this.epsI = epsI;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
