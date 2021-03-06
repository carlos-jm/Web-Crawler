package upm.prof.webcrawler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import upm.prof.webcrawler.repository.WebsiteRepository;
import upm.prof.webcrawler.entity.Category;
import upm.prof.webcrawler.entity.Type;
import upm.prof.webcrawler.entity.Website;
import upm.prof.webcrawler.exceptions.AlreadyExistsException;
import upm.prof.webcrawler.exceptions.BadRequestException;

@Service
public class WebsiteService {
	
	@Autowired
	public WebsiteRepository websiteRepository;
	
	@Autowired
	private TypeService typeService;
	@Autowired
	private CategoryService categoryService;
	
	public List<Website> getAllDemoWebsites()
	{

		return websiteRepository.findAll();
	}
	
	public Website getWebsiteById(int id) {
		return websiteRepository.findWebsiteById(id);
	}
	
	public Website saveWebsite(Website website) throws BadRequestException,AlreadyExistsException{
		if(website.getUrl() == null || 
				website.getType() == null ||
				website.getCategory() == null ||
				website.getLast_update() == null) 
		{
			
			throw new BadRequestException("Rellene todos los campos obligatorios.");
		
		}
		else if(websiteRepository.findWebsiteById(website.getId()) != null ) 
		{
			throw new AlreadyExistsException("Ya existe un usuario con ese id.");
		}
		
		return websiteRepository.save(website);
	}
	
	public void removeWebsiteById(int id) {
		websiteRepository.deleteById(id);
	}
	
	public List<Website> getFilterWebsite(String url, int cat_id, int type_id)
	{
		
		return websiteRepository.filterWebsite("%"+url+"%", categoryService.getCategoryById(cat_id) , typeService.getTypeById(type_id));
		
	}
}
