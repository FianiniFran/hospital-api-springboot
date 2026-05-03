package apiRest.hospital.services;

import apiRest.hospital.entities.Speciality;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface ISpecialityService {
	Page<Speciality> SpecialityList(Pageable pageable);
	public Speciality getSpeciality(int id);
	public Speciality saveSpecility(Speciality speciality);
	public void deleteSpeciality(int id);	
}
