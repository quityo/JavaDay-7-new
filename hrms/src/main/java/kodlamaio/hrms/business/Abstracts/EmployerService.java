package kodlamaio.hrms.business.Abstracts;

import java.util.List;

import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.entities.Concretes.Employer;



public interface EmployerService {

	DataResult<List<Employer>> getAll();
	DataResult<Employer> getByEmail(String email);
	Result add(Employer employer);
	
}
