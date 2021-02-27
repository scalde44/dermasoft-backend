package co.edu.usbcali.demo.service;

import java.util.Optional;

import co.edu.usbcali.demo.domain.Rol;
import co.edu.usbcali.demo.dto.RegistroDoctorDTO;
import co.edu.usbcali.demo.dto.RegistroPacienteDTO;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface RolService extends GenericService<Rol, String> {
	// Método registrar admin
	public Rol registerAdmin(Rol entity) throws Exception;

	// Método registrar doctor
	public Rol registerDoctor(RegistroDoctorDTO entity) throws Exception;

	// Método registrar paciente
	public Rol registerPatient(RegistroPacienteDTO entity) throws Exception;

	// Traer user con email
	public Optional<Rol> findByEmail(String email);
}
