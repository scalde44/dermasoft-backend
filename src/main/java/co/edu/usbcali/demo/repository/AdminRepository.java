package co.edu.usbcali.demo.repository;

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.domain.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
*/
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("SELECT a FROM ADMIN a WHERE a.rol.email=:email")
	public Optional<Admin> buscarAdminPorEmail(String email);
}
