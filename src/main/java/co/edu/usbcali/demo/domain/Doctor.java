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
@Table(name = "doctor", schema = "public")
public class Doctor implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "doctor_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	@NotNull
	private City city;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_identification")
	@NotNull
	private Rol rol;

	@Column(name = "birthday")
	private Date birthday;
	@Column(name = "description")
	private String description;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "image")
	private String image;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "last_name2")
	private String lastName2;
	@Column(name = "phone")
	private String phone;
	@Column(name = "price")
	private Integer price;
	@Column(name = "reputation")
	private Integer reputation;
	@Column(name = "verified")
	private String verified;
	@Column(name = "facebook_url")
	private String facebookUrl;
	@Column(name = "instagram_url")
	private String instagramUrl;
	@Column(name = "twitter_url")
	private String twitterUrl;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private List<Appointment> appointments = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	private List<DoctorSubscription> doctorSubscriptions = new ArrayList<>();

	public Doctor() {
	}

	public Doctor(Integer doctorId, @NotNull City city, @NotNull Rol rol, Date birthday, String description,
			String firstName, String gender, String image, String lastName, String lastName2, String phone,
			Integer price, Integer reputation, String verified, String facebookUrl, String instagramUrl,
			String twitterUrl) {
		super();
		this.doctorId = doctorId;
		this.city = city;
		this.rol = rol;
		this.birthday = birthday;
		this.description = description;
		this.firstName = firstName;
		this.gender = gender;
		this.image = image;
		this.lastName = lastName;
		this.lastName2 = lastName2;
		this.phone = phone;
		this.price = price;
		this.reputation = reputation;
		this.verified = verified;
		this.facebookUrl = facebookUrl;
		this.instagramUrl = instagramUrl;
		this.twitterUrl = twitterUrl;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
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

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public String getInstagramUrl() {
		return instagramUrl;
	}

	public void setInstagramUrl(String instagramUrl) {
		this.instagramUrl = instagramUrl;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public void setTwitterUrl(String twitterUrl) {
		this.twitterUrl = twitterUrl;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public List<DoctorSubscription> getDoctorSubscriptions() {
		return doctorSubscriptions;
	}

	public void setDoctorSubscriptions(List<DoctorSubscription> doctorSubscriptions) {
		this.doctorSubscriptions = doctorSubscriptions;
	}

}