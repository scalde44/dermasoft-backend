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

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.dto.AdminDTO;
import co.edu.usbcali.demo.mapper.AdminMapper;
import co.edu.usbcali.demo.service.AdminService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private AdminMapper adminMapper;

	@GetMapping(value = "/{adminId}")
	public ResponseEntity<?> findById(@PathVariable("adminId") Integer adminId) throws Exception {

		Admin admin = (adminService.findById(adminId).isPresent() == true) ? adminService.findById(adminId).get()
				: null;

		return ResponseEntity.ok().body(adminMapper.toAdminDTO(admin));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(adminMapper.toAdminDTOs(adminService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody AdminDTO adminDTO) throws Exception {

		Admin admin = adminMapper.toAdmin(adminDTO);
		admin = adminService.save(admin);

		return ResponseEntity.ok().body(adminMapper.toAdminDTO(admin));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody AdminDTO adminDTO) throws Exception {

		Admin admin = adminMapper.toAdmin(adminDTO);
		admin = adminService.update(admin);

		return ResponseEntity.ok().body(adminMapper.toAdminDTO(admin));
	}

	@DeleteMapping(value = "/{adminId}")
	public ResponseEntity<?> delete(@PathVariable("adminId") Integer adminId) throws Exception {

		adminService.deleteById(adminId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(adminService.count());
	}
	@GetMapping(value = "/findByEmail/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable("email") String email) throws Exception {

		Admin admin = (adminService.buscarAdminPorEmail(email).isPresent() == true)
				? adminService.buscarAdminPorEmail(email).get()
				: null;

		return ResponseEntity.ok().body(adminMapper.toAdminDTO(admin));
	}
}
