package kodlamaio.hrms.dataAccess.Abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{

	JobSeeker findByEmail(String email); 
	JobSeeker findByNationalyIdentity(String nationalyIdentity); 

}
