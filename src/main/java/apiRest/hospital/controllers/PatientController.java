package apiRest.hospital.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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

import apiRest.hospital.entities.Patient;
import apiRest.hospital.services.IPatientService;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	private final IPatientService patService;
	
	@Autowired
	public PatientController(IPatientService patService) {
		this.patService = patService;
	}
	
	@GetMapping
	private ResponseEntity<Page<Patient>> getAll(Pageable pageable){
		Page<Patient> page = patService.listPatients(pageable);
		return ResponseEntity.ok(page);
	}
	
	@GetMapping("/{requestedId}")
	private ResponseEntity<Patient> get(@PathVariable int requestedId){
		Patient pat = patService.getPatient(requestedId);
		return ResponseEntity.ok(pat);
	}
	
	@PostMapping
	private ResponseEntity<Patient> save(@RequestBody Patient patient, UriComponentsBuilder ucb){
		Patient pat = patService.savePatient(patient);
		URI location = ucb.path("/api/v1/patient/{id}").buildAndExpand(pat.getId()).toUri();	
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{requestedId}")
	private ResponseEntity<Void> put(@PathVariable int requestedId, @RequestBody Patient newPatient){
		Patient pat = patService.getPatient(requestedId);
		if(pat!=null) {
		Patient modifyPatient = new Patient(pat.getId(), newPatient.getName(), newPatient.getSurname(),
					newPatient.getBirthDate(), newPatient.getIsActive());
		patService.savePatient(modifyPatient);
		return ResponseEntity.noContent().build();
		} 
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{requestedId}")
	private ResponseEntity<Void> softDelete(@PathVariable int requestedId){
		Patient pat = patService.getPatient(requestedId);
		if(pat!=null) {
			pat.setIsActive(false);
			patService.savePatient(pat);
			return ResponseEntity.noContent().build();
		} 
		return ResponseEntity.notFound().build();
	}
	
}
