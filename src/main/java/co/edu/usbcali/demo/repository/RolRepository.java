package co.edu.usbcali.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.demo.domain.Rol;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface RolRepository extends JpaRepository<Rol, String> {
	// Traer user con email
	public Optional<Rol> findByEmail(String email);
}
