package apiRest.hospital.serviceImpl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.dto.SpecialityDTO;
import apiRest.hospital.mapper.Mapper;
import apiRest.hospital.model.Speciality;
import apiRest.hospital.repository.SpecialityRepository;
import apiRest.hospital.service.ISpecialityService;

@Service
public class SpecialityService implements ISpecialityService{
	
	private final SpecialityRepository specRepo;
	

	public SpecialityService(SpecialityRepository specRepo) {
		this.specRepo = specRepo;
	}


	@Override
	public Page<SpecialityDTO> SpecialityList(Pageable pageable) {
		Page<SpecialityDTO> page = specRepo.findAll(pageable).map(Mapper::toDTO);
		return page;
	}


	@Override
	public SpecialityDTO getSpeciality(int id) {
		return specRepo.findById(id).map(Mapper::toDTO).orElse(null);
	}
	
	@Override
	public Speciality getSpecialityEntity(int id) {
		return specRepo.findById(id).orElse(null);
	}


	@Override
	public SpecialityDTO saveSpecility(SpecialityDTO specialityDto) {
		Speciality speciality = Mapper.toEntity(specialityDto);
		specRepo.save(speciality);
		return specialityDto;
	}


	@Override
	public void deleteSpeciality(int id) {
		specRepo.deleteById(id);
		
	}


	@Override
	public Boolean existsById(int id) {
		return specRepo.existsById(id);
	}

}
