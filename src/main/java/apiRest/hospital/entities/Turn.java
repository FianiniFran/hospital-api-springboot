package apiRest.hospital.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	@Column(name="day_t")
	private LocalDate day;
	@Column(name="hour_start_t")
	private LocalTime hourStart;
	@Column(name="hour_end_t")
	private LocalTime hourEnd;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="id_patient_T", referencedColumnName="id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="id_doctor_t", referencedColumnName="id")
	private Doctor doctor;

	@Column(name="status")
	private Boolean isActive;
}
