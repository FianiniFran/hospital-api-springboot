package apiRest.hospital.serviceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.dto.TimetableXDoctorDTO;
import apiRest.hospital.mapper.Mapper;
import apiRest.hospital.model.Doctor;
import apiRest.hospital.model.Timetable;
import apiRest.hospital.repository.TimetableXDoctorRepository;
import apiRest.hospital.service.IDoctorService;
import apiRest.hospital.service.ITimetableService;
import apiRest.hospital.service.ITimetableXDoctorService;

@Service
public class TimetableXDoctorService implements ITimetableXDoctorService{

	private final TimetableXDoctorRepository timeXDocRepo;
	private final IDoctorService docService;
	private final ITimetableService timetableService;
	
	public TimetableXDoctorService(TimetableXDoctorRepository timeXDocRepo, IDoctorService docService, ITimetableService timetableService) {
		this.timeXDocRepo = timeXDocRepo;
		this.docService = docService;
		this.timetableService = timetableService;
	}


	@Override
	public Page<TimetableXDoctorDTO> timetableXDoctorList(Pageable pageable) {
		Page<TimetableXDoctorDTO> page = timeXDocRepo.findAll(pageable).map(Mapper::toDTO);
		return page;
	}


	@Override
	public Page<TimetableXDoctorDTO> getTimetableXDoctorByDoctor(int id, Pageable pageable) {
		Page<TimetableXDoctorDTO> page = timeXDocRepo.findByDoctor(docService.getDoctorEntity(id), pageable).map(Mapper::toDTO);
		return page;
	}


	@Override
	public TimetableXDoctorDTO getTimetableXDoctor(int id) {
		TimetableXDoctorDTO timeXDocDto = timeXDocRepo.findById(id).map(Mapper::toDTO).orElse(null); 
		return timeXDocDto;
	}


	@Override
	public TimetableXDoctorDTO saveTimetableXDoctor(TimetableXDoctorDTO timetableXDoctorDto) {
		Doctor doctor = docService.getDoctorEntity(timetableXDoctorDto.getIdDoctor());
		Timetable timetable = timetableService.getTimetableEntity(timetableXDoctorDto.getDay(),
							timetableXDoctorDto.getHourStart(), timetableXDoctorDto.getHourEnd());
		return Mapper.toDTO(timeXDocRepo.save(Mapper.toEntity(doctor, timetable)));
	}


	@Override
	public void deleteTimetableXDoctor(int id) {
		timeXDocRepo.deleteById(id);
	}


	@Override
	public Boolean existsById(int id) {
		return timeXDocRepo.existsById(id);
	}

}
