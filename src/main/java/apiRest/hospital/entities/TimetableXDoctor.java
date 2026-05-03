package apiRest.hospital.entities;



import apiRest.hospital.entities.keys.TimetableXDoctorPK;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(TimetableXDoctorPK.class)
@Table(name= "timetablexdoctor")
public class TimetableXDoctor {
	@Id
	@ManyToOne
	@JoinColumn(name="id_doctor_TXD", referencedColumnName="id")
	private Doctor doctor;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="day_TXD", referencedColumnName="_day"),
		@JoinColumn(name="hour_start_TXD", referencedColumnName="hour_start"),
		@JoinColumn(name="hour_end_TXD", referencedColumnName="hour_end")
	})
	private Timetable timetable;

}
