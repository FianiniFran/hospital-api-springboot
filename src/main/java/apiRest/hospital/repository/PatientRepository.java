package apiRest.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
