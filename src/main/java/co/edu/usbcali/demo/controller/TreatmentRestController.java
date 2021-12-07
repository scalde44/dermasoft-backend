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

import co.edu.usbcali.demo.domain.Treatment;
import co.edu.usbcali.demo.dto.TreatmentDTO;
import co.edu.usbcali.demo.mapper.TreatmentMapper;
import co.edu.usbcali.demo.service.TreatmentService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/treatment")
@CrossOrigin(origins = "*")
public class TreatmentRestController {
	@Autowired
	private TreatmentService treatmentService;
	@Autowired
	private TreatmentMapper treatmentMapper;

	@GetMapping(value = "/{treatmentId}")
	public ResponseEntity<?> findById(@PathVariable("treatmentId") Integer treatmentId) throws Exception {

		Treatment treatment = (treatmentService.findById(treatmentId).isPresent() == true)
				? treatmentService.findById(treatmentId).get()
				: null;

		return ResponseEntity.ok().body(treatmentMapper.treatmentToTreatmentDTO(treatment));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(treatmentMapper.listTreatmentToListTreatmentDTO(treatmentService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody TreatmentDTO treatmentDTO) throws Exception {

		Treatment treatment = treatmentMapper.treatmentDTOToTreatment(treatmentDTO);
		treatment = treatmentService.save(treatment);

		return ResponseEntity.ok().body(treatmentMapper.treatmentToTreatmentDTO(treatment));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody TreatmentDTO treatmentDTO) throws Exception {

		Treatment treatment = treatmentMapper.treatmentDTOToTreatment(treatmentDTO);
		treatment = treatmentService.update(treatment);

		return ResponseEntity.ok().body(treatmentMapper.treatmentToTreatmentDTO(treatment));
	}

	@DeleteMapping(value = "/{treatmentId}")
	public ResponseEntity<?> delete(@PathVariable("treatmentId") Integer treatmentId) throws Exception {

		treatmentService.deleteById(treatmentId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(treatmentService.count());
	}
}
