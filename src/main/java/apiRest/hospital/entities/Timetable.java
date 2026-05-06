package apiRest.hospital.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import apiRest.hospital.entities.keys.TimetablePK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TimetablePK.class)
@Table(name= "timetable")
public class Timetable {
	@Id
	@Column(name="_day")
	private Integer day;
	@Id
	@Column(name="hour_start")
	private LocalTime hourStart;
	@Id
	@Column(name="hour_end")
	private LocalTime hourEnd;

}
