package apiRest.hospital.controller;

import java.net.URI;

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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import apiRest.hospital.dto.PatientDTO;
import apiRest.hospital.service.IPatientService;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	private final IPatientService patService;
	
	
	public PatientController(IPatientService patService) {
		this.patService = patService;
	}
	
	@GetMapping
	public ResponseEntity<Page<PatientDTO>> getAll(Pageable pageable){
		Page<PatientDTO> page = patService.listPatients(pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{requestedId}")
	public ResponseEntity<PatientDTO> get(@PathVariable int requestedId){
		PatientDTO pat = patService.getPatient(requestedId);
		return ResponseEntity.ok(pat);
	}
	
	@PostMapping
	public ResponseEntity<PatientDTO> post(@RequestBody PatientDTO patient, UriComponentsBuilder ucb){
			PatientDTO pat = patService.savePatient(patient);
			URI location = ucb.path("/api/v1/patient/{id}").buildAndExpand(pat.getId()).toUri();	
			return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{requestedId}")
	public ResponseEntity<Void> put(@PathVariable int requestedId, @RequestBody PatientDTO newPatient){
		if(patService.existsById(requestedId)) {
		newPatient.setId(requestedId);
		patService.savePatient(newPatient);
		return ResponseEntity.noContent().build();
		} 
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{requestedId}")
	public ResponseEntity<Void> softDelete(@PathVariable int requestedId){
		if(patService.existsById(requestedId)) {
			patService.deletePatient(requestedId);
			return ResponseEntity.noContent().build();
		} 
		return ResponseEntity.notFound().build();
	}
	
}
