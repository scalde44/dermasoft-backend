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

import co.edu.usbcali.demo.domain.City;
import co.edu.usbcali.demo.domain.Department;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.DepartmentRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Department department) throws ConstraintViolationException {

		Set<ConstraintViolation<Department>> constraintViolations = validator.validate(department);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return departmentRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Department save(Department entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Department");
		}

		validate(entity);

		return departmentRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Department entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Department");
		}

		if (entity.getDepartmentId() == null) {
			throw new ZMessManager().new EmptyFieldException("departmentId");
		}

		if (departmentRepository.existsById(entity.getDepartmentId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getDepartmentId()).ifPresent(entidad -> {
			List<City> cities = entidad.getCities();
			if (Utilities.validationsList(cities) == true) {
				throw new ZMessManager().new DeletingException("cities");
			}
		});

		departmentRepository.deleteById(entity.getDepartmentId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("departmentId");
		}
		if (departmentRepository.existsById(id)) {
			delete(departmentRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Department update(Department entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Department");
		}

		validate(entity);

		if (departmentRepository.existsById(entity.getDepartmentId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return departmentRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Department> findById(Integer departmentId) {
		return departmentRepository.findById(departmentId);
	}

}
