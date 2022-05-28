package co.edu.usbcali.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.demo.domain.Rating;
import co.edu.usbcali.demo.dto.RatingDTO;

@Mapper
public interface RatingMapper {
	@Mapping(source = "appointment.appointmentId", target = "appointmentId")
	public RatingDTO toRatingDTO(Rating rating);

	@Mapping(source = "appointmentId", target = "appointment.appointmentId")
	public Rating toRating(RatingDTO dto);

	public List<RatingDTO> toRatingDTOs(List<Rating> ratings);

	public List<Rating> toRatings(List<RatingDTO> ratingDTOs);
}
