package kodlamaio.hrms.dataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Concretes.Employer;



public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Employer findByEmail(String email);
}