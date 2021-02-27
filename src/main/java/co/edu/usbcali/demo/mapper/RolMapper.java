package co.edu.usbcali.demo.mapper;

import co.edu.usbcali.demo.domain.Rol;
import co.edu.usbcali.demo.dto.RolDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface RolMapper {
    public RolDTO rolToRolDTO(Rol rol);

    public Rol rolDTOToRol(RolDTO rolDTO);

    public List<RolDTO> listRolToListRolDTO(List<Rol> rols);

    public List<Rol> listRolDTOToListRol(List<RolDTO> rolDTOs);
}
