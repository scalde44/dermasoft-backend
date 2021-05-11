package co.edu.usbcali.demo.service;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 * 
 * Clase JasperReportServiceImpl.
 * 
 * Implementacion de los metodos de la interfaz {@link JasperReportService}
 * 
 * @author Steven Calderon
 * @version 1.0
 */
@Scope("singleton")
@Service
public class JasperReportServiceImpl implements JasperReportService {

	@Autowired
	private DataSource dataSource;

	// PDF Persona natural
	@Override
	public ByteArrayInputStream generarReporteCita(Long idCita) throws Exception {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			// Cargar archivo y compilar
			ClassPathResource resource = new ClassPathResource("/reporteCita.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("idCita", idCita);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
			return new ByteArrayInputStream(pdf);
		} catch (Exception e) {
			throw new Exception("Error generando pdf" + e);
		} finally {
			if (conn != null) {
				conn.close();
			}
		}

	}
}
