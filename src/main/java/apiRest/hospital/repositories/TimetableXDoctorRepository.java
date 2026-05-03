package apiRest.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.entities.TimetableXDoctor;
import apiRest.hospital.entities.keys.TimetableXDoctorPK;

@Repository
public interface TimetableXDoctorRepository extends JpaRepository<TimetableXDoctor, TimetableXDoctorPK> {

}
