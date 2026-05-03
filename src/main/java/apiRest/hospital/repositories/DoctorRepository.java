package apiRest.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
