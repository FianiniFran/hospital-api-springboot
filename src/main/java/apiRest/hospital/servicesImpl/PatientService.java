package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.Patient;
import apiRest.hospital.services.IPatientService;
import apiRest.hospital.repositories.PatientRepository;
import org.springframework.data.domain.PageRequest;

@Service
public class PatientService implements IPatientService {
		
	private final PatientRepository patRepo;
	
	@Autowired
	public PatientService(PatientRepository patRepo) {
		this.patRepo = patRepo;
	}

	@Override
	public Page<Patient> listPatients(Pageable pageable) {
		Page<Patient> page = patRepo.findAll(pageable);
		return page;
	}

	@Override
	public Patient getPatient(int id) {
		return patRepo.findById(id).orElse(null);
	}

	@Override
	public Patient savePatient(Patient patient) {
		return patRepo.save(patient);
	}

	@Override
	public void deletePatient(int id) {
		patRepo.deleteById(id);
	}

}
