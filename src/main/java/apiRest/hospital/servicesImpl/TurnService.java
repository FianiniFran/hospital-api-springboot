package apiRest.hospital.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import apiRest.hospital.entities.Turn;
import apiRest.hospital.repositories.TurnRepository;
import apiRest.hospital.services.ITurnService;

@Service
public class TurnService implements ITurnService{

	private final TurnRepository turnRepo;
	
	@Autowired
	public TurnService(TurnRepository turnRepo) {
		this.turnRepo = turnRepo;
	}
	
	@Override
	public Page<Turn> turnList(Pageable pageable) {
		Page<Turn> page = turnRepo.findAll(pageable);
		return page;
	}

	@Override
	public Turn getTurn(int id) {
		return turnRepo.findById(id).orElse(null);
	}

	@Override
	public Turn saveTurn(Turn turn) {
		return turnRepo.save(turn);
	}

	@Override
	public void deleteTurn(int id) {
		turnRepo.deleteById(id);		
	}

}
