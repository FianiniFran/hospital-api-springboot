package apiRest.hospital.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "patient")
public class Patient {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	private String name;

	@Column(name = "last_name")
	private String surname;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "status")
	private boolean isActive;
}
