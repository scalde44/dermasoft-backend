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
@Table(name = "department", schema = "public")
public class Department implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "department_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentId;

	@NotNull
	@NotEmpty
	@Size(max = 2)
	@Column(name = "department_code", nullable = false)
	private String departmentCode;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	private List<City> cities = new ArrayList<>();

	public Department() {
	}

	public Department(Integer departmentId, @NotNull @NotEmpty @Size(max = 2) String departmentCode,
			@NotNull @NotEmpty @Size(max = 50) String description, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull Date validRegister, List<City> cities) {
		super();
		this.departmentId = departmentId;
		this.departmentCode = departmentCode;
		this.description = description;
		this.state = state;
		this.validRegister = validRegister;
		this.cities = cities;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}