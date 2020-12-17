package upm.prof.webcrawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.prof.webcrawler.entity.Category;
import upm.prof.webcrawler.exceptions.AlreadyExistsException;
import upm.prof.webcrawler.exceptions.BadRequestException;
import upm.prof.webcrawler.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	public CategoryRepository categoryRepository;

	public List<Category> getAllDemoUsers() {
		return categoryRepository.findAll();
	}

	public Category getUserById(int id) {
		return categoryRepository.findCategoryById(id);
	}


	public Category saveUser(Category category) throws BadRequestException, AlreadyExistsException {
		if(category.getName()==null) {
			throw new BadRequestException("Rellene todos los campos obligatorios.");
		}
		
		if(categoryRepository.findCategoryById(category.getId())!=null)
		{
			throw new AlreadyExistsException("Ya existe un usuario con ese id.");
		}
		
		return categoryRepository.save(category);
	}
}
