package apiRest.hospital.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import apiRest.hospital.model.Doctor;
import apiRest.hospital.model.TimetableXDoctor;

@Repository
public interface TimetableXDoctorRepository extends JpaRepository<TimetableXDoctor, Integer> {
	public Page<TimetableXDoctor> findByDoctor(Doctor doctor, Pageable pageable);
}
