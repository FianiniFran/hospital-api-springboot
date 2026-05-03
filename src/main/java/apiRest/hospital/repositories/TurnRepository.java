package apiRest.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.entities.Turn;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Integer> {

}
