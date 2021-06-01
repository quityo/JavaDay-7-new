package kodlamaio.hrms.business.Abstracts;

import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.entities.Concretes.Employer;
import kodlamaio.hrms.entities.Concretes.JobSeeker;

public interface AuthService {
	Result registerEmployer(Employer employer,String confirmPassword);
	Result registerJobSeeker(JobSeeker jobSeeker ,String confirmPassword);

}
