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

import co.edu.usbcali.demo.domain.DoctorSubscription;
import co.edu.usbcali.demo.domain.Subscription;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.SubscriptionRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Subscription subscription) throws ConstraintViolationException {

		Set<ConstraintViolation<Subscription>> constraintViolations = validator.validate(subscription);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return subscriptionRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Subscription> findAll() {
		return subscriptionRepository.findAllByOrderBySubscriptionId();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Subscription save(Subscription entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Subscription");
		}

		validate(entity);
		return subscriptionRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Subscription entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Subscription");
		}

		if (entity.getSubscriptionId() == null) {
			throw new ZMessManager().new EmptyFieldException("subscriptionId");
		}

		if (subscriptionRepository.existsById(entity.getSubscriptionId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getSubscriptionId()).ifPresent(entidad -> {
			List<DoctorSubscription> doctorSubscriptions = entidad.getDoctorSubscriptions();
			if (Utilities.validationsList(doctorSubscriptions) == true) {
				throw new ZMessManager().new DeletingException("doctorSubscriptions");
			}
		});

		subscriptionRepository.deleteById(entity.getSubscriptionId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("subscriptionId");
		}
		if (subscriptionRepository.existsById(id)) {
			delete(subscriptionRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Subscription update(Subscription entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Subscription");
		}

		validate(entity);

		if (subscriptionRepository.existsById(entity.getSubscriptionId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return subscriptionRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Subscription> findById(Integer subscriptionId) {
		return subscriptionRepository.findById(subscriptionId);
	}

}
