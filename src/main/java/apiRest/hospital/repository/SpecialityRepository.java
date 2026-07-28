package apiRest.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.model.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer>{

}
