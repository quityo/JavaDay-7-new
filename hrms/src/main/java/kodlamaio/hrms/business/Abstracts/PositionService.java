package kodlamaio.hrms.business.Abstracts;

import java.util.List;

import kodlamaio.hrms.core.utitilies.results.DataResult;
import kodlamaio.hrms.core.utitilies.results.Result;
import kodlamaio.hrms.entities.Concretes.Position;

public interface PositionService {
	DataResult<List<Position>> getAll();
	Result add(Position position);

}
