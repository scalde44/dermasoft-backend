package co.edu.usbcali.demo.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.demo.service.JasperReportService;

/**
 * 
 * Clase JasperReportRestController.
 * 
 * Este controlador expone todos los servicios de {@link JasperReportService}
 * 
 * @author Steven Calderon
 * @version 1.0
 */
@RestController
@RequestMapping("/report")
@CrossOrigin(origins = "*")
public class JasperReportRestController {

	// Inyeccion de dependencias
	@Autowired
	private JasperReportService jasperReportService;

	@GetMapping("/appointment/{appointmentId}")
	public ResponseEntity<InputStreamResource> generarReporteCita(@PathVariable("appointmentId") Long appointmentId)
			throws Exception {
		ByteArrayInputStream bais = jasperReportService.generarReporteCita(appointmentId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename=reporteCita.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bais));
	}

}
