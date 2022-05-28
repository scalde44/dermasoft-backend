package co.edu.usbcali.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.demo.domain.Rating;
import co.edu.usbcali.demo.dto.RatingDTO;
import co.edu.usbcali.demo.mapper.RatingMapper;
import co.edu.usbcali.demo.service.RatingService;

@RestController
@RequestMapping("/rating")
@CrossOrigin(origins = "*")
public class RatingRestController {
	private final RatingService ratingService;
	private final RatingMapper ratingMapper;

	public RatingRestController(RatingService ratingService, RatingMapper ratingMapper) {
		this.ratingService = ratingService;
		this.ratingMapper = ratingMapper;
	}

	@GetMapping
	public ResponseEntity<?> findAll() throws Exception {
		return ResponseEntity.ok().body(this.ratingMapper.toRatingDTOs(this.ratingService.findAll()));
	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody RatingDTO dto) throws Exception {
		Rating rating = this.ratingMapper.toRating(dto);
		rating = this.ratingService.save(rating);
		return ResponseEntity.ok().body(this.ratingMapper.toRatingDTO(rating));
	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<?> findByDoctor(@PathVariable(name = "id") Integer id) throws Exception {
		return ResponseEntity.ok().body(this.ratingService.findByDoctorId(id));
	}
}
