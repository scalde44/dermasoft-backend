package co.edu.usbcali.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.demo.domain.Product;
import co.edu.usbcali.demo.domain.Treatment;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.ProductRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Product product) throws ConstraintViolationException {

		Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return productRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Product save(Product entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Product");
		}

		validate(entity);

		return productRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Product entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Product");
		}

		if (entity.getProductId() == null) {
			throw new ZMessManager().new EmptyFieldException("productId");
		}

		if (productRepository.existsById(entity.getProductId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getProductId()).ifPresent(entidad -> {
			List<Treatment> treatments = entidad.getTreatments();
			if (Utilities.validationsList(treatments) == true) {
				throw new ZMessManager().new DeletingException("treatments");
			}
		});

		productRepository.deleteById(entity.getProductId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("productId");
		}
		if (productRepository.existsById(id)) {
			delete(productRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Product update(Product entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Product");
		}

		validate(entity);

		if (productRepository.existsById(entity.getProductId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return productRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> findById(Integer productId) {
		return productRepository.findById(productId);
	}

}
