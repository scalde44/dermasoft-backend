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

import co.edu.usbcali.demo.domain.Eps;
import co.edu.usbcali.demo.dto.EpsDTO;
import co.edu.usbcali.demo.mapper.EpsMapper;
import co.edu.usbcali.demo.service.EpsService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/eps")
@CrossOrigin(origins = "*")
public class EpsRestController {
	@Autowired
	private EpsService epsService;
	@Autowired
	private EpsMapper epsMapper;

	@GetMapping(value = "/{epsId}")
	public ResponseEntity<?> findById(@PathVariable("epsId") Integer epsId) throws Exception {

		Eps eps = (epsService.findById(epsId).isPresent() == true) ? epsService.findById(epsId).get() : null;

		return ResponseEntity.ok().body(epsMapper.epsToEpsDTO(eps));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(epsMapper.listEpsToListEpsDTO(epsService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody EpsDTO epsDTO) throws Exception {

		Eps eps = epsMapper.epsDTOToEps(epsDTO);
		eps = epsService.save(eps);

		return ResponseEntity.ok().body(epsMapper.epsToEpsDTO(eps));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody EpsDTO epsDTO) throws Exception {

		Eps eps = epsMapper.epsDTOToEps(epsDTO);
		eps = epsService.update(eps);

		return ResponseEntity.ok().body(epsMapper.epsToEpsDTO(eps));
	}

	@DeleteMapping(value = "/{epsId}")
	public ResponseEntity<?> delete(@PathVariable("epsId") Integer epsId) throws Exception {

		epsService.deleteById(epsId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(epsService.count());
	}
}
