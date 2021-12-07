package co.edu.usbcali.demo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.demo.domain.DoctorSubscription;
import co.edu.usbcali.demo.dto.DoctorSubscriptionDTO;

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
public interface DoctorSubscriptionMapper {
	@Mapping(source = "doctor.doctorId", target = "doctorId")
	@Mapping(source = "subscription.subscriptionId", target = "subscriptionId")
	public DoctorSubscriptionDTO doctorSubscriptionToDoctorSubscriptionDTO(DoctorSubscription doctorSubscription);

	@InheritInverseConfiguration
	public DoctorSubscription doctorSubscriptionDTOToDoctorSubscription(DoctorSubscriptionDTO doctorSubscriptionDTO);

	public List<DoctorSubscriptionDTO> listDoctorSubscriptionToListDoctorSubscriptionDTO(
			List<DoctorSubscription> doctorSubscriptions);

	public List<DoctorSubscription> listDoctorSubscriptionDTOToListDoctorSubscription(
			List<DoctorSubscriptionDTO> doctorSubscriptionDTOs);
}
