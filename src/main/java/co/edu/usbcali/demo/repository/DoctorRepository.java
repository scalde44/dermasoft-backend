package co.edu.usbcali.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.demo.domain.Doctor;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	// Buscar doctor por email
	@Query("SELECT d FROM Doctor d WHERE d.rol.email=:email")
	public Optional<Doctor> buscarDoctorPorEmail(String email);
}
