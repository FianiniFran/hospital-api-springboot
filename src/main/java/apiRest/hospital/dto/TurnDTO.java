package apiRest.hospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private LocalDate day;
	private LocalTime hourStart;
	private LocalTime hourEnd;
	private String description;
	private Integer idPatient;
	private Integer idDoctor;
	private Integer idSpeciality;
}
