package apiRest.hospital.model;

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
@Table(name= "turn")
public class Turn {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="turn_date")
	private LocalDate turnDate;
	
	@Column(name="turn_hour_start")
	private LocalTime turnHourStart;
	
	@Column(name="turn_hour_end")
	private LocalTime turnHourEnd;
	
	@Column(name="description")
	private String description;
	
	@Column(name="status")
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="id_doctor_t", referencedColumnName="id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="id_patient_T", referencedColumnName="id")
	private Patient patient;
	
}