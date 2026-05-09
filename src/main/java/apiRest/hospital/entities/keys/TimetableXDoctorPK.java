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
public class TimetableXDoctorPK implements Serializable {
	private Integer doctor;
	private TimetablePK timetable;
}
