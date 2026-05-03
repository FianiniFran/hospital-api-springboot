package apiRest.hospital.services;

import apiRest.hospital.entities.Timetable;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ITimetableService {
	public Page<Timetable> timetableList(Pageable pageable);
}
