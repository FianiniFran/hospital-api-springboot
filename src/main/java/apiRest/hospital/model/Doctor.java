package apiRest.hospital.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name= "doctor")
public class Doctor {	
	
	public Doctor(Integer id) {
		this.id = id;
	}
	

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name="first_name")
	private String name;
	@Column(name="last_name")
	private String surname;
	@Column(name="status")
	private Boolean isActive;
	
	@ManyToOne
	@JoinColumn(name="id_speciality", referencedColumnName="id")
	private Speciality speciality;
	
	@OneToMany(mappedBy = "doctor")
	@Builder.Default
	private List<Turn> turns = new ArrayList<>();
}
