package co.edu.usbcali.demo.service;

import java.util.Optional;

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.domain.Rol;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
public interface AdminService extends GenericService<Admin, Integer> {
	public Optional<Rol> buscarAdminPorEmail(String email);

}
