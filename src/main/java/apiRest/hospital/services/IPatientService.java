package apiRest.hospital.services;

import org.springframework.data.domain.Pageable;

import apiRest.hospital.entities.Patient;

import org.springframework.data.domain.Page;


public interface IPatientService {
	public Page<Patient> listPatients(Pageable pageable);
	public Patient getPatient(int id);
	public Patient savePatient(Patient patient);
	public void deletePatient(int id);
}
