package kodlamaio.hrms.business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.core.utitilies.results.SuccessDataResult;
import kodlamaio.hrms.core.utitilies.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll());
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added.");
	}

}