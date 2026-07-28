package apiRest.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.model.Turn;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {

}
