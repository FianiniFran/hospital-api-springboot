package apiRest.hospital.serviceImpl;


import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.dto.TimetableDTO;
import apiRest.hospital.mapper.Mapper;
import apiRest.hospital.model.Timetable;
import apiRest.hospital.repository.TimetableRepository;
import apiRest.hospital.service.ITimetableService;

@Service
public class TimetableService implements ITimetableService{

	private final TimetableRepository timeRepo;
	

	public TimetableService(TimetableRepository timeRepo) {
		this.timeRepo = timeRepo;
	}
	
	@Override
	public Page<TimetableDTO> timetableList(Pageable pageable) {
		Page<TimetableDTO> page = timeRepo.findAll(pageable).map(Mapper::toDTO);
		return page;
	}

	@Override
	public TimetableDTO getTimetableById(int id) {
		return timeRepo.findById(id).map(Mapper::toDTO).orElse(null);
	}

	@Override
	public TimetableDTO getTimetableByDayAndHour(Integer day, LocalTime hourStart, LocalTime hourEnd) {
		return Mapper.toDTO(timeRepo.findByDayAndHourStartAndHourEnd(day, hourStart, hourEnd));
	}

	@Override
	public Timetable getTimetableEntity(int id) {
		return timeRepo.findById(id).orElse(null);
	}

	@Override
	public Timetable getTimetableEntity(Integer day, LocalTime hourStart, LocalTime hourEnd) {
		return timeRepo.findByDayAndHourStartAndHourEnd(day, hourStart, hourEnd);
	}
	
	

}
