package kodlamaio.hrms.business.Concretes;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Abstracts.EmployerService;
import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.ErrorResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.core.utitilies.results.SuccessDataResult;
import kodlamaio.hrms.core.utitilies.results.SuccessResult;
import kodlamaio.hrms.dataAccess.Abstracts.EmployerDao;
import kodlamaio.hrms.entities.Concretes.Employer;


@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao){
		super();
		this.employerDao = employerDao;
	}
	private boolean checkIfEmailExists(String email) {
		if(this.employerDao.findByEmail(email) != null) {
			return false;
		}
		return true;
	}
	
	private boolean validationForEmployer(Employer employer) {
		if (Objects.isNull(employer.getCompanyName()) || Objects.isNull(employer.getWebSite()) || Objects.isNull(employer.getEmail()) 
				|| Objects.isNull(employer.getPhoneNumber()) || Objects.isNull(employer.getPassword())){
			return false;
		}
		
	  return true;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getByEmail(String email) {
		return new SuccessDataResult<Employer>(this.employerDao.findByEmail(email));
	}
	
	@Override
	public Result add(Employer employer) {
		if(!this.checkIfEmailExists(employer.getEmail())){
			return new ErrorResult("This email address already exists.");
		}
		if(!this.validationForEmployer(employer)) {
			return new ErrorResult("You have entered incomplete information. Please check your information again.");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Employer successfully added.");
		
	}

	

}