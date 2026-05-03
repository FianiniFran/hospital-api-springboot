package apiRest.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.entities.Speciality;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer>{

}
