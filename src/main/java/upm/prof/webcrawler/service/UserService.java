package upm.prof.webcrawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.prof.webcrawler.entity.User;
import upm.prof.webcrawler.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public List<User> getAllDemoUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findUserById(id);
	}
	
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	



}
