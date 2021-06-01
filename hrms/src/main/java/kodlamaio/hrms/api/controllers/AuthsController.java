package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.Abstracts.AuthService;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.entities.Concretes.Employer;
import kodlamaio.hrms.entities.Concretes.JobSeeker;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {

	private AuthService authService;

	@Autowired
	public AuthsController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer,String confirmPassword) {
		return this.authService.registerEmployer(employer, confirmPassword);
	}
	

	@PostMapping("/registerJobSeeker")
	public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker ,String confirmPassword) {
		return this.authService.registerJobSeeker (jobSeeker, confirmPassword);
	}
	

}