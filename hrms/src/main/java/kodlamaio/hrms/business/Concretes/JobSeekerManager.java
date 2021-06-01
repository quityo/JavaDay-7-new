package kodlamaio.hrms.business.Concretes;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Abstracts.JobSeekerService;
import kodlamaio.hrms.core.adapter.CheckMernisService;
import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.ErrorResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.core.utitilies.results.SuccessDataResult;
import kodlamaio.hrms.core.utitilies.results.SuccessResult;
import kodlamaio.hrms.dataAccess.Abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.Concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private CheckMernisService checkMernisService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, CheckMernisService checkMernisService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.checkMernisService = checkMernisService;
	}
	
	private boolean validationForCandidate(JobSeeker jobSeeker) {
		if (Objects.isNull(jobSeeker.getNationalyIdentity()) || Objects.isNull(jobSeeker.getFirstName()) || Objects.isNull(jobSeeker.getLastName()) 
				|| Objects.isNull(jobSeeker.getEmail()) || Objects.isNull(jobSeeker.getPassword()) || Objects.isNull(jobSeeker.getBirthDate())) {
			return false;
		}
		
	  return true;
	}
	
	private boolean checkIfEmailExists(String email) {
		if(this.jobSeekerDao.findByEmail(email) !=null) {
			return false;
		}
		return true;	
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new  SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String nationalyIdentity) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalyIdentity(nationalyIdentity));
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		if(checkMernisService.checkIfRealTcNo(jobSeeker)){
			return new ErrorResult("Not a valid person");
		}
		else if(!validationForCandidate(jobSeeker)) {
			return new ErrorResult("You have entered incomplete information. Please check your information again.");
		}
		if(!this.checkIfEmailExists(jobSeeker.getEmail())){
			return new ErrorResult("This email address already exists.");
		}
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Candidate successfully added.");
	}

	@Override
	public DataResult<JobSeeker> getByEmail(String email) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByEmail(email));
	}


}