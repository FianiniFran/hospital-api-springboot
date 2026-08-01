package apiRest.hospital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Pageable;

import java.net.URI;

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
	
	@PostMapping
	public ResponseEntity<SpecialityDTO> post(@RequestBody SpecialityDTO specialityDto, UriComponentsBuilder ucb){
		SpecialityDTO specDto = specService.saveSpecility(specialityDto);
		
		URI location = ucb.path("api/v1/speciality/{id}").buildAndExpand(specDto.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
