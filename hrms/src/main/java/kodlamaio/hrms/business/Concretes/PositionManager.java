package kodlamaio.hrms.business.Concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.Abstracts.PositionService;
import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.ErrorResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.core.utitilies.results.SuccessDataResult;
import kodlamaio.hrms.core.utitilies.results.SuccessResult;
import kodlamaio.hrms.dataAccess.Abstracts.PositionDao;
import kodlamaio.hrms.entities.Concretes.Position;

@Service
public class PositionManager implements PositionService{

	private PositionDao positionDao;
	
	@Autowired
	public PositionManager(PositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}
	private boolean checkIfPositionExists(String name) {
		if(this.positionDao.findByName(name) != null) {
			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(),"Data listelendi");
	}

	@Override
	public Result add(Position position) {
		if(!this.checkIfPositionExists(position.getName())) {
			return new ErrorResult("This position already exists in the system.");
		}
		this.positionDao.save(position);
		return new SuccessResult("Job position added");
	}

	
}