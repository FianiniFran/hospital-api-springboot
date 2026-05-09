package apiRest.hospital.entities.keys;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TimetablePK implements Serializable{
	private Integer day;
	private LocalTime hourStart;
	private LocalTime hourEnd;
	
	
}
