package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.TimetableXDoctor;
import apiRest.hospital.entities.keys.TimetableXDoctorPK;
import apiRest.hospital.repositories.TimetableXDoctorRepository;
import apiRest.hospital.services.ITimetableXDoctorService;

@Service
public class TimetableXDoctorService implements ITimetableXDoctorService{

	private final TimetableXDoctorRepository timeXDocRepo;
	
	@Autowired
	public TimetableXDoctorService(TimetableXDoctorRepository timeXDocRepo) {
		this.timeXDocRepo = timeXDocRepo;
	}
	
	@Override
	public Page<TimetableXDoctor> timetableXDoctorList(Pageable pageable) {
		Page<TimetableXDoctor> page = timeXDocRepo.findAll(pageable);
		return page;
	}

	@Override
	public TimetableXDoctor getTimetableXDoctor(TimetableXDoctorPK timetableXDoctorPK) {
		return timeXDocRepo.findById(timetableXDoctorPK).orElse(null);
	}

	@Override
	public TimetableXDoctor saveTimetableXDoctor(TimetableXDoctor timetableXDoctor) {
		return timeXDocRepo.save(timetableXDoctor);
	}

	@Override
	public void deleteTimetableXDoctor(TimetableXDoctorPK timetableXDoctorPK) {
		timeXDocRepo.deleteById(timetableXDoctorPK);		
	}

}
