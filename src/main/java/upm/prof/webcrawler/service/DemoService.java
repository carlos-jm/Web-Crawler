package upm.prof.webcrawler.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.prof.webcrawler.entity.DemoUser;
import upm.prof.webcrawler.repository.DemoUserRepository;

@Service
public class DemoService {

	@Autowired
	public DemoUserRepository DemoUserRepository;

	public List<DemoUser> getAllDemoUsers() {
//		List<DemoUser> users = DemoUserRepository.findAll();
		List<DemoUser> users = new ArrayList<>();
		DemoUserRepository.findAll().forEach(users::add);
		return users;
	}
	
	public List<DemoUser> getAllDemoUsersV2() {
		return new ArrayList<>(Arrays.asList(new DemoUser(1,"carlos","carlos")));
	}
	
//	public DemoUser getUserById(int id) {
//		return DemoUserRepository.findDemoUserById(id);
//	}


}
