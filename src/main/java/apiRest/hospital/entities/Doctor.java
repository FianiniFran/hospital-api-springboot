package apiRest.hospital.entities;

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
@Table(name= "doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String name;
	@Column(name="last_name")
	private String surname;
	@Column(name="status")
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="id_speciality", referencedColumnName="id")
	private Speciality speciality;
	
}
