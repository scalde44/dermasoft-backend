package co.edu.usbcali.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.demo.domain.Admin;
import co.edu.usbcali.demo.exception.ZMessManager;
import co.edu.usbcali.demo.repository.AdminRepository;

/**
 * @author Zathura Code Generator Version 9.0 http://zathuracode.org
 *         www.zathuracode.org
 *
 */
@Scope("singleton")
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private Validator validator;

	@Override
	public void validate(Admin admin) throws ConstraintViolationException {
		Set<ConstraintViolation<Admin>> constraintViolations = validator.validate(admin);

		if (!constraintViolations.isEmpty()) {
			throw new ConstraintViolationException(constraintViolations);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return adminRepository.count();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Admin> findAll() {

		return adminRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Admin save(Admin entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Admin");
		}

		validate(entity);

		return adminRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(Admin entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Admin");
		}

		if (entity.getAdminId() == null) {
			throw new ZMessManager().new EmptyFieldException("adminId");
		}

		if (adminRepository.existsById(entity.getAdminId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		adminRepository.deleteById(entity.getAdminId());
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {

		if (id == null) {
			throw new ZMessManager().new EmptyFieldException("adminId");
		}

		if (adminRepository.existsById(id)) {
			delete(adminRepository.findById(id).get());
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Admin update(Admin entity) throws Exception {

		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Admin");
		}

		validate(entity);

		if (adminRepository.existsById(entity.getAdminId()) == false) {
			throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
		}

		return adminRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Admin> findById(Integer adminId) {

		return adminRepository.findById(adminId);
	}

	@Override
	public Optional<Admin> buscarAdminPorEmail(String email) {
		// TODO Auto-generated method stub
		return adminRepository.buscarAdminPorEmail(email);
	}
}
