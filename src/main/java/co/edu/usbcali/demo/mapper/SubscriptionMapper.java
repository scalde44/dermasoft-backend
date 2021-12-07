package co.edu.usbcali.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.demo.domain.Subscription;
import co.edu.usbcali.demo.dto.SubscriptionDTO;

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
public interface SubscriptionMapper {
	public SubscriptionDTO subscriptionToSubscriptionDTO(Subscription subscription);

	public Subscription subscriptionDTOToSubscription(SubscriptionDTO subscriptionDTO);

	public List<SubscriptionDTO> listSubscriptionToListSubscriptionDTO(List<Subscription> subscriptions);

	public List<Subscription> listSubscriptionDTOToListSubscription(List<SubscriptionDTO> subscriptionDTOs);
}
