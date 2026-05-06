package apiRest.hospital.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apiRest.hospital.entities.Timetable;
import apiRest.hospital.services.ITimetableService;

@RestController
@RequestMapping("/api/v1/timetable")
public class TimetableController {
	
	private final ITimetableService timeService;
	
	public TimetableController(ITimetableService timeService) {
		this.timeService = timeService;
	}
	
	@GetMapping
	private ResponseEntity<Page<Timetable>> get(Pageable pageable){
		return ResponseEntity.ok(timeService.timetableList(pageable));
	}
}
