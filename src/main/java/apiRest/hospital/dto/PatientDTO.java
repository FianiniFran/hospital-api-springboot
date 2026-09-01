package apiRest.hospital.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDTO {
	
	private Integer id;
	
	@NotBlank(message= "Name is mandatory")
	private String name;
	
	@NotBlank(message= "Surname is mandatory")
	private String surname;
	
	@NotNull(message= "BirthDate is mandatory")
	private LocalDate birthDate;
}
