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

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.domain.Rol;
import co.edu.usbcali.demo.dto.AdminDTO;
import co.edu.usbcali.demo.dto.DoctorDTO;
import co.edu.usbcali.demo.dto.PatientDTO;
import co.edu.usbcali.demo.dto.RegistroDoctorDTO;
import co.edu.usbcali.demo.dto.RegistroPacienteDTO;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.mapper.AdminMapper;
import co.edu.usbcali.demo.mapper.DoctorMapper;
import co.edu.usbcali.demo.mapper.PatientMapper;
import co.edu.usbcali.demo.repository.AdminRepository;
import co.edu.usbcali.demo.repository.DoctorRepository;
import co.edu.usbcali.demo.repository.PatientRepository;
import co.edu.usbcali.demo.repository.RolRepository;
import co.edu.usbcali.demo.utility.Utilities;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org/
 *         www.zathuracode.org
 * 
 */

@Scope("singleton")
@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private AdminMapper adminMapper;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private DoctorMapper doctorMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private Validator validator;

	@Override
	public void validate(Rol rol) throws ConstraintViolationException {

		Set<ConstraintViolation<Rol>> constraintViolations = validator.validate(rol);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}

	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return rolRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Rol> findAll() {
		return rolRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rol save(Rol entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rol");
		}

		validate(entity);

		if (rolRepository.existsById(entity.getUserIdentification())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return rolRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Rol entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rol");
		}

		if (entity.getUserIdentification() == null) {
			throw new ZMessManager().new EmptyFieldException("userIdentification");
		}

		if (rolRepository.existsById(entity.getUserIdentification()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		findById(entity.getUserIdentification()).ifPresent(entidad -> {
			List<Admin> admins = entidad.getAdmins();
			if (Utilities.validationsList(admins) == true) {
				throw new ZMessManager().new DeletingException("admins");
			}
			List<Doctor> doctors = entidad.getDoctors();
			if (Utilities.validationsList(doctors) == true) {
				throw new ZMessManager().new DeletingException("doctors");
			}
			List<Patient> patients = entidad.getPatients();
			if (Utilities.validationsList(patients) == true) {
				throw new ZMessManager().new DeletingException("patients");
			}
		});

		rolRepository.deleteById(entity.getUserIdentification());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(String id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("userIdentification");
		}
		if (rolRepository.existsById(id)) {
			delete(rolRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rol update(Rol entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rol");
		}

		validate(entity);

		if (rolRepository.existsById(entity.getUserIdentification()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return rolRepository.save(entity);

	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Rol> findById(String userIdentification) {
		return rolRepository.findById(userIdentification);
	}

	// Registrar admins
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rol registerAdmin(Rol entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rol");
		}

		validate(entity);

		if (rolRepository.existsById(entity.getUserIdentification())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}
		entity = rolRepository.save(entity);
		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setUserId(entity.getUserIdentification());
		Admin admin = adminMapper.toAdmin(adminDTO);
		adminRepository.save(admin);
		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rol registerDoctor(RegistroDoctorDTO entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rol");
		}

		Rol rol = new Rol();
		rol.setEmail(entity.getEmail());
		rol.setIdentificationType(entity.getIdentificationType());
		rol.setPassword(entity.getPassword());
		rol.setRegister(entity.getRegister());
		rol.setRole(2);
		rol.setState(entity.getState());
		rol.setUserIdentification(entity.getUserIdentification());
		rol.setValidRegister(entity.getValidRegister());

		validate(rol);

		if (rolRepository.existsById(entity.getUserIdentification())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}
		rol = rolRepository.save(rol);
		DoctorDTO doctorDTO = new DoctorDTO();
		doctorDTO.setUserId(entity.getUserIdentification());
		doctorDTO.setCityI(entity.getCityI());
		Doctor doctor = doctorMapper.toDoctor(doctorDTO);
		doctorRepository.save(doctor);
		return rol;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rol registerPatient(RegistroPacienteDTO entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rol");
		}

		Rol rol = new Rol();
		rol.setEmail(entity.getEmail());
		rol.setIdentificationType(entity.getIdentificationType());
		rol.setPassword(entity.getPassword());
		rol.setRegister(entity.getRegister());
		rol.setRole(3);
		rol.setState(entity.getState());
		rol.setUserIdentification(entity.getUserIdentification());
		rol.setValidRegister(entity.getValidRegister());

		validate(rol);

		if (rolRepository.existsById(entity.getUserIdentification())) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}
		rol = rolRepository.save(rol);
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setUserId(entity.getUserIdentification());
		patientDTO.setCityI(entity.getCityI());
		patientDTO.setEpsI(entity.getEpsI());
		Patient patient = patientMapper.toPatient(patientDTO);
		patientRepository.save(patient);
		return rol;
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Rol> findByEmail(String email) {
		return rolRepository.findByEmail(email);
	}

}
