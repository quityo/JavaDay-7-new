package kodlamaio.hrms.entities.Concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	
	@Column(name="is_confirmed",columnDefinition="boolean default false")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date")
	private LocalDate confirmedDate=LocalDate.now();

}