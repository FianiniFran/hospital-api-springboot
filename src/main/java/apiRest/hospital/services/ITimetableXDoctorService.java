package apiRest.hospital.services;

import apiRest.hospital.entities.TimetableXDoctor;
import apiRest.hospital.entities.keys.TimetableXDoctorPK;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ITimetableXDoctorService {
	public Page<TimetableXDoctor> timetableXDoctorList(Pageable pageable);
	public TimetableXDoctor getTimetableXDoctor(TimetableXDoctorPK timetableXDoctorPK);
	public TimetableXDoctor saveTimetableXDoctor(TimetableXDoctor timetableXDoctor);
	public void deleteTimetableXDoctor(TimetableXDoctorPK timetableXDoctorPK);
}
