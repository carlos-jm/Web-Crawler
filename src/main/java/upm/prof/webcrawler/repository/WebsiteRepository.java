package upm.prof.webcrawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import upm.prof.webcrawler.entity.Website;

@Repository
public interface WebsiteRepository extends CrudRepository<Website, Integer> {

    List<Website> findAll();

    Website findWebsiteById(int id);

    Website save(Website website);

    void deleteById(int id);

}
