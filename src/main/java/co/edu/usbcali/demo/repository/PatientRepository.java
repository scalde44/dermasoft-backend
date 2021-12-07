package co.edu.usbcali.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.demo.domain.Patient;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	// Buscar paciente por email
	@Query("SELECT p FROM Patient p WHERE p.rol.email=:email")
	public Optional<Patient> buscarPacientePorEmail(String email);

	List<Patient> findAllByOrderByPatientId();
}
