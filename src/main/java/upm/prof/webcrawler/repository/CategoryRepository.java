package upm.prof.webcrawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import upm.prof.webcrawler.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	
	List<Category> findAll();
	
	Category findCategoryById(int id);
	
	Category save(Category category);
}
