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
public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	@Size(max = 2)
	private String departmentCode;
	private Integer departmentId;
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

	public DepartmentDTO() {
	}

	public DepartmentDTO(@NotNull @NotEmpty @Size(max = 2) String departmentCode, Integer departmentId,
			@NotNull @NotEmpty @Size(max = 50) String description, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull Date validRegister) {
		super();
		this.departmentCode = departmentCode;
		this.departmentId = departmentId;
		this.description = description;
		this.state = state;
		this.validRegister = validRegister;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
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

}
