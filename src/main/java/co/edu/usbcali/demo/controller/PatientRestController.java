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

import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.dto.PatientDTO;
import co.edu.usbcali.demo.mapper.PatientMapper;
import co.edu.usbcali.demo.service.PatientService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/patient")
@CrossOrigin(origins = "*")
public class PatientRestController {
	@Autowired
	private PatientService patientService;
	@Autowired
	private PatientMapper patientMapper;

	@GetMapping(value = "/{patientId}")
	public ResponseEntity<?> findById(@PathVariable("patientId") Integer patientId) throws Exception {

		Patient patient = (patientService.findById(patientId).isPresent() == true)
				? patientService.findById(patientId).get()
				: null;

		return ResponseEntity.ok().body(patientMapper.toPatientDTO(patient));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(patientMapper.toPatientDTOs(patientService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody PatientDTO patientDTO) throws Exception {

		Patient patient = patientMapper.toPatient(patientDTO);
		patient = patientService.save(patient);

		return ResponseEntity.ok().body(patientMapper.toPatientDTO(patient));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody PatientDTO patientDTO) throws Exception {

		Patient patient = patientMapper.toPatient(patientDTO);
		patient = patientService.update(patient);

		return ResponseEntity.ok().body(patientMapper.toPatientDTO(patient));
	}

	@DeleteMapping(value = "/{patientId}")
	public ResponseEntity<?> delete(@PathVariable("patientId") Integer patientId) throws Exception {

		patientService.deleteById(patientId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(patientService.count());
	}
	
	@GetMapping(value = "/buscarPorEmail/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) throws Exception {

		Patient patient = (patientService.buscarPacientePorEmail(email).isPresent() == true)
				? patientService.buscarPacientePorEmail(email).get()
				: null;

		return ResponseEntity.ok().body(patientMapper.toPatientDTO(patient));
	}
}
