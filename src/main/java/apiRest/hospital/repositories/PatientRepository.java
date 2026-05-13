package apiRest.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import apiRest.hospital.entities.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
