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

import co.edu.usbcali.demo.domain.DoctorSubscription;
import co.edu.usbcali.demo.dto.DoctorSubscriptionDTO;
import co.edu.usbcali.demo.mapper.DoctorSubscriptionMapper;
import co.edu.usbcali.demo.service.DoctorSubscriptionService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/doctor-subscription")
@CrossOrigin(origins = "*")
public class DoctorSubscriptionRestController {
	@Autowired
	private DoctorSubscriptionService doctorSubscriptionService;
	@Autowired
	private DoctorSubscriptionMapper doctorSubscriptionMapper;

	@GetMapping(value = "/{doctorSubscriptionId}")
	public ResponseEntity<?> findById(@PathVariable("doctorSubscriptionId") Integer doctorSubscriptionId)
			throws Exception {
		DoctorSubscription doctorSubscription = (doctorSubscriptionService.findById(doctorSubscriptionId)
				.isPresent() == true) ? doctorSubscriptionService.findById(doctorSubscriptionId).get() : null;

		return ResponseEntity.ok()
				.body(doctorSubscriptionMapper.doctorSubscriptionToDoctorSubscriptionDTO(doctorSubscription));
	}

	@GetMapping(value = "/doctor/{doctorId}")
	public ResponseEntity<?> findByDoctorId(@PathVariable("doctorId") Integer doctorId) throws Exception {
		return ResponseEntity.ok().body(doctorSubscriptionMapper
				.listDoctorSubscriptionToListDoctorSubscriptionDTO(doctorSubscriptionService.findByDoctorId(doctorId)));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		return ResponseEntity.ok().body(doctorSubscriptionMapper
				.listDoctorSubscriptionToListDoctorSubscriptionDTO(doctorSubscriptionService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody DoctorSubscriptionDTO doctorSubscriptionDTO) throws Exception {

		DoctorSubscription doctorSubscription = doctorSubscriptionMapper
				.doctorSubscriptionDTOToDoctorSubscription(doctorSubscriptionDTO);
		doctorSubscription = doctorSubscriptionService.save(doctorSubscription);

		return ResponseEntity.ok()
				.body(doctorSubscriptionMapper.doctorSubscriptionToDoctorSubscriptionDTO(doctorSubscription));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody DoctorSubscriptionDTO doctorSubscriptionDTO) throws Exception {

		DoctorSubscription doctorSubscription = doctorSubscriptionMapper
				.doctorSubscriptionDTOToDoctorSubscription(doctorSubscriptionDTO);
		doctorSubscription = doctorSubscriptionService.update(doctorSubscription);

		return ResponseEntity.ok()
				.body(doctorSubscriptionMapper.doctorSubscriptionToDoctorSubscriptionDTO(doctorSubscription));
	}

	@DeleteMapping(value = "/{doctorSubscriptionId}")
	public ResponseEntity<?> delete(@PathVariable("doctorSubscriptionId") Integer doctorSubscriptionId)
			throws Exception {

		doctorSubscriptionService.deleteById(doctorSubscriptionId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(doctorSubscriptionService.count());
	}
}
