package co.edu.usbcali.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Entity
@Table(name = "admin", schema = "public")
public class Admin implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "admin_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer adminId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_identification")
	@NotNull
	private Rol rol;
	@Column(name = "first_name")
	private String firstName;
	@Size(max = 120)
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Size(max = 40)
	@Column(name = "last_name2", nullable = false)
	private String lastName2;

	public Admin() {
	}

	public Admin(Integer adminId, @NotNull Rol rol, String firstName, @Size(max = 120) String lastName,
			@Size(max = 40) String lastName2) {
		super();
		this.adminId = adminId;
		this.rol = rol;
		this.firstName = firstName;
		this.lastName = lastName;
		this.lastName2 = lastName2;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

}
