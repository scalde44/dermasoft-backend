package co.edu.usbcali.demo.service;

import java.util.List;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Patient;
import co.edu.usbcali.demo.dto.CantidadCitasAnoDTO;
import co.edu.usbcali.demo.dto.FinalizarCitaDTO;
import co.edu.usbcali.demo.dto.PatientAppointmentDTO;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface AppointmentService extends GenericService<Appointment, Integer> {
	// Buscar citas por doctores
	public List<PatientAppointmentDTO> buscarCitasPorDoctor(Integer doctorId);

	// Buscar citas por pacientes
	public List<PatientAppointmentDTO> buscarCitasPorPaciente(Integer patientId);

	// Crear dto finalizar cita
	public FinalizarCitaDTO crearFinalizarCitaDTOById(Integer appointmentId);

	// Cerrar cita
	public Appointment cerrarCita(Integer appointmentId) throws Exception;

	// Reporte citas por doctor
	public List<CantidadCitasAnoDTO> findCitasDoctorAnuales(Integer doctorId);

	// Buscar pacientes por doctor
	public List<Patient> buscarPacientesPorDoctor(Integer doctorId);
}
