package kodlamaio.hrms.business.Abstracts;

import java.util.List;

import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.entities.Concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	DataResult<JobSeeker> getByEmail(String email);
	DataResult<JobSeeker > getByIdentityNumber(String nationalyIdentity);
	}
