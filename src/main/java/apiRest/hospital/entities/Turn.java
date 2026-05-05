package apiRest.hospital.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name= "turn")
public class Turn {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_patient_T", referencedColumnName="id")
	private Patient patient;
		
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="id_doctor_T", referencedColumnName="id_doctor_TXD"),
		@JoinColumn(name="day_T", referencedColumnName="day_TXD"),
		@JoinColumn(name="hour_start_T", referencedColumnName="hour_start_TXD"),
		@JoinColumn(name="hour_end_T", referencedColumnName="hour_end_TXD")
	})
	private TimetableXDoctor timetablesDoctor;
	

}
