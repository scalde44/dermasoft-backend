package co.edu.usbcali.demo.service;

import java.util.List;

import co.edu.usbcali.demo.domain.Rating;
import co.edu.usbcali.demo.dto.RatingDoctorDTO;

public interface RatingService extends GenericService<Rating, Long> {
	List<RatingDoctorDTO> findByDoctorId(Integer doctorId);
}
