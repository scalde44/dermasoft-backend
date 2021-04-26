package co.edu.usbcali.demo.service;

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.domain.Doctor;

import java.math.*;

import java.util.*;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface AdminService extends GenericService<Admin, Integer> {
	public Optional<Admin> buscarAdminPorEmail(String email);

}
