package co.edu.usbcali.demo.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.dto.CantidadCitasAnoDTO;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	// Buscar citas por doctor
	public List<Appointment> findByDoctor(Doctor doctor);

	// Buscar pacientes por doctor
	@Query("select distinct (a.patient) from Appointment a where a.doctor=:doctor")
	public List<Patient> findPatientsByDoctor(Doctor doctor);

	// Buscar citas por paciente
	public List<Appointment> findByPatient(Patient patient);

	// Buscar citas por doctor y fecha
	public Optional<Appointment> findByDateAndDoctor(Date date, Doctor doctor);

	// Buscar citas por paciente y fecha
	public Optional<Appointment> findByDateAndPatient(Date date, Patient patient);

	// Cantidad de citas en el ano del doctor agrupadas por mes y año
	@Query(value = "select mes_name as nombreMes, coalesce(cita.contador,0) as cantidadCitas " + "from mes left join "
			+ "(select count(appointment_id) as contador,date_part('month',date) as mes_actual,date_part('year',date) as ano_actual "
			+ "from appointment where doctor_id=:doctorId and date_part('year', date)=date_part('year', now()) "
			+ "group by mes_actual,ano_actual) cita ON cita.mes_actual=mes.mes_number", nativeQuery = true)
	public List<CantidadCitasAnoDTO> findCitasDoctorAnuales(Integer doctorId);

}
