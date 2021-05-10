package co.edu.usbcali.demo.domain;

/**
 * Clase SendMail.
 * 
 * Contiene la informacion necesaria para enviar emails.
 * 
 * @author Steven Calderon
 * @version 1.0
 */
public class SendMail {
	// Atributos
	private String subject;
	private String to;
	private String from;
	private String text;

	// Constructores
	public SendMail() {
		super();
	}

	public SendMail(String subject, String to, String from, String text) {
		super();
		this.subject = subject;
		this.to = to;
		this.from = from;
		this.text = text;
	}

	// Getters and Setters
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
