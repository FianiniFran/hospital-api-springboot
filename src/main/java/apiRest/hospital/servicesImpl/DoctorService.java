package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.Doctor;
import apiRest.hospital.repositories.DoctorRepository;
import apiRest.hospital.services.IDoctorService;

@Service
public class DoctorService implements IDoctorService{

	private final DoctorRepository docRepo;
	
	@Autowired
	public DoctorService(DoctorRepository docRepo) {
		this.docRepo = docRepo;
	}
	
	@Override
	public Page<Doctor> DoctorList(Pageable pageable) {
		Page<Doctor> page = docRepo.findAll(pageable);
		return page;
	}

	@Override
	public Doctor getDoctor(int id) {
		return docRepo.findById(id).orElse(null);
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return docRepo.save(doctor);
	}

	@Override
	public void deleteDoctor(int id) {
		docRepo.deleteById(id);	
	}

}
