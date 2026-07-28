package apiRest.hospital.dto;

import java.time.LocalTime;

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
	private String name;
	private Integer day;
	private LocalTime hourStart;
	private LocalTime hourEnd;
}
