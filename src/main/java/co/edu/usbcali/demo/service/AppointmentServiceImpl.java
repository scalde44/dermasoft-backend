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

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.domain.Treatment;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.AppointmentRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Appointment appointment) throws ConstraintViolationException {

		Set<ConstraintViolation<Appointment>> constraintViolations = validator.validate(appointment);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return appointmentRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Appointment save(Appointment entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Appointment");
		}

		validate(entity);

		return appointmentRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Appointment entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Appointment");
		}

		if (entity.getAppointmentId() == null) {
			throw new ZMessManager().new EmptyFieldException("appointmentId");
		}

		if (appointmentRepository.existsById(entity.getAppointmentId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getAppointmentId()).ifPresent(entidad -> {
			List<Treatment> treatments = entidad.getTreatments();
			if (Utilities.validationsList(treatments) == true) {
				throw new ZMessManager().new DeletingException("treatments");
			}
		});

		appointmentRepository.deleteById(entity.getAppointmentId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("appointmentId");
		}
		if (appointmentRepository.existsById(id)) {
			delete(appointmentRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Appointment update(Appointment entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Appointment");
		}

		validate(entity);

		if (appointmentRepository.existsById(entity.getAppointmentId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return appointmentRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Appointment> findById(Integer appointmentId) {
		return appointmentRepository.findById(appointmentId);
	}

}
