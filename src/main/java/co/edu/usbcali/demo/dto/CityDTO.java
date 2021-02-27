package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class CityDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	@Size(max = 5)
	private String cityCode;
	private Integer cityId;
	@NotNull
	@NotEmpty
	@Size(max = 50)
	private String description;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String state;
	@NotNull
	private Date validRegister;
	private Integer departmentI;

	public CityDTO() {
	}

	public CityDTO(@NotNull @NotEmpty @Size(max = 5) String cityCode, Integer cityId,
			@NotNull @NotEmpty @Size(max = 50) String description, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull Date validRegister, Integer departmentI) {
		super();
		this.cityCode = cityCode;
		this.cityId = cityId;
		this.description = description;
		this.state = state;
		this.validRegister = validRegister;
		this.departmentI = departmentI;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
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

	public Integer getDepartmentI() {
		return departmentI;
	}

	public void setDepartmentI(Integer departmentI) {
		this.departmentI = departmentI;
	}

}
