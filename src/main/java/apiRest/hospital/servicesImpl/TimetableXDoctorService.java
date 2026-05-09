package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.Doctor;
import apiRest.hospital.entities.TimetableXDoctor;
import apiRest.hospital.entities.keys.TimetablePK;
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
	public Page<TimetableXDoctor> getTimetableXDoctorByDoctor(int id, Pageable pageable) {
		Page<TimetableXDoctor> page = timeXDocRepo.findByDoctor(new Doctor(id), pageable);
		return page;
	}

	@Override
	public TimetableXDoctor saveTimetableXDoctor(TimetableXDoctor timetableXDoctor) {
		return timeXDocRepo.save(timetableXDoctor);
	}

	@Override
	public void deleteTimetableXDoctor(TimetableXDoctorPK timetableXDoctorPK) {
		timeXDocRepo.deleteById(timetableXDoctorPK);		
	}

	@Override
	public TimetableXDoctorPK createTXDPK(TimetableXDoctor txd) {
		TimetablePK tPK = new TimetablePK(txd.getTimetable().getDay(), txd.getTimetable().getHourStart(), txd.getTimetable().getHourEnd());
		TimetableXDoctorPK txdPK = new TimetableXDoctorPK(txd.getDoctor().getId(), tPK);
		return txdPK;
	}

	@Override
	public TimetableXDoctor getTimetableXDoctor(TimetableXDoctorPK txdPK) {
		TimetableXDoctor txd = timeXDocRepo.findById(txdPK).orElse(null);
		return txd;
	}

}
