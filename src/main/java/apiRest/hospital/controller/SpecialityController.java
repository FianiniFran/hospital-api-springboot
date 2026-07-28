package apiRest.hospital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import apiRest.hospital.dto.SpecialityDTO;
import apiRest.hospital.service.ISpecialityService;

@RestController
@RequestMapping("/api/v1/speciality")
public class SpecialityController {
	
	private final ISpecialityService specService;
	
	
	public SpecialityController(ISpecialityService specService) {
		this.specService = specService;
	}
	
	@GetMapping
	public ResponseEntity<Page<SpecialityDTO>> get(Pageable pageable){
		return ResponseEntity.ok(specService.SpecialityList(pageable));
	}
	
}
