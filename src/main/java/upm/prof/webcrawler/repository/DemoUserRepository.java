package upm.prof.webcrawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import upm.prof.webcrawler.entity.DemoUser;

@Repository
public interface DemoUserRepository extends CrudRepository<DemoUser, Integer> {

//	List<DemoUser> findAll();
//	
//	DemoUser findDemoUserById(int id);

}
