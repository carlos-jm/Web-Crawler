package upm.prof.webcrawler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import upm.prof.webcrawler.entity.DemoUser;
import upm.prof.webcrawler.service.DemoService;

@RestController
@RequestMapping(value = "webcrawler/demoUsers")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<DemoUser> obtenerDemoUsers() {
		return demoService.getAllDemoUsers();
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	@ResponseStatus(HttpStatus.OK)
//	public DemoUser obtenerDemoUser(@PathVariable int id) {
//		return demoService.getUserById(id);
//	}
	
}
