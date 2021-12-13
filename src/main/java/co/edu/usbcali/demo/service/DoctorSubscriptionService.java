package co.edu.usbcali.demo.service;

import java.util.List;

import co.edu.usbcali.demo.domain.DoctorSubscription;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface DoctorSubscriptionService extends GenericService<DoctorSubscription, Integer> {
	List<DoctorSubscription> findByDoctorId(Integer doctorId);
}
