package co.edu.usbcali.demo.service;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.dto.PatientAppointmentDTO;

import java.math.*;

import java.util.*;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface AppointmentService extends GenericService<Appointment, Integer> {
	// Buscar pacientes por doctores
	public List<PatientAppointmentDTO> buscarPacientesPorDoctor(Integer doctorId);
}
