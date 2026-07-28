package apiRest.hospital.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@IdClass(TimetableXDoctorPK.class)
@Table(name= "timetablexdoctor")
public class TimetableXDoctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name="id_timetable_TXD", referencedColumnName="id")
	private Timetable timetable;
	@JoinColumn(name="id_doctor_TXD", referencedColumnName="id")
	private Doctor doctor;
	
//	@Id
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="id_doctor_TXD", referencedColumnName="id")
//	private Doctor doctor;
//	
//	@Id
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumns({
//		@JoinColumn(name="day_TXD", referencedColumnName="_day"),
//		@JoinColumn(name="hour_start_TXD", referencedColumnName="hour_start"),
//		@JoinColumn(name="hour_end_TXD", referencedColumnName="hour_end")
//	})
//	private Timetable timetable;

}
