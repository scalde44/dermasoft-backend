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
import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.PatientRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Patient patient) throws ConstraintViolationException {

		Set<ConstraintViolation<Patient>> constraintViolations = validator.validate(patient);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return patientRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Patient save(Patient entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Patient");
		}

		validate(entity);
		return patientRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Patient entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Patient");
		}

		if (entity.getPatientId() == null) {
			throw new ZMessManager().new EmptyFieldException("patientId");
		}

		if (patientRepository.existsById(entity.getPatientId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getPatientId()).ifPresent(entidad -> {
			List<Appointment> appointments = entidad.getAppointments();
			if (Utilities.validationsList(appointments) == true) {
				throw new ZMessManager().new DeletingException("appointments");
			}
		});

		patientRepository.deleteById(entity.getPatientId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("patientId");
		}
		if (patientRepository.existsById(id)) {
			delete(patientRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Patient update(Patient entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Patient");
		}

		validate(entity);

		if (patientRepository.existsById(entity.getPatientId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return patientRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Patient> findById(Integer patientId) {
		return patientRepository.findById(patientId);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Patient> buscarPacientePorEmail(String email) {
		return patientRepository.buscarPacientePorEmail(email);
	}

}
