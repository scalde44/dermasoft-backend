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

import co.edu.usbcali.demo.domain.Eps;
import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.EpsRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class EpsServiceImpl implements EpsService {

	@Autowired
	private EpsRepository epsRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Eps eps) throws ConstraintViolationException {

		Set<ConstraintViolation<Eps>> constraintViolations = validator.validate(eps);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return epsRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Eps> findAll() {
		return epsRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Eps save(Eps entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Eps");
		}

		validate(entity);

		return epsRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Eps entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Eps");
		}

		if (entity.getEpsId() == null) {
			throw new ZMessManager().new EmptyFieldException("epsId");
		}

		if (epsRepository.existsById(entity.getEpsId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getEpsId()).ifPresent(entidad -> {
			List<Patient> patients = entidad.getPatients();
			if (Utilities.validationsList(patients) == true) {
				throw new ZMessManager().new DeletingException("patients");
			}
		});

		epsRepository.deleteById(entity.getEpsId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("epsId");
		}
		if (epsRepository.existsById(id)) {
			delete(epsRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Eps update(Eps entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Eps");
		}

		validate(entity);

		if (epsRepository.existsById(entity.getEpsId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return epsRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Eps> findById(Integer epsId) {
		return epsRepository.findById(epsId);
	}

}
