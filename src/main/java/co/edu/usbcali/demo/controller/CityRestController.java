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

import co.edu.usbcali.demo.domain.City;
import co.edu.usbcali.demo.dto.CityDTO;
import co.edu.usbcali.demo.mapper.CityMapper;
import co.edu.usbcali.demo.service.CityService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/api/v1/city")
@CrossOrigin(origins = "*")
public class CityRestController {
	@Autowired
	private CityService cityService;
	@Autowired
	private CityMapper cityMapper;

	@GetMapping(value = "/{cityId}")
	public ResponseEntity<?> findById(@PathVariable("cityId") Integer cityId) throws Exception {

		City city = (cityService.findById(cityId).isPresent() == true) ? cityService.findById(cityId).get() : null;

		return ResponseEntity.ok().body(cityMapper.toCityDTO(city));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {

		return ResponseEntity.ok().body(cityMapper.toCityDTOs(cityService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody CityDTO cityDTO) throws Exception {

		City city = cityMapper.toCity(cityDTO);
		city = cityService.save(city);

		return ResponseEntity.ok().body(cityMapper.toCityDTO(city));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody CityDTO cityDTO) throws Exception {

		City city = cityMapper.toCity(cityDTO);
		city = cityService.update(city);

		return ResponseEntity.ok().body(cityMapper.toCityDTO(city));
	}

	@DeleteMapping(value = "/{cityId}")
	public ResponseEntity<?> delete(@PathVariable("cityId") Integer cityId) throws Exception {

		cityService.deleteById(cityId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(cityService.count());
	}
}
