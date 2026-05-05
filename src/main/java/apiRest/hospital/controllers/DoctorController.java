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

import apiRest.hospital.entities.Doctor;
import apiRest.hospital.services.IDoctorService;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
	
	private final IDoctorService docService;
	
	@Autowired
	public DoctorController(IDoctorService docService) {
		this.docService = docService;
	}
	
	@GetMapping("/{requestedId}")
	private ResponseEntity<Doctor> get(@PathVariable int requestedId){
		Doctor doc = docService.getDoctor(requestedId);
		return ResponseEntity.ok(doc);
	}
	
	@GetMapping
	private ResponseEntity<Page<Doctor>> getAll(Pageable pageable){
		Page<Doctor> page = docService.listDoctors(pageable);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	private ResponseEntity<Doctor> post(@RequestBody Doctor doctor, UriComponentsBuilder ucb){
		Doctor doc = docService.saveDoctor(doctor);
		URI location = ucb.path("/api/v1/doctor/{id}").buildAndExpand(doc.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{requestedId}")
	private ResponseEntity<Void> put(@RequestBody Doctor doctor, @PathVariable int requestedId){
		Doctor doc = docService.getDoctor(requestedId);
		if(doc != null) {
		Doctor updatedDoc = new Doctor(doc.getId(), doctor.getName(), doctor.getSurname(),
								doctor.getIsActive(), doctor.getSpeciality());
		docService.saveDoctor(updatedDoc);
		return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{requestedId}")
	private ResponseEntity<Void> softDelete(@PathVariable int requestedId){
		Doctor doc = docService.getDoctor(requestedId);
		if(doc!=null) {
			doc.setIsActive(false);
			docService.saveDoctor(doc);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}	
