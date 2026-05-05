package apiRest.hospital.services;

import apiRest.hospital.entities.Doctor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IDoctorService {
	public Page<Doctor> listDoctors(Pageable pageable);
	public Doctor getDoctor(int id);
	public Doctor saveDoctor(Doctor doctor);
	public void deleteDoctor(int id);
}
