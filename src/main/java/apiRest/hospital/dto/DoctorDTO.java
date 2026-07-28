package apiRest.hospital.dto;


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
	private String name;
	private String surname;
	private Integer idSpeciality;
}
