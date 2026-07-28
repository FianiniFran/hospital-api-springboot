package apiRest.hospital.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import apiRest.hospital.dto.TimetableXDoctorDTO;
import apiRest.hospital.serviceImpl.TimetableXDoctorService;

@RestController
@RequestMapping("/api/v1/timetablexdoctor")
public class TXDController {
	private final TimetableXDoctorService txdService;
	
	public TXDController(TimetableXDoctorService txdService) {
		this.txdService = txdService;
	}
	
	@GetMapping("/{requestedIdDoctor}")
	public ResponseEntity<Page<TimetableXDoctorDTO>> getByIdDoctor(@PathVariable int requestedIdDoctor, Pageable pageable){
		return ResponseEntity.ok(txdService.getTimetableXDoctorByDoctor(requestedIdDoctor, pageable));
	}
	
	@GetMapping
	public ResponseEntity<Page<TimetableXDoctorDTO>> getAll(Pageable pageable){
		return ResponseEntity.ok(txdService.timetableXDoctorList(pageable));
	}
	
	@PostMapping
	public ResponseEntity<TimetableXDoctorDTO> post(@RequestBody TimetableXDoctorDTO timetableXDoctor, UriComponentsBuilder ucb){
		txdService.saveTimetableXDoctor(timetableXDoctor);
		URI localization = ucb.path("/api/v1/timetablexdoctor")
				.queryParam("idDoctor", timetableXDoctor.getIdDoctor())
				.queryParam("day", timetableXDoctor.getDay())
				.queryParam("hour_start", timetableXDoctor.getHourStart())
				.queryParam("hour_end", timetableXDoctor.getHourEnd())
				.build().toUri();
		return ResponseEntity.created(localization).build();
	}
	
	
	@DeleteMapping("/{requestedId}")
	public ResponseEntity<Void> delete(@PathVariable int requestedId){
		if(txdService.existsById(requestedId)) {
			txdService.deleteTimetableXDoctor(requestedId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
