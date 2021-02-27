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
@Table(name = "product", schema = "public")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "product_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "description", nullable = false)
	private String description;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "image", nullable = false)
	private String image;
	@NotNull
	@NotEmpty
	@Size(max = 80)
	@Column(name = "name", nullable = false)
	private String name;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "state", nullable = false)
	private String state;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	@Column(name = "url", nullable = false)
	private String url;
	@NotNull
	@Column(name = "valid_register", nullable = false)
	private Date validRegister;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	private List<Treatment> treatments = new ArrayList<>();

	public Product() {
	}

	public Product(Integer productId, @NotNull @NotEmpty @Size(max = 255) String description,
			@NotNull @NotEmpty @Size(max = 255) String image, @NotNull @NotEmpty @Size(max = 80) String name,
			@NotNull @NotEmpty @Size(max = 1) String state, @NotNull @NotEmpty @Size(max = 255) String url,
			@NotNull Date validRegister, List<Treatment> treatments) {
		super();
		this.productId = productId;
		this.description = description;
		this.image = image;
		this.name = name;
		this.state = state;
		this.url = url;
		this.validRegister = validRegister;
		this.treatments = treatments;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getValidRegister() {
		return validRegister;
	}

	public void setValidRegister(Date validRegister) {
		this.validRegister = validRegister;
	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}

}