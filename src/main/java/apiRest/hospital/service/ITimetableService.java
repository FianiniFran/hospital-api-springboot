package apiRest.hospital.service;

import apiRest.hospital.dto.TimetableDTO;
import apiRest.hospital.model.Timetable;

import org.springframework.data.domain.Pageable;

import java.time.LocalTime;

import org.springframework.data.domain.Page;

public interface ITimetableService {
	public Page<TimetableDTO> timetableList(Pageable pageable);
	public TimetableDTO getTimetableById(int id);
	public Timetable getTimetableEntity(int id);
	public Timetable getTimetableEntity(Integer day, LocalTime hourStart, LocalTime hourEnd);
	public TimetableDTO getTimetableByDayAndHour(Integer day, LocalTime hourStart, LocalTime hourEnd);
}
