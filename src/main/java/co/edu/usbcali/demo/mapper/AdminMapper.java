package co.edu.usbcali.demo.mapper;

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.dto.AdminDTO;

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
public interface AdminMapper {

	@Mapping(source = "rol.userIdentification", target = "userId")
	public AdminDTO toAdminDTO(Admin admin);

	@Mapping(source = "userId", target = "rol.userIdentification")
	public Admin toAdmin(AdminDTO adminDTO);

	public List<AdminDTO> toAdminDTOs(List<Admin> admins);

	public List<Admin> toAdmins(List<AdminDTO> adminDTOs);
}
