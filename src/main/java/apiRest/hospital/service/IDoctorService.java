package apiRest.hospital.service;

import apiRest.hospital.dto.DoctorDTO;
import apiRest.hospital.model.Doctor;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IDoctorService {
	public Page<DoctorDTO> listDoctors(Pageable pageable);
	public DoctorDTO getDoctor(int id);
	public Doctor getDoctorEntity(int id);
	public DoctorDTO saveDoctor(DoctorDTO doctorDto);
	public void deleteDoctor(int id);
	public Boolean existsById(int id);
}
