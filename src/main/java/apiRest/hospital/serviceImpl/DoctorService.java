package apiRest.hospital.serviceImpl;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.dto.DoctorDTO;
import apiRest.hospital.mapper.Mapper;
import apiRest.hospital.model.Doctor;
import apiRest.hospital.model.Speciality;
import apiRest.hospital.repository.DoctorRepository;
import apiRest.hospital.service.IDoctorService;
import apiRest.hospital.service.ISpecialityService;

@Service
public class DoctorService implements IDoctorService{

	private final DoctorRepository docRepo;
	private final ISpecialityService specService;
	

	public DoctorService(DoctorRepository docRepo, ISpecialityService specService) {
		this.docRepo = docRepo;
		this.specService = specService;
	}

	@Override
	public Page<DoctorDTO> listDoctors(Pageable pageable) {
		Page<DoctorDTO> page = docRepo.findAll(pageable).map(Mapper::toDTO);
		return page;
	}

	@Override
	public DoctorDTO getDoctor(int id) {
		return docRepo.findById(id).map(Mapper::toDTO).orElse(null);
	}
	
	@Override
	public Doctor getDoctorEntity(int id) {
		return docRepo.findById(id).orElse(null);
	}

	@Override
	public DoctorDTO saveDoctor(DoctorDTO doctorDto) {
		Speciality speciality = specService.getSpecialityEntity(doctorDto.getIdSpeciality());
		Doctor newDoctor = docRepo.save(Mapper.toEntity(doctorDto, speciality));
		return Mapper.toDTO(newDoctor);
	}

	@Override
	public void deleteDoctor(int id) {
		Doctor deletedDoctor = docRepo.findById(id).orElse(null);
		deletedDoctor.setIsActive(false);
		docRepo.save(deletedDoctor);
	}

	@Override
	public Boolean existsById(int id) {
		return docRepo.existsById(id);
	}
	
}
