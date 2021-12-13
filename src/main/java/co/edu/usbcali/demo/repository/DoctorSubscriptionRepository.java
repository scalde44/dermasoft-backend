package co.edu.usbcali.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.demo.domain.DoctorSubscription;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface DoctorSubscriptionRepository extends JpaRepository<DoctorSubscription, Integer> {
	@Query(value = "SELECT ds FROM DoctorSubscription ds WHERE ds.doctor.doctorId=:doctorId")
	List<DoctorSubscription> findByDoctorId(Integer doctorId);
}
