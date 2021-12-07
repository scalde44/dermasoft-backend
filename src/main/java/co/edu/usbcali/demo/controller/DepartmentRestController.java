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

import co.edu.usbcali.demo.domain.Department;
import co.edu.usbcali.demo.dto.DepartmentDTO;
import co.edu.usbcali.demo.mapper.DepartmentMapper;
import co.edu.usbcali.demo.service.DepartmentService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "*")
public class DepartmentRestController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentMapper departmentMapper;

	@GetMapping(value = "/{departmentId}")
	public ResponseEntity<?> findById(@PathVariable("departmentId") Integer departmentId) throws Exception {

		Department department = (departmentService.findById(departmentId).isPresent() == true)
				? departmentService.findById(departmentId).get()
				: null;

		return ResponseEntity.ok().body(departmentMapper.departmentToDepartmentDTO(department));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok()
				.body(departmentMapper.listDepartmentToListDepartmentDTO(departmentService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody DepartmentDTO departmentDTO) throws Exception {

		Department department = departmentMapper.departmentDTOToDepartment(departmentDTO);
		department = departmentService.save(department);

		return ResponseEntity.ok().body(departmentMapper.departmentToDepartmentDTO(department));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody DepartmentDTO departmentDTO) throws Exception {

		Department department = departmentMapper.departmentDTOToDepartment(departmentDTO);
		department = departmentService.update(department);

		return ResponseEntity.ok().body(departmentMapper.departmentToDepartmentDTO(department));
	}

	@DeleteMapping(value = "/{departmentId}")
	public ResponseEntity<?> delete(@PathVariable("departmentId") Integer departmentId) throws Exception {

		departmentService.deleteById(departmentId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(departmentService.count());
	}
}
