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
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.CityRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(City city) throws ConstraintViolationException {

		Set<ConstraintViolation<City>> constraintViolations = validator.validate(city);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return cityRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public City save(City entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("City");
		}

		validate(entity);

		return cityRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(City entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("City");
		}

		if (entity.getCityId() == null) {
			throw new ZMessManager().new EmptyFieldException("cityId");
		}

		if (cityRepository.existsById(entity.getCityId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getCityId()).ifPresent(entidad -> {
			List<Doctor> doctors = entidad.getDoctors();
			if (Utilities.validationsList(doctors) == true) {
				throw new ZMessManager().new DeletingException("doctors");
			}
			List<Patient> patients = entidad.getPatients();
			if (Utilities.validationsList(patients) == true) {
				throw new ZMessManager().new DeletingException("patients");
			}
		});

		cityRepository.deleteById(entity.getCityId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("cityId");
		}
		if (cityRepository.existsById(id)) {
			delete(cityRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public City update(City entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("City");
		}

		validate(entity);

		if (cityRepository.existsById(entity.getCityId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return cityRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<City> findById(Integer cityId) {
		return cityRepository.findById(cityId);
	}

}
