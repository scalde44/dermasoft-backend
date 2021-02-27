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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */
@Entity
@Table(name = "city", schema = "public")
public class City implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "city_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@NotNull
	private Department department;

	@NotNull
	@NotEmpty
	@Size(max = 5)
	@Column(name = "city_code", nullable = false)
	private String cityCode;
	@NotNull
	@NotEmpty
	@Size(max = 50)
	@Column(name = "description", nullable = false)
	private String description;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "state", nullable = false)
	private String state;
	@NotNull
	@Column(name = "valid_register", nullable = false)
	private Date validRegister;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private List<Doctor> doctors = new ArrayList<>();
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	private List<Patient> patients = new ArrayList<>();

	public City() {
	}

	public City(Integer cityId, @NotNull Department department, @NotNull @NotEmpty @Size(max = 5) String cityCode,
			@NotNull @NotEmpty @Size(max = 50) String description, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull Date validRegister, List<Doctor> doctors, List<Patient> patients) {
		super();
		this.cityId = cityId;
		this.department = department;
		this.cityCode = cityCode;
		this.description = description;
		this.state = state;
		this.validRegister = validRegister;
		this.doctors = doctors;
		this.patients = patients;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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