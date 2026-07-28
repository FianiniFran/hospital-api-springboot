package apiRest.hospital.mapper;

import apiRest.hospital.dto.DoctorDTO;
import apiRest.hospital.dto.PatientDTO;
import apiRest.hospital.dto.SpecialityDTO;
import apiRest.hospital.dto.TimetableDTO;
import apiRest.hospital.dto.TimetableXDoctorDTO;
import apiRest.hospital.dto.TurnDTO;
import apiRest.hospital.model.Doctor;
import apiRest.hospital.model.Patient;
import apiRest.hospital.model.Speciality;
import apiRest.hospital.model.Timetable;
import apiRest.hospital.model.TimetableXDoctor;
import apiRest.hospital.model.Turn;

public class Mapper {
	public static DoctorDTO toDTO(Doctor doctor) {
		if(doctor == null) return null;
		
		return new DoctorDTO(
				doctor.getId(),
				doctor.getName(),
				doctor.getSurname(),
				doctor.getSpeciality().getId()
				);
	}
	
	
	public static Doctor toEntity(DoctorDTO	doctorDto, Speciality speciality) {
		if(doctorDto == null) return null;
		
		Doctor doctor = Doctor.builder()
				.name(doctorDto.getName())
				.surname(doctorDto.getSurname())
				.isActive(true)
				.speciality(speciality)
				.build();
		
		return doctor;
	}
	
	public static PatientDTO toDTO(Patient patient) {
		if(patient == null) return null;
		
		return new PatientDTO(
				patient.getId(),
				patient.getName(),
				patient.getSurname(),
				patient.getBirthDate()
				);
				
	}
	
	public static Patient toEntity(PatientDTO patientDto) {
		if(patientDto == null) return null;
		
		Patient patient = Patient.builder()
				.name(patientDto.getName())
				.surname(patientDto.getSurname())
				.birthDate(patientDto.getBirthDate())
				.isActive(true)
				.build();
		
		return patient;
	}
	
	public static SpecialityDTO toDTO(Speciality speciality) {
		if(speciality == null) return null;
		
		return new SpecialityDTO(
				speciality.getId(),
				speciality.getDescription()
				);
	}
	
	public static Speciality toEntity(SpecialityDTO specialityDto) {
		if(specialityDto == null) return null;
		
		Speciality speciality = Speciality.builder()
				.description(specialityDto.getDescription())
				.build();
		
		return speciality;
	}
	
	public static TimetableDTO toDTO(Timetable timetable) {
		if(timetable == null) return null;
		
		return new TimetableDTO(
				timetable.getDay(),
				timetable.getHourStart(),
				timetable.getHourEnd()
				);
	}
	
	public static TimetableXDoctorDTO toDTO(TimetableXDoctor timetableXDoctor) {
		if(timetableXDoctor == null) return null;
		
		
		return new TimetableXDoctorDTO(
				timetableXDoctor.getId(),
				timetableXDoctor.getDoctor().getName(),
				timetableXDoctor.getTimetable().getDay(),
				timetableXDoctor.getTimetable().getHourStart(),
				timetableXDoctor.getTimetable().getHourEnd()
				);
	}
	
	public static TimetableXDoctor toEntity(Doctor doctor, Timetable timetable) {
		if(doctor == null) return null;
		if(timetable == null) return null;
		
		TimetableXDoctor timeXDoc = TimetableXDoctor.builder()
				.doctor(doctor)
				.timetable(timetable)
				.build();
		
		return timeXDoc;
	}
	
	public static TurnDTO toDTO(Turn turn) {
		if(turn == null) return null;
		
		return new TurnDTO(
				turn.getId(),
				turn.getTurnDate(),
				turn.getTurnHourStart(),
				turn.getTurnHourEnd(),
				turn.getDescription(),
				turn.getPatient().getId(),
				turn.getDoctor().getId(),
				turn.getDoctor().getSpeciality().getId()
				);
	}
	
	public static Turn toEntity(TurnDTO turnDto, Doctor doctor, Patient patient) {
		if(turnDto == null) return null;
		
		Turn turn = Turn.builder()
				.turnDate(turnDto.getDay())
				.turnHourStart(turnDto.getHourStart())
				.turnHourEnd(turnDto.getHourEnd())
				.description(turnDto.getDescription())
				.isActive(true)
				.doctor(doctor)
				.patient(patient)
				.build();
		
		return turn;
	}
}
