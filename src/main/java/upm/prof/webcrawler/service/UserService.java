package upm.prof.webcrawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.prof.webcrawler.entity.User;
import upm.prof.webcrawler.exceptions.AlreadyExistsException;
import upm.prof.webcrawler.exceptions.BadRequestException;
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


	public User saveUser(User user) throws BadRequestException, AlreadyExistsException {
		if(user.getUserName()==null || user.getPassword() == null) {
			throw new BadRequestException("Rellene todos los campos obligatorios.");
		}
		
		if(userRepository.findUserById(user.getId())!=null)
		{
			throw new AlreadyExistsException("Ya existe un usuario con ese id.");
		}
		
		return userRepository.save(user);
	}




}
