package apiRest.hospital.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name= "patient")
public class Patient {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "first_name")
	@NotBlank(message="Name is mandatory")
	private String name;

	@Column(name = "last_name")
	@NotBlank(message="Surname is mandatory")
	private String surname;

	@NotNull(message="BirthDate is mandatory")
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@NotNull(message="Status is mandatory")
	@Column(name = "status")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "patient")
	@Builder.Default
	List<Turn> turns = new ArrayList<>();
}
