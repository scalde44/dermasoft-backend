package co.edu.usbcali.demo.service;

import java.time.LocalDate;
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

import co.edu.usbcali.demo.domain.DoctorSubscription;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.DoctorSubscriptionRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class DoctorSubscriptionServiceImpl implements DoctorSubscriptionService {
	@Autowired
	private DoctorSubscriptionRepository doctorSubscriptionRepository;
	@Autowired
	private Validator validator;

	@Override
	public void validate(DoctorSubscription doctorSubscription) throws ConstraintViolationException {
		Set<ConstraintViolation<DoctorSubscription>> constraintViolations = validator.validate(doctorSubscription);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return doctorSubscriptionRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<DoctorSubscription> findAll() {
		return doctorSubscriptionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DoctorSubscription save(DoctorSubscription entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DoctorSubscription");
		}
		entity.setMembershipDate(LocalDate.now());
		entity.setState("A");
		validate(entity);

		return doctorSubscriptionRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(DoctorSubscription entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DoctorSubscription");
		}

		if (entity.getDoctorSubscriptionId() == null) {
			throw new ZMessManager().new EmptyFieldException("doctorSubscriptionId");
		}

		if (doctorSubscriptionRepository.existsById(entity.getDoctorSubscriptionId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		doctorSubscriptionRepository.deleteById(entity.getDoctorSubscriptionId());
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("doctorSubscriptionId");
		}

		if (doctorSubscriptionRepository.existsById(id)) {
			delete(doctorSubscriptionRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DoctorSubscription update(DoctorSubscription entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DoctorSubscription");
		}

		validate(entity);

		if (doctorSubscriptionRepository.existsById(entity.getDoctorSubscriptionId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return doctorSubscriptionRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DoctorSubscription> findById(Integer doctorSubscriptionId) {
		return doctorSubscriptionRepository.findById(doctorSubscriptionId);
	}

	@Override
	public List<DoctorSubscription> findByDoctorId(Integer doctorId) {
		return doctorSubscriptionRepository.findByDoctorId(doctorId);
	}
}
