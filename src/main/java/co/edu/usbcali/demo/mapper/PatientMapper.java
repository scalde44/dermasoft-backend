package co.edu.usbcali.demo.mapper;

import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.dto.PatientDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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
public interface PatientMapper {

	@Mapping(source = "city.cityId", target = "cityI")
	@Mapping(source = "eps.epsId", target = "epsI")
	@Mapping(source = "rol.userIdentification", target = "userId")
	@Mapping(source = "rol.state", target = "state")
	public PatientDTO toPatientDTO(Patient patient);

	@Mapping(source = "cityI", target = "city.cityId")
	@Mapping(source = "epsI", target = "eps.epsId")
	@Mapping(source = "userId", target = "rol.userIdentification")
	@Mapping(source = "state", target = "rol.state")
	public Patient toPatient(PatientDTO patientDTO);

	public List<PatientDTO> toPatientDTOs(List<Patient> patients);

	public List<Patient> toPatients(List<PatientDTO> patientDTOs);
}
