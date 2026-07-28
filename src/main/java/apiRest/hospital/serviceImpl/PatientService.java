package apiRest.hospital.serviceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.dto.PatientDTO;
import apiRest.hospital.mapper.Mapper;
import apiRest.hospital.model.Patient;
import apiRest.hospital.repository.PatientRepository;
import apiRest.hospital.service.IPatientService;

@Service
public class PatientService implements IPatientService {
		
	private final PatientRepository patRepo;
	

	public PatientService(PatientRepository patRepo) {
		this.patRepo = patRepo;
	}


	@Override
	public Page<PatientDTO> listPatients(Pageable pageable) {
		Page<PatientDTO> page = patRepo.findAll(pageable).map(Mapper::toDTO);
		return page;
	}


	@Override
	public PatientDTO getPatient(int id) {
		return patRepo.findById(id).map(Mapper::toDTO).orElse(null);
	}


	@Override
	public PatientDTO savePatient(PatientDTO patientDto) {
		Patient patient = Mapper.toEntity(patientDto);
		return Mapper.toDTO(patRepo.save(patient));
	}


	@Override
	public void deletePatient(int id) {
		Patient patient = patRepo.findById(id).orElse(null);
		patient.setIsActive(false);
		patRepo.save(patient);
	}


	@Override
	public Boolean existsById(int id) {
		return patRepo.existsById(id);
	}

}
