package apiRest.hospital.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class DoctorDTO {
	private Integer id;
	
	@NotBlank(message= "Name is mandatory")
	private String name;
	
	@NotBlank(message= "Surname is mandatory")
	private String surname;
	
	@NotBlank(message= "Speciality ID is mandatory")
	private Integer idSpeciality;
}
