package apiRest.hospital.model;


import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(TimetablePK.class)
@Table(name= "timetable")
public class Timetable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="day")
	private Integer day;
	
	@Column(name="hour_start")
	private LocalTime hourStart;
	
	@Column(name="hour_end")
	private LocalTime hourEnd;
	
	
//	@Id
//	@Column(name="_day")
//	private Integer day;
//	@Id
//	@Column(name="hour_start")
//	private LocalTime hourStart;
//	@Id
//	@Column(name="hour_end")
//	private LocalTime hourEnd;

}
