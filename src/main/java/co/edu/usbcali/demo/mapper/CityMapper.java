package co.edu.usbcali.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.demo.domain.City;
import co.edu.usbcali.demo.dto.CityDTO;

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
public interface CityMapper {

	@Mapping(source = "department.departmentId", target = "departmentI")
	public CityDTO toCityDTO(City city);

	@Mapping(source = "departmentI", target = "department.departmentId")
	public City toCity(CityDTO cityDTO);

	public List<CityDTO> toCityDTOs(List<City> cities);

	public List<City> toCities(List<CityDTO> cityDTOs);
}
