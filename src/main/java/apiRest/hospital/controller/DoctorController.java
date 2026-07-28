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

import apiRest.hospital.dto.DoctorDTO;
import apiRest.hospital.service.IDoctorService;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
	
	private final IDoctorService docService;
	
	
	public DoctorController(IDoctorService docService) {
		this.docService = docService;
	}
	
	@GetMapping("/{requestedId}")
	public ResponseEntity<DoctorDTO> get(@PathVariable int requestedId){
		DoctorDTO doc = docService.getDoctor(requestedId);
		return ResponseEntity.ok(doc);
	}
	
	@GetMapping
	public ResponseEntity<Page<DoctorDTO>> getAll(Pageable pageable){
		Page<DoctorDTO> page = docService.listDoctors(pageable);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	public ResponseEntity<DoctorDTO> post(@RequestBody DoctorDTO doctor, UriComponentsBuilder ucb){
		DoctorDTO doc = docService.saveDoctor(doctor);
		
		URI location = ucb.path("/api/v1/doctor/{id}").buildAndExpand(doc.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{requestedId}")
	public ResponseEntity<Void> put(@RequestBody DoctorDTO doctor, @PathVariable int requestedId){
		if(docService.existsById(requestedId)) {
		doctor.setId(requestedId);
		docService.saveDoctor(doctor); 
		return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{requestedId}")
	public ResponseEntity<Void> softDelete(@PathVariable int requestedId){
		if(docService.existsById(requestedId)) {
			docService.deleteDoctor(requestedId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}	
