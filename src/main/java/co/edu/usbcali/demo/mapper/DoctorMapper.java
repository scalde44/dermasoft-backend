package co.edu.usbcali.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.dto.DoctorDTO;

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
public interface DoctorMapper {

	@Mapping(source = "city.cityId", target = "cityI")
	@Mapping(source = "rol.userIdentification", target = "userId")
	public DoctorDTO toDoctorDTO(Doctor doctor);

	@Mapping(source = "cityI", target = "city.cityId")
	@Mapping(source = "userId", target = "rol.userIdentification")
	public Doctor toDoctor(DoctorDTO doctorDTO);

	public List<DoctorDTO> toDoctorDTOs(List<Doctor> doctors);

	public List<Doctor> toDoctors(List<DoctorDTO> doctorDTOs);
}
