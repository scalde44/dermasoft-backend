package co.edu.usbcali.demo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public class RolDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@Email
	private String email;
	@NotNull
	@NotEmpty
	@Size(max = 20)
	private String identificationType;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String password;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String register;
	@NotNull
	private Integer role;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String state;
	@NotNull
	@NotEmpty
	@Size(max = 20)
	private String userIdentification;
	@NotNull
	private Date validRegister;

	public RolDTO() {
	}

	public RolDTO(@Email String email, @NotNull @NotEmpty @Size(max = 20) String identificationType,
			@NotNull @NotEmpty @Size(max = 255) String password, @NotNull @NotEmpty @Size(max = 1) String register,
			@NotNull Integer role, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull @NotEmpty @Size(max = 20) String userIdentification, @NotNull Date validRegister) {
		super();
		this.email = email;
		this.identificationType = identificationType;
		this.password = password;
		this.register = register;
		this.role = role;
		this.state = state;
		this.userIdentification = userIdentification;
		this.validRegister = validRegister;
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

	public String getUserIdentification() {
		return userIdentification;
	}

	public void setUserIdentification(String userIdentification) {
		this.userIdentification = userIdentification;
	}

	public Date getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(Date validRegister) {
		this.validRegister = validRegister;
	}

}
