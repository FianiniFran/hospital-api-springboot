package apiRest.hospital.service;

import org.springframework.data.domain.Pageable;

import apiRest.hospital.dto.PatientDTO;

import org.springframework.data.domain.Page;


public interface IPatientService {
	public Page<PatientDTO> listPatients(Pageable pageable);
	public PatientDTO getPatient(int id);
	public PatientDTO savePatient(PatientDTO patientDto);
	public void deletePatient(int id);
	public Boolean existsById(int id);
}
