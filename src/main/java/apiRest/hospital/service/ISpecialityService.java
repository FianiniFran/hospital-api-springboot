package apiRest.hospital.service;

import apiRest.hospital.dto.SpecialityDTO;
import apiRest.hospital.model.Speciality;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


public interface ISpecialityService {
	Page<SpecialityDTO> SpecialityList(Pageable pageable);
	public SpecialityDTO getSpeciality(int id);
	public Speciality getSpecialityEntity(int id);	
	public SpecialityDTO saveSpecility(SpecialityDTO specialityDto);
	public void deleteSpeciality(int id);
	public Boolean existsById(int id);
}
