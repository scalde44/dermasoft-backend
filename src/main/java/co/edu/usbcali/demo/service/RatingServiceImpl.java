package co.edu.usbcali.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Rating;
import co.edu.usbcali.demo.dto.RatingDoctorDTO;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	private final RatingRepository ratingRepository;
	private final DoctorService doctorService;
	private final AppointmentService appointmentService;
	private final Validator validator;

	public RatingServiceImpl(RatingRepository ratingRepository, Validator validator, DoctorService doctorService,
			AppointmentService appointmentService) {
		this.ratingRepository = ratingRepository;
		this.doctorService = doctorService;
		this.appointmentService = appointmentService;
		this.validator = validator;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Rating> findAll() {
		return this.ratingRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Rating> findById(Long id) {
		return this.ratingRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rating save(Rating entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rating");
		}

		validate(entity);
		int reputacion = 0;
		Appointment appointment = this.appointmentService.findById(entity.getAppointment().getAppointmentId()).get();
		Doctor doctor = appointment.getDoctor();
		List<Appointment> appointments = doctor.getAppointments();
		if (appointments != null) {
			reputacion = sumarObtenerPromedio(
					appointments.stream().map(a -> a.getDoctor().getReputation()).collect(Collectors.toList()),
					entity.getRatingValue());
		} else {
			reputacion = entity.getRatingValue();
		}

		doctor.setReputation(reputacion);
		this.doctorService.update(doctor);
		entity = this.ratingRepository.save(entity);

		return entity;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Rating update(Rating entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rating");
		}

		validate(entity);

		if (this.ratingRepository.existsById(entity.getRatingId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return this.ratingRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Rating entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Rating");
		}

		if (entity.getRatingId() == null) {
			throw new ZMessManager().new EmptyFieldException("ratingId");
		}

		if (this.ratingRepository.existsById(entity.getRatingId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		this.ratingRepository.deleteById(entity.getRatingId());
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Long id) throws Exception {
		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("ratingId");
		}
		if (this.ratingRepository.existsById(id)) {
			delete(this.ratingRepository.findById(id).get());
		}
	}

	@Override
	public void validate(Rating entity) throws ConstraintViolationException {
		Set<ConstraintViolation<Rating>> constraintViolations = validator.validate(entity);
		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return this.ratingRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<RatingDoctorDTO> findByDoctorId(Integer doctorId) {
		List<Rating> ratings = this.ratingRepository.buscarCalificacionPorDoctorId(doctorId);
		return ratings.stream()
				.map(r -> new RatingDoctorDTO(r.getRatingValue(), r.getRatingDescription(),
						r.getAppointment().getPatient().getFirstName(), r.getAppointment().getPatient().getLastName(),
						r.getAppointment().getPatient().getImage(), r.getValidRegister()))
				.collect(Collectors.toList());
	}

	private int sumarObtenerPromedio(List<Integer> calificaciones, int calificar) {
		int acumulado = 0;
		int salida = 0;
		double promedio = 0.0;
		for (Integer c : calificaciones) {
			if (c != null)
				acumulado += c;
		}
		acumulado += calificar;
		salida = acumulado / (calificaciones.size() + 1);
		return salida;
	}

}
