package apiRest.hospital.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import apiRest.hospital.entities.Speciality;
import apiRest.hospital.services.ISpecialityService;

@RestController
@RequestMapping("/api/v1/speciality")
public class SpecialityController {
	
	private final ISpecialityService specService;
	
	@Autowired
	public SpecialityController(ISpecialityService specService) {
		this.specService = specService;
	}
	
	@GetMapping
	private ResponseEntity<Page<Speciality>> get(Pageable pageable){
		return ResponseEntity.ok(specService.SpecialityList(pageable));
	}
	
}
