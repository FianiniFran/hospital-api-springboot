package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.Speciality;
import apiRest.hospital.repositories.SpecialityRepository;
import apiRest.hospital.services.ISpecialityService;

@Service
public class SpecialityService implements ISpecialityService{
	
	private final SpecialityRepository specRepo;
	
	@Autowired
	public SpecialityService(SpecialityRepository specRepo) {
		this.specRepo = specRepo;
	}

	@Override
	public Page<Speciality> SpecialityList(Pageable pageable) {
		Page<Speciality> page = specRepo.findAll(pageable);
		return page;
	}

	@Override
	public Speciality getSpeciality(int id) {
		return specRepo.findById(id).orElse(null);
	}

	@Override
	public Speciality saveSpecility(Speciality speciality) {
		return specRepo.save(speciality);
	}

	@Override
	public void deleteSpeciality(int id) {
		specRepo.deleteById(id);
	}

}
