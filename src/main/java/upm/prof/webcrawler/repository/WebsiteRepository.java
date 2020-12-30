package upm.prof.webcrawler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import upm.prof.webcrawler.entity.Category;
import upm.prof.webcrawler.entity.Type;
import upm.prof.webcrawler.entity.Website;

@Repository
public interface WebsiteRepository extends CrudRepository<Website, Integer> {

    List<Website> findAll();

    Website findWebsiteById(int id);

    Website save(Website website);

    void deleteById(int id);
    
    @Query("SELECT w FROM Website w WHERE url LIKE ?1 AND category=?2 AND type=?3")
    List<Website> filterWebsite(
    		String url, 
    		Category categoria,
    		Type tipo
    		);

}
