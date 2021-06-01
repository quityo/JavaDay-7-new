package kodlamaio.hrms.dataAccess.Abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Concretes.Position;

public interface PositionDao extends JpaRepository<Position,Integer> {
	List<Position> findByName(String name);
}