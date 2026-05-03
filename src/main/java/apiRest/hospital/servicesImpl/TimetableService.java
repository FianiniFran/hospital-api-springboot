package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.Timetable;
import apiRest.hospital.repositories.TimetableRepository;
import apiRest.hospital.services.ITimetableService;

@Service
public class TimetableService implements ITimetableService{

	private final TimetableRepository timeRepo;
	
	@Autowired
	public TimetableService(TimetableRepository timeRepo) {
		this.timeRepo = timeRepo;
	}
	
	@Override
	public Page<Timetable> timetableList(Pageable pageable) {
		Page<Timetable> page = timeRepo.findAll(pageable);
		return page;
	}

}
