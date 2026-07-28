package apiRest.hospital.service;

import apiRest.hospital.dto.TimetableXDoctorDTO;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ITimetableXDoctorService {
	public Page<TimetableXDoctorDTO> timetableXDoctorList(Pageable pageable);
	public Page<TimetableXDoctorDTO> getTimetableXDoctorByDoctor(int id, Pageable pageable);
	public TimetableXDoctorDTO getTimetableXDoctor(int id);
	public TimetableXDoctorDTO saveTimetableXDoctor(TimetableXDoctorDTO timetableXDoctorDto);
	public void deleteTimetableXDoctor(int id);
	public Boolean existsById(int id);
}
