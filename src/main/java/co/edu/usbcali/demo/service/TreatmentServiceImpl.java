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

import co.edu.usbcali.demo.domain.Treatment;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.TreatmentRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class TreatmentServiceImpl implements TreatmentService {
	@Autowired
	private TreatmentRepository treatmentRepository;
	@Autowired
	private Validator validator;

	@Override
	public void validate(Treatment treatment) throws ConstraintViolationException {
		Set<ConstraintViolation<Treatment>> constraintViolations = validator.validate(treatment);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return treatmentRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Treatment> findAll() {

		return treatmentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Treatment save(Treatment entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Treatment");
		}

		validate(entity);

		if (treatmentRepository.existsById(entity.getTreatmentId())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return treatmentRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Treatment entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Treatment");
		}

		if (entity.getTreatmentId() == null) {
			throw new ZMessManager().new EmptyFieldException("treatmentId");
		}

		if (treatmentRepository.existsById(entity.getTreatmentId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		treatmentRepository.deleteById(entity.getTreatmentId());
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {

		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("treatmentId");
		}

		if (treatmentRepository.existsById(id)) {
			delete(treatmentRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Treatment update(Treatment entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Treatment");
		}

		validate(entity);

		if (treatmentRepository.existsById(entity.getTreatmentId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return treatmentRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Treatment> findById(Integer treatmentId) {

		return treatmentRepository.findById(treatmentId);
	}
}
