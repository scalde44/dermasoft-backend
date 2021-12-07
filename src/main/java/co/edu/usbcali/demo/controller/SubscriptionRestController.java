package co.edu.usbcali.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.demo.domain.Subscription;
import co.edu.usbcali.demo.dto.SubscriptionDTO;
import co.edu.usbcali.demo.mapper.SubscriptionMapper;
import co.edu.usbcali.demo.service.SubscriptionService;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@RestController
@RequestMapping("/subscription")
@CrossOrigin(origins = "*")
public class SubscriptionRestController {
	@Autowired
	private SubscriptionService subscriptionService;
	@Autowired
	private SubscriptionMapper subscriptionMapper;

	@GetMapping(value = "/{subscriptionId}")
	public ResponseEntity<?> findById(@PathVariable("subscriptionId") Integer subscriptionId) throws Exception {
		Subscription subscription = (subscriptionService.findById(subscriptionId).isPresent() == true)
				? subscriptionService.findById(subscriptionId).get()
				: null;

		return ResponseEntity.ok().body(subscriptionMapper.subscriptionToSubscriptionDTO(subscription));
	}

	@GetMapping()
	public ResponseEntity<?> findAll() throws Exception {
		return ResponseEntity.ok()
				.body(subscriptionMapper.listSubscriptionToListSubscriptionDTO(subscriptionService.findAll()));
	}

	@PostMapping()
	public ResponseEntity<?> save(@Valid @RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
		Subscription subscription = subscriptionMapper.subscriptionDTOToSubscription(subscriptionDTO);
		subscription = subscriptionService.save(subscription);

		return ResponseEntity.ok().body(subscriptionMapper.subscriptionToSubscriptionDTO(subscription));
	}

	@PutMapping()
	public ResponseEntity<?> update(@Valid @RequestBody SubscriptionDTO subscriptionDTO) throws Exception {
		Subscription subscription = subscriptionMapper.subscriptionDTOToSubscription(subscriptionDTO);
		subscription = subscriptionService.update(subscription);

		return ResponseEntity.ok().body(subscriptionMapper.subscriptionToSubscriptionDTO(subscription));
	}

	@DeleteMapping(value = "/{subscriptionId}")
	public ResponseEntity<?> delete(@PathVariable("subscriptionId") Integer subscriptionId) throws Exception {
		subscriptionService.deleteById(subscriptionId);

		return ResponseEntity.ok().build();
	}

	@GetMapping(value = "/count")
	public ResponseEntity<?> count() {
		return ResponseEntity.ok().body(subscriptionService.count());
	}
}
