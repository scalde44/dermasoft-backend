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
@Table(name = "eps", schema = "public")
public class Eps implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eps_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer epsId;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "eps_name", nullable = false)
	private String epsName;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "state", nullable = false)
	private String state;
	@NotNull
	@Column(name = "valid_register", nullable = false)
	private Date validRegister;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "eps")
	private List<Patient> patients = new ArrayList<>();

	public Eps() {
	}

	public Eps(Integer epsId, @NotNull @NotEmpty @Size(max = 255) String epsName,
			@NotNull @NotEmpty @Size(max = 1) String state, @NotNull Date validRegister, List<Patient> patients) {
		super();
		this.epsId = epsId;
		this.epsName = epsName;
		this.state = state;
		this.validRegister = validRegister;
		this.patients = patients;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}