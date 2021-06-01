package kodlamaio.hrms.business.Concretes;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Abstracts.AuthService;
import kodlamaio.hrms.business.Abstracts.EmployerService;
import kodlamaio.hrms.business.Abstracts.JobSeekerService;
import kodlamaio.hrms.core.utitilies.results.ErrorResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.core.utitilies.results.SuccessResult;
import kodlamaio.hrms.core.validation.VerificationService;
import kodlamaio.hrms.entities.Concretes.Employer;
import kodlamaio.hrms.entities.Concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(EmployerService employerService, JobSeekerService jobSeekerService,
			VerificationService verificationService) {
		super();
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.verificationService = verificationService;
	}
	
	public static boolean isEmailValidation(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	


	@Override
	public Result registerEmployer(Employer employer, String confirmPassword) {
		if(!isEmailValidation(employer.getEmail()))
		{
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}
		
		else if(employer.getPassword()!=confirmPassword) {
			System.out.println(employer.getPassword());
			System.out.println(confirmPassword);
			
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
		var result = this.employerService.add(employer);
		
		if(result.isSuccess()) {
			if(this.verificationService.sendVerificationCode(employer.getEmail())) {
				return new SuccessResult("Employer Registered.");
			}
		}
		
		return new ErrorResult();
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker, String confirmPassword) {
		if(!isEmailValidation(jobSeeker.getEmail()))
		{
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}
    	else if(jobSeeker.getPassword()!= confirmPassword) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}
        var result = this.jobSeekerService.add(jobSeeker);
		
		if(result.isSuccess()) {
			if(this.verificationService.sendVerificationCode(jobSeeker.getEmail())) {
				return new SuccessResult("Employer Registered.");
			}
		}
		
		return new ErrorResult();
		

	}

	

}