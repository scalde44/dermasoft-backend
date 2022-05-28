package co.edu.usbcali.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.usbcali.demo.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	@Query("SELECT r FROM Rating r WHERE r.appointment.doctor.doctorId=:doctorId ORDER BY r.validRegister")
	public List<Rating> buscarCalificacionPorDoctorId(Integer doctorId);
}
