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
public class SpecialityDTO {
	private Integer id;
	
	@NotBlank(message= "Speciality name is mandatory")
	private String description;
}
