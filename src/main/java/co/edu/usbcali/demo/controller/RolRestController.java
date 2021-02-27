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

import co.edu.usbcali.demo.domain.Rol;
import co.edu.usbcali.demo.dto.RegistroDoctorDTO;
import co.edu.usbcali.demo.dto.RegistroPacienteDTO;
import co.edu.usbcali.demo.dto.RolDTO;
import co.edu.usbcali.demo.mapper.RolMapper;
import co.edu.usbcali.demo.service.RolService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/rol")
@CrossOrigin(origins = "*")
public class RolRestController {
	@Autowired
	private RolService rolService;
	@Autowired
	private RolMapper rolMapper;

	@GetMapping(value = "/{userIdentification}")
	public ResponseEntity<?> findById(@PathVariable("userIdentification") String userIdentification) throws Exception {

		Rol rol = (rolService.findById(userIdentification).isPresent() == true)
				? rolService.findById(userIdentification).get()
				: null;

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(rolMapper.listRolToListRolDTO(rolService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody RolDTO rolDTO) throws Exception {

		Rol rol = rolMapper.rolDTOToRol(rolDTO);
		rol = rolService.save(rol);

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody RolDTO rolDTO) throws Exception {

		Rol rol = rolMapper.rolDTOToRol(rolDTO);
		rol = rolService.update(rol);

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}

	@DeleteMapping(value = "/{userIdentification}")
	public ResponseEntity<?> delete(@PathVariable("userIdentification") String userIdentification) throws Exception {

		rolService.deleteById(userIdentification);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(rolService.count());
	}

	// Método registrar admins
	@PostMapping("/registerAdmin")
	public ResponseEntity<?> registerAdmin(@Valid @RequestBody RolDTO rolDTO) throws Exception {

		Rol rol = rolMapper.rolDTOToRol(rolDTO);
		rol = rolService.registerAdmin(rol);

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}

	// Método registrar doctores
	@PostMapping("/registerDoctor")
	public ResponseEntity<?> registerDoctor(@Valid @RequestBody RegistroDoctorDTO registroDoctorDTO) throws Exception {

		Rol rol = rolService.registerDoctor(registroDoctorDTO);

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}

	// Método registrar pacientes
	@PostMapping("/registerPatient")
	public ResponseEntity<?> registerPatient(@Valid @RequestBody RegistroPacienteDTO registroPacienteDTO)
			throws Exception {

		Rol rol = rolService.registerPatient(registroPacienteDTO);

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}

	// Login
	@GetMapping("findByEmail/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) throws Exception {

		Rol rol = (rolService.findByEmail(email).isPresent() == true) ? rolService.findByEmail(email).get() : null;

		return ResponseEntity.ok().body(rolMapper.rolToRolDTO(rol));
	}
}
