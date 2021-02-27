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
public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String description;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String image;
	@NotNull
	@NotEmpty
	@Size(max = 80)
	private String name;
	private Integer productId;
	@NotNull
	@NotEmpty
	@Size(max = 1)
	private String state;
	@NotNull
	@NotEmpty
	@Size(max = 255)
	private String url;
	@NotNull
	private Date validRegister;

	public ProductDTO() {
	}

	public ProductDTO(@NotNull @NotEmpty @Size(max = 255) String description,
			@NotNull @NotEmpty @Size(max = 255) String image, @NotNull @NotEmpty @Size(max = 80) String name,
			Integer productId, @NotNull @NotEmpty @Size(max = 1) String state,
			@NotNull @NotEmpty @Size(max = 255) String url, @NotNull Date validRegister) {
		super();
		this.description = description;
		this.image = image;
		this.name = name;
		this.productId = productId;
		this.state = state;
		this.url = url;
		this.validRegister = validRegister;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

}
