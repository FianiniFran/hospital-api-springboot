package apiRest.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
//	@GetMapping
//	private ResponseEntity<Page<Patient>> getAll(Pageable pageable){
//		Page<Patient> page = patService.patientList(pageable);
//		return ResponseEntity.ok(page);
//	}
	
	@GetMapping("/{requestedId}")
	public ResponseEntity<Patient> get(@PathVariable int requestedId){
		Patient pat = patService.getPatient(requestedId);
		return ResponseEntity.ok(pat);
	}
	
}
