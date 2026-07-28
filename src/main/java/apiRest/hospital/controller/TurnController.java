package apiRest.hospital.controller;

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

import apiRest.hospital.dto.TurnDTO;
import apiRest.hospital.serviceImpl.TurnService;

@RestController
@RequestMapping("/api/v1/turn")
public class TurnController {
	
	private final TurnService turnService;
	
	public TurnController(TurnService turnService) {
		this.turnService = turnService;
	}
	
	@GetMapping("/{requestedId}")
	public ResponseEntity<TurnDTO> getById(@PathVariable int requestedId){
		return ResponseEntity.ok(turnService.getTurn(requestedId));
	}
	
	@GetMapping
	public ResponseEntity<Page<TurnDTO>> getAll(Pageable pageable){
		return ResponseEntity.ok(turnService.turnList(pageable));
	}
	
	@PostMapping
	public ResponseEntity<TurnDTO> post(@RequestBody TurnDTO turn, UriComponentsBuilder ucb){
		TurnDTO newTurn = turnService.saveTurn(turn);
		URI location = ucb.path("/api/v1/turn/{id}").buildAndExpand(newTurn.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{requestedId}")
	public ResponseEntity<Void> put(@PathVariable int requestedId, @RequestBody TurnDTO turn){
		if(turnService.existsById(requestedId)) {
			turn.setId(requestedId);
			turnService.saveTurn(turn);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{requestedId}")
	public ResponseEntity<Void> softDelete(@PathVariable int requestedId){
		if(turnService.existsById(requestedId)) {
			turnService.deleteTurn(requestedId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
