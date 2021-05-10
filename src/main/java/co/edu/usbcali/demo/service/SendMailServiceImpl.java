package co.edu.usbcali.demo.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import co.edu.usbcali.demo.domain.SendMail;

/**
 * 
 * Clase SendMailServiceImpl.
 * 
 * Implementacion de los metodos de la interfaz {@link SendMailService}
 * 
 * @author Steven Calderon
 * @version 1.0
 */
@Scope("singleton")
@Service
public class SendMailServiceImpl implements SendMailService {
	@Value("${spring.mail.username}")
	private String remitente;
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void enviarEmail(SendMail request) throws Exception {
		try {
			MimeMessage msg = javaMailSender.createMimeMessage();
			// Habilitar uso html
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setTo(request.getTo());
			helper.setFrom(remitente);
			helper.setText(request.getText());
			helper.setSubject(request.getSubject());
			javaMailSender.send(msg);
		} catch (Exception e) {
			throw new Exception("No se pudo enviar el correo");
		}
	}

}
