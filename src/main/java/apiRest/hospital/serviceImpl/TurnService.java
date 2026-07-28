package apiRest.hospital.serviceImpl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.dto.TurnDTO;
import apiRest.hospital.mapper.Mapper;
import apiRest.hospital.model.Doctor;
import apiRest.hospital.model.Patient;
import apiRest.hospital.model.Turn;
import apiRest.hospital.repository.TurnRepository;
import apiRest.hospital.service.IDoctorService;
import apiRest.hospital.service.IPatientService;
import apiRest.hospital.service.ITurnService;

@Service
public class TurnService implements ITurnService{

	private final TurnRepository turnRepo;
	private final IDoctorService docService;
	private final IPatientService patService;
	
	
	public TurnService(TurnRepository turnRepo, IDoctorService docService, IPatientService patService) {
		this.turnRepo = turnRepo;
		this.docService = docService;
		this.patService = patService;
	}


	@Override
	public Page<TurnDTO> turnList(Pageable pageable) {
		Page<TurnDTO> page = turnRepo.findAll(pageable).map(Mapper::toDTO);
		return page;
	}


	@Override
	public TurnDTO getTurn(int id) {
		TurnDTO turnDto = turnRepo.findById(id).map(Mapper::toDTO).orElse(null); 
		return turnDto;
	}


	@Override
	public TurnDTO saveTurn(TurnDTO turnDto) {
		Doctor doctor = docService.getDoctorEntity(turnDto.getIdDoctor());
		Patient patient = Mapper.toEntity(patService.getPatient(turnDto.getId()));
		Turn newTurn = turnRepo.save(Mapper.toEntity(turnDto, doctor, patient));
		return Mapper.toDTO(newTurn);
	}


	@Override
	public void deleteTurn(int id) {
		Turn deletedTurn = turnRepo.findById(id).orElse(null);
		deletedTurn.setIsActive(false);
		turnRepo.save(deletedTurn);
	}


	@Override
	public Boolean existsById(int id) {
		return turnRepo.existsById(id);
	}

}
