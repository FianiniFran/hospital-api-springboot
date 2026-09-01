package apiRest.hospital.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import apiRest.hospital.dto.DoctorDTO;
import apiRest.hospital.model.Doctor;
import apiRest.hospital.model.Speciality;
import apiRest.hospital.repository.DoctorRepository;
import apiRest.hospital.serviceImpl.DoctorService;
import apiRest.hospital.serviceImpl.SpecialityService;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {
	
	@Mock
	private DoctorRepository docRepo;
	@Mock
	private SpecialityService specService; 
	
	
	@InjectMocks
	private DoctorService docService;
	
	
	
	@Test
	public void shouldCreateADoctor() {
		Speciality speciality = new Speciality(1, "Pediatria", new ArrayList<>());
		DoctorDTO docDto = new DoctorDTO(1, "Pedro", "Juarez", 1);
		Doctor doctor = new Doctor(1, "Pedro", "Juarez", true, speciality, new ArrayList<>());
		
		when(specService.getSpecialityEntity(any(Integer.class))).thenReturn(speciality);
		when(docRepo.save(any(Doctor.class))).thenReturn(doctor);
		
		DoctorDTO newDocDto = docService.saveDoctor(docDto);
		
		assertEquals(docDto.getId(), newDocDto.getId());
		assertEquals(docDto.getName(), newDocDto.getName());
		assertEquals(docDto.getSurname(), newDocDto.getSurname());
		assertEquals(docDto.getIdSpeciality(), newDocDto.getIdSpeciality());
		
	}
	
	@Test
	public void shouldSoftDeleteADoctor() {
		Speciality speciality = new Speciality(1, "Pediatria", new ArrayList<>());
		Doctor doctor = new Doctor(1, "Pedro", "Juarez", true, speciality, new ArrayList<>());
		
		when(docRepo.findById(any(Integer.class))).thenReturn(Optional.of(doctor));
		when(docRepo.save(any(Doctor.class))).thenReturn(doctor);
		
		ArgumentCaptor<Doctor> argumentCaptor = ArgumentCaptor.forClass(Doctor.class);	
		docService.deleteDoctor(1);
		
		verify(docRepo).save(argumentCaptor.capture());
			
		assertFalse(argumentCaptor.getValue().getIsActive());	
	}
	
	@Test
	public void shouldReturnAPageWithAllDoctors() {
		Speciality speciality = new Speciality(1, "Pediatria", new ArrayList<>());
		Doctor doctor1 = new Doctor(1, "Pedro", "Juarez", true, speciality, new ArrayList<>());
		Doctor doctor2 = new Doctor(2, "Sebastian", "Seballos", true, speciality, new ArrayList<>());
		List<Doctor> doctorsList = new ArrayList<>();
		doctorsList.add(doctor1);
		doctorsList.add(doctor2);
		Page<Doctor> page = new PageImpl<>(doctorsList);
		
		when(docRepo.findAll(any(Pageable.class))).thenReturn(page);
		
		Pageable pageable = Pageable.unpaged();
		Page<DoctorDTO> pageDocDto = docService.listDoctors(pageable);
		
		assertEquals(1, pageDocDto.getContent().get(0).getId());
		assertEquals(2, pageDocDto.getContent().get(1).getId());
		assertEquals(2, pageDocDto.getContent().size());
		
	}
	
	@Test
	public void shouldReturnADoctor() {
		Speciality speciality = new Speciality(1, "Pediatria", new ArrayList<>());
		Doctor doctor = new Doctor(1, "Pedro", "Juarez", true, speciality, new ArrayList<>());
		
		when(docRepo.findById(1)).thenReturn(Optional.of(doctor));
		
		Doctor doctorSearched = docService.getDoctorEntity(1);
		
		assertThat(doctorSearched).isNotNull();
	}
}
