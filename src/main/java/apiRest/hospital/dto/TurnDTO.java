package apiRest.hospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TurnDTO {
	private Integer id;
	
	
	@NotNull(message= "Day is mandatory")
	@Future(message="Needs to be a valid day")
	private LocalDate day;
	
	@NotNull(message= "Hour where start is mandatory")
	private LocalTime hourStart;
	
	@NotNull(message= "Hour where end is mandatory")
	private LocalTime hourEnd;
	
	private String description;
	
	@NotNull(message= "Patient ID is mandatory")
	private Integer idPatient;
	
	@NotNull(message= "Doctor ID is mandatory")
	private Integer idDoctor;
	
	@NotNull(message= "Speciality ID is mandatory")
	private Integer idSpeciality;
}
