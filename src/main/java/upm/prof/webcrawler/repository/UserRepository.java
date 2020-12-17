package upm.prof.webcrawler.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import upm.prof.webcrawler.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findAll();
	
	User findUserById(int id);
	
	User save(User user);

}
