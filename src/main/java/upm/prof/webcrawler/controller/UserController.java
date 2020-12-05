package upm.prof.webcrawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import upm.prof.webcrawler.entity.User;
import upm.prof.webcrawler.exceptions.BadRequestException;
import upm.prof.webcrawler.service.UserService;

@RestController
@RequestMapping(value = "webcrawler/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<User> obtenerDemoUsers() {
		return userService.getAllDemoUsers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public User obtenerDemoUser(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public User createUser(@RequestBody User user) throws BadRequestException {
		return userService.saveUser(user);
	}
	
	
}
