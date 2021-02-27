package co.edu.usbcali.demo.mapper;

import co.edu.usbcali.demo.domain.Appointment;
import co.edu.usbcali.demo.dto.AppointmentDTO;

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
public interface AppointmentMapper {

	@Mapping(source = "doctor.doctorId", target = "doctorI")
	@Mapping(source = "patient.patientId", target = "patientI")
	public AppointmentDTO toAppointmentDTO(Appointment appointment);

	@Mapping(source = "doctorI", target = "doctor.doctorId")
	@Mapping(source = "patientI", target = "patient.patientId")
	public Appointment toAppointment(AppointmentDTO appointmentDTO);

	public List<AppointmentDTO> toAppointmentDTOs(List<Appointment> appointments);

	public List<Appointment> toAppointments(List<AppointmentDTO> appointmentDTOs);
}
