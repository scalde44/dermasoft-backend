package co.edu.usbcali.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.demo.domain.Treatment;
import co.edu.usbcali.demo.dto.TreatmentDTO;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 *         Mapper Build with MapStruct https://mapstruct.org MapStruct is a code
 *         generator that greatly simplifies the implementation of mappings
 *         between Java bean type based on a convention over configuration
 *         approach.
 */
@Mapper
public interface TreatmentMapper {

	@Mapping(source = "appointment.appointmentId", target = "appointmentI")
	@Mapping(source = "product.productId", target = "productI")
	public TreatmentDTO treatmentToTreatmentDTO(Treatment treatment);

	@Mapping(source = "appointmentI", target = "appointment.appointmentId")
	@Mapping(source = "productI", target = "product.productId")
	public Treatment treatmentDTOToTreatment(TreatmentDTO treatmentDTO);

	public List<TreatmentDTO> listTreatmentToListTreatmentDTO(List<Treatment> treatments);

	public List<Treatment> listTreatmentDTOToListTreatment(List<TreatmentDTO> treatmentDTOs);
}
