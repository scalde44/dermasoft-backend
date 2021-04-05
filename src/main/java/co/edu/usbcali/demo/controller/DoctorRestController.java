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

import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.dto.DoctorDTO;
import co.edu.usbcali.demo.mapper.DoctorMapper;
import co.edu.usbcali.demo.service.DoctorService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/doctor")
@CrossOrigin(origins = "*")
public class DoctorRestController {
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private DoctorMapper doctorMapper;

	@GetMapping(value = "/{doctorId}")
	public ResponseEntity<?> findById(@PathVariable("doctorId") Integer doctorId) throws Exception {

		Doctor doctor = (doctorService.findById(doctorId).isPresent() == true) ? doctorService.findById(doctorId).get()
				: null;

		return ResponseEntity.ok().body(doctorMapper.toDoctorDTO(doctor));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(doctorMapper.toDoctorDTOs(doctorService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody DoctorDTO doctorDTO) throws Exception {

		Doctor doctor = doctorMapper.toDoctor(doctorDTO);
		doctor = doctorService.save(doctor);

		return ResponseEntity.ok().body(doctorMapper.toDoctorDTO(doctor));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody DoctorDTO doctorDTO) throws Exception {

		Doctor doctor = doctorMapper.toDoctor(doctorDTO);
		doctor = doctorService.update(doctor);

		return ResponseEntity.ok().body(doctorMapper.toDoctorDTO(doctor));
	}

	@DeleteMapping(value = "/{doctorId}")
	public ResponseEntity<?> delete(@PathVariable("doctorId") Integer doctorId) throws Exception {

		doctorService.deleteById(doctorId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(doctorService.count());
	}

	@GetMapping(value = "/findByEmail/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) throws Exception {

		Doctor doctor = (doctorService.buscarDoctorPorEmail(email).isPresent() == true)
				? doctorService.buscarDoctorPorEmail(email).get()
				: null;

		return ResponseEntity.ok().body(doctorMapper.toDoctorDTO(doctor));
	}

}
