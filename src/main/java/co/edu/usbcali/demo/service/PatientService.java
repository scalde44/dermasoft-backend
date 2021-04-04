package co.edu.usbcali.demo.service;

import co.edu.usbcali.demo.domain.Patient;

import java.math.*;

import java.util.*;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface PatientService extends GenericService<Patient, Integer> {
	public Optional<Patient> buscarPacientePorEmail(String email);

}
