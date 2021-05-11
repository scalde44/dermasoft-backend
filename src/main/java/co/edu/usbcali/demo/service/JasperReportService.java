package co.edu.usbcali.demo.service;

import java.io.ByteArrayInputStream;

/**
 * 
 * Interfaz JasperReportService.
 * 
 * Este servicio sirve para realizar todos los metodos de jasper
 * 
 * @author Steven Calderon
 * @version 1.0
 */
public interface JasperReportService {

	public ByteArrayInputStream generarPdf() throws Exception;

	

}
