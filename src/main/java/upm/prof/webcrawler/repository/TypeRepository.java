package upm.prof.webcrawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import upm.prof.webcrawler.entity.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer>{
	
	List<Type> findAll();
	
	Type findTypeById(int id);
	
	Type save(Type type);
}
