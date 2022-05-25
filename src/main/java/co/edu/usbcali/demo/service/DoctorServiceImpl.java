package co.edu.usbcali.demo.service;

import static co.edu.usbcali.demo.utility.ConstantesDermasoft.REGISTRADO;

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
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.DoctorRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Doctor doctor) throws ConstraintViolationException {

		Set<ConstraintViolation<Doctor>> constraintViolations = validator.validate(doctor);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return doctorRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Doctor> findAll() {
		return doctorRepository.findAllByOrderByDoctorId();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Doctor save(Doctor entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Doctor");
		}

		validate(entity);
		return doctorRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Doctor entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Doctor");
		}

		if (entity.getDoctorId() == null) {
			throw new ZMessManager().new EmptyFieldException("doctorId");
		}

		if (doctorRepository.existsById(entity.getDoctorId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getDoctorId()).ifPresent(entidad -> {
			List<Appointment> appointments = entidad.getAppointments();
			if (Utilities.validationsList(appointments) == true) {
				throw new ZMessManager().new DeletingException("appointments");
			}
		});

		doctorRepository.deleteById(entity.getDoctorId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("doctorId");
		}
		if (doctorRepository.existsById(id)) {
			delete(doctorRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Doctor update(Doctor entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Doctor");
		}

		validate(entity);

		if (doctorRepository.existsById(entity.getDoctorId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}
		if(entity.getVerified()==null||entity.getVerified().isBlank()) {
			entity.setVerified(REGISTRADO);
		}
		if(!entity.getVerified().equalsIgnoreCase(REGISTRADO)) {
			entity.setVerified(REGISTRADO);
		}
		return doctorRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Doctor> findById(Integer doctorId) {
		return doctorRepository.findById(doctorId);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Doctor> buscarDoctorPorEmail(String email) {
		return doctorRepository.buscarDoctorPorEmail(email);
	}

}
