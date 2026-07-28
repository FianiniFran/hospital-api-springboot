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
public class TimetableDTO {
	private Integer day;
	private LocalTime hourStart;
	private LocalTime hourEnd;
}
