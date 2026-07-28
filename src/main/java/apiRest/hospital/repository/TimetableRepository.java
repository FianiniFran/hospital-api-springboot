package apiRest.hospital.repository;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apiRest.hospital.model.Timetable;

@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Integer>{
	public Timetable findByDayAndHourStartAndHourEnd(Integer day, LocalTime hourStart, LocalTime hourEnd);
}
