package kodlamaio.hrms.business.Abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.Result;

public interface UserService {

	DataResult<List<User>> getAll();
	Result add(User user);
}
