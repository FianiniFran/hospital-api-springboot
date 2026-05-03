package apiRest.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.entities.Timetable;
import apiRest.hospital.entities.keys.TimetablePK;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, TimetablePK>{

}
