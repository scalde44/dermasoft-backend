package co.edu.usbcali.demo.service;

import co.edu.usbcali.demo.domain.SendMail;

/**
 * 
 * Interfaz SendMailService.
 * 
 * Este servicio sirve para realizar todos los metodos de envio de emails
 * 
 * @author Steven Calderon
 * @version 1.0
 */
public interface SendMailService {

	/**
	 * 
	 * Este metodo sirve para enviar emails
	 * 
	 * @author Steven Calderon
	 * @version 1.0
	 * @param request Recibe como parametro un objeto de tipo {@link SendMail}
	 * @throws Exception
	 */
	public void enviarEmail(SendMail request) throws Exception;
}
