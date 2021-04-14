package co.edu.usbcali.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Patient;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	// Buscar citas por doctor
	public List<Appointment> findByDoctor(Doctor doctor);
	// Buscar citas por paciente
	public List<Appointment> findByPatient(Patient patient);
}
