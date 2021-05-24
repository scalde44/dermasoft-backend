package co.edu.usbcali.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "mes", schema = "public")
public class Mes implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mes_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mesId;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "mes_name", nullable = false)
	private String mesName;

	@NotNull
	@Column(name = "mes_ano", nullable = false)
	private Integer mesAno;

	@NotNull
	@Column(name = "mes_number", nullable = false)
	private Integer mesNumber;

	public Mes() {
		super();
	}

	public Mes(Integer mesId, @NotNull @NotEmpty @Size(max = 255) String mesName, @NotNull Integer mesAno,
			@NotNull Integer mesNumber) {
		super();
		this.mesId = mesId;
		this.mesName = mesName;
		this.mesAno = mesAno;
		this.mesNumber = mesNumber;
	}

	public Integer getMesId() {
		return mesId;
	}

	public void setMesId(Integer mesId) {
		this.mesId = mesId;
	}

	public String getMesName() {
		return mesName;
	}

	public void setMesName(String mesName) {
		this.mesName = mesName;
	}

	public Integer getMesAno() {
		return mesAno;
	}

	public void setMesAno(Integer mesAno) {
		this.mesAno = mesAno;
	}

	public Integer getMesNumber() {
		return mesNumber;
	}

	public void setMesNumber(Integer mesNumber) {
		this.mesNumber = mesNumber;
	}

}
