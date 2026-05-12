package apiRest.hospital.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import apiRest.hospital.entities.Turn;
import apiRest.hospital.servicesImpl.TurnService;

@RestController
@RequestMapping("/api/v1/turn")
public class TurnController {
	
	private final TurnService turnService;
	
	public TurnController(TurnService turnService) {
		this.turnService = turnService;
	}
	
	@GetMapping("/{requestedId}")
	private ResponseEntity<Turn> getById(@PathVariable int requestedId){
		return ResponseEntity.ok(turnService.getTurn(requestedId));
	}
	
	@GetMapping
	private ResponseEntity<Page<Turn>> getAll(Pageable pageable){
		return ResponseEntity.ok(turnService.turnList(pageable));
	}
	
	@PostMapping
	private ResponseEntity<Turn> post(@RequestBody Turn turn, UriComponentsBuilder ucb){
		Turn newTurn = turnService.saveTurn(turn);
		URI location = ucb.path("/api/v1/turn/{id}").buildAndExpand(newTurn.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{requestedId}")
	private ResponseEntity<Void> put(@PathVariable int requestedId, @RequestBody Turn turn){
		Turn existingTurn = turnService.getTurn(requestedId);
		if(existingTurn != null) {
			Turn updatedTurn = new Turn(requestedId, turn.getDay(), turn.getHourStart(), 
							   turn.getHourEnd(), turn.getDescription(), turn.getPatient(), 
							   turn.getDoctor(), turn.getIsActive());
			turnService.saveTurn(updatedTurn);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{requestedId}")
	private ResponseEntity<Void> softDelete(@PathVariable int requestedId){
		Turn existingTurn = turnService.getTurn(requestedId);
		if(existingTurn != null && existingTurn.getIsActive()) {
			existingTurn.setIsActive(false);
			turnService.saveTurn(existingTurn);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
