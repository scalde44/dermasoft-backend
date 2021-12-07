package co.edu.usbcali.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.demo.domain.Subscription;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
	List<Subscription> findAllByOrderBySubscriptionId();
}
