package co.edu.usbcali.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.demo.domain.Product;
import co.edu.usbcali.demo.dto.ProductDTO;
import co.edu.usbcali.demo.mapper.ProductMapper;
import co.edu.usbcali.demo.service.ProductService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductMapper productMapper;

	@GetMapping(value = "/{productId}")
	public ResponseEntity<?> findById(@PathVariable("productId") Integer productId) throws Exception {

		Product product = (productService.findById(productId).isPresent() == true)
				? productService.findById(productId).get()
				: null;

		return ResponseEntity.ok().body(productMapper.productToProductDTO(product));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(productMapper.listProductToListProductDTO(productService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody ProductDTO productDTO) throws Exception {

		Product product = productMapper.productDTOToProduct(productDTO);
		product = productService.save(product);

		return ResponseEntity.ok().body(productMapper.productToProductDTO(product));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody ProductDTO productDTO) throws Exception {

		Product product = productMapper.productDTOToProduct(productDTO);
		product = productService.update(product);

		return ResponseEntity.ok().body(productMapper.productToProductDTO(product));
	}

	@DeleteMapping(value = "/{productId}")
	public ResponseEntity<?> delete(@PathVariable("productId") Integer productId) throws Exception {

		productService.deleteById(productId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(productService.count());
	}
}
