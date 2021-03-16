package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class DoctorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date birthday;
	private String description;
	private Integer doctorId;
	private String firstName;
	private String gender;
	private String image;
	private String lastName;
	private String lastName2;
	private String phone;
	private Integer price;
	private Integer reputation;
	private String verified;
	private Integer cityI;
	private String userId;
	private String state;

	public DoctorDTO() {
		super();
	}

	public DoctorDTO(Date birthday, String description, Integer doctorId, String firstName, String gender, String image,
			String lastName, String lastName2, String phone, Integer price, Integer reputation, String verified,
			Integer cityI, String userId, String state) {
		super();
		this.birthday = birthday;
		this.description = description;
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.gender = gender;
		this.image = image;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.phone = phone;
		this.price = price;
		this.reputation = reputation;
		this.verified = verified;
		this.cityI = cityI;
		this.userId = userId;
		this.state = state;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public Integer getCityI() {
		return cityI;
	}

	public void setCityI(Integer cityI) {
		this.cityI = cityI;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}