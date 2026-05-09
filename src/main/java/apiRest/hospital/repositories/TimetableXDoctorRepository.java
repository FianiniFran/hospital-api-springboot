package apiRest.hospital.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.entities.Doctor;
import apiRest.hospital.entities.TimetableXDoctor;
import apiRest.hospital.entities.keys.TimetableXDoctorPK;

@Repository
public interface TimetableXDoctorRepository extends JpaRepository<TimetableXDoctor, TimetableXDoctorPK> {
	public Page<TimetableXDoctor> findByDoctor(Doctor doctor, Pageable pageable);
}
