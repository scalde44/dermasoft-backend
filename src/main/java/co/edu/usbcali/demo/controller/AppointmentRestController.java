package co.edu.usbcali.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.dto.AppointmentDTO;
import co.edu.usbcali.demo.mapper.AppointmentMapper;
import co.edu.usbcali.demo.service.AppointmentService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin(origins = "*")
public class AppointmentRestController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private AppointmentMapper appointmentMapper;

	@GetMapping(value = "/{appointmentId}")
	public ResponseEntity<?> findById(@PathVariable("appointmentId") Integer appointmentId) throws Exception {

		Appointment appointment = (appointmentService.findById(appointmentId).isPresent() == true)
				? appointmentService.findById(appointmentId).get()
				: null;

		return ResponseEntity.ok().body(appointmentMapper.toAppointmentDTO(appointment));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(appointmentMapper.toAppointmentDTOs(appointmentService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody AppointmentDTO appointmentDTO) throws Exception {

		Appointment appointment = appointmentMapper.toAppointment(appointmentDTO);
		appointment = appointmentService.save(appointment);

		return ResponseEntity.ok().body(appointmentMapper.toAppointmentDTO(appointment));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody AppointmentDTO appointmentDTO) throws Exception {

		Appointment appointment = appointmentMapper.toAppointment(appointmentDTO);
		appointment = appointmentService.update(appointment);

		return ResponseEntity.ok().body(appointmentMapper.toAppointmentDTO(appointment));
	}

	@DeleteMapping(value = "/{appointmentId}")
	public ResponseEntity<?> delete(@PathVariable("appointmentId") Integer appointmentId) throws Exception {

		appointmentService.deleteById(appointmentId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(appointmentService.count());
	}

	// Buscar citas por doctor
	@GetMapping("/findByDoctor/{doctorId}")
	public ResponseEntity<?> findByDoctor(@PathVariable("doctorId") Integer doctorId) throws Exception {

		return ResponseEntity.ok().body(appointmentService.buscarPacientesPorDoctor(doctorId));
	}

	// Buscar citas por paciente
	@GetMapping("/findByPatient/{patientId}")
	public ResponseEntity<?> findByPatient(@PathVariable("patientId") Integer patientId) throws Exception {

		return ResponseEntity.ok().body(appointmentService.buscarCitasPorPaciente(patientId));
	}
}
