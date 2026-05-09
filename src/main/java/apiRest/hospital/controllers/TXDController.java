package apiRest.hospital.controllers;

import java.net.URI;
import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import apiRest.hospital.entities.Doctor;
import apiRest.hospital.entities.Timetable;
import apiRest.hospital.entities.TimetableXDoctor;
import apiRest.hospital.servicesImpl.TimetableXDoctorService;

@RestController
@RequestMapping("/api/v1/timetablexdoctor")
public class TXDController {
	private final TimetableXDoctorService txdService;
	
	public TXDController(TimetableXDoctorService txdService) {
		this.txdService = txdService;
	}
	
	@GetMapping("/{requestedIdDoctor}")
	private ResponseEntity<Page<TimetableXDoctor>> getByIdDoctor(@PathVariable int requestedIdDoctor, Pageable pageable){
		return ResponseEntity.ok(txdService.getTimetableXDoctorByDoctor(requestedIdDoctor, pageable));
	}
	
	@GetMapping
	private ResponseEntity<Page<TimetableXDoctor>> getAll(Pageable pageable){
		return ResponseEntity.ok(txdService.timetableXDoctorList(pageable));
	}
	
	@PostMapping
	private ResponseEntity<TimetableXDoctor> post(@RequestBody TimetableXDoctor timetableXDoctor, UriComponentsBuilder ucb){
		TimetableXDoctor txd = txdService.getTimetableXDoctor(txdService.createTXDPK(timetableXDoctor));
		if(txd != null) {
			return ResponseEntity.notFound().build();
		}
		
		txdService.saveTimetableXDoctor(timetableXDoctor);
		URI localization = ucb.path("/api/v1/timetablexdoctor")
				.queryParam("idDoctor", timetableXDoctor.getDoctor().getId())
				.queryParam("day", timetableXDoctor.getTimetable().getDay())
				.queryParam("hour_start", timetableXDoctor.getTimetable().getHourStart())
				.queryParam("hour_end", timetableXDoctor.getTimetable().getHourEnd())
				.build().toUri();
		return ResponseEntity.created(localization).build();
	}
	
	
	@DeleteMapping(params={"idDoctor", "day", "hour_start", "hour_end"})
	private ResponseEntity<Void> delete(@RequestParam int idDoctor,
										@RequestParam int day,
										@RequestParam LocalTime hour_start,
										@RequestParam LocalTime hour_end){
		TimetableXDoctor exist = new TimetableXDoctor(new Doctor(idDoctor), new Timetable(day, hour_start, hour_end));
		TimetableXDoctor timetableXDoctorToDelete = txdService.getTimetableXDoctor(txdService.createTXDPK(exist));
		if(timetableXDoctorToDelete != null) {
			txdService.deleteTimetableXDoctor(txdService.createTXDPK(exist));
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
