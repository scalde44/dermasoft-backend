package co.edu.usbcali.demo.service;

import co.edu.usbcali.demo.domain.Doctor;
import co.edu.usbcali.demo.domain.Patient;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface DoctorService extends GenericService<Doctor, Integer> {
	public Optional<Doctor> buscarDoctorPorEmail(String email);

}
