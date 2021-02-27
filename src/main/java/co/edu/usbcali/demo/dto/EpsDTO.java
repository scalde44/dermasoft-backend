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
public class EpsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer epsId;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String epsName;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String state;
	@NotNull
	private Date validRegister;

	public EpsDTO() {
	}

	public EpsDTO(Integer epsId, @NotNull @NotEmpty @Size(max = 255) String epsName,
			@NotNull @NotEmpty @Size(max = 1) String state, @NotNull Date validRegister) {
		super();
		this.epsId = epsId;
		this.epsName = epsName;
		this.state = state;
		this.validRegister = validRegister;
	}

	public Integer getEpsId() {
		return epsId;
	}

	public void setEpsId(Integer epsId) {
		this.epsId = epsId;
	}

	public String getEpsName() {
		return epsName;
	}

	public void setEpsName(String epsName) {
		this.epsName = epsName;
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
