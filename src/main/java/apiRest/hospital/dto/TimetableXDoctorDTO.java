package apiRest.hospital.dto;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimetableXDoctorDTO {
	private Integer idDoctor;
	
	@NotBlank(message= "Name is mandatory")
	private String name;
	
	@NotNull(message= "Day is mandatory")
	private Integer day;
	
	@NotNull(message= "Hour where start is mandatory")
	private LocalTime hourStart;
	
	@NotNull(message= "Hour where end is mandatory")
	private LocalTime hourEnd;
}
