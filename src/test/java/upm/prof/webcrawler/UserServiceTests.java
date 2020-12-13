package upm.prof.webcrawler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import upm.prof.webcrawler.entity.User;
import upm.prof.webcrawler.repository.UserRepository;
import upm.prof.webcrawler.service.UserService;

@SpringBootTest
public class UserServiceTests {

	UserRepository userRepository;
	UserService userService;
	
	public void inicializarServicio() {
		if(userService == null) {
			userRepository = Mockito.mock(UserRepository.class);
			userService = new UserService();
			userService.userRepository = userRepository;
		}
	}
	
	@Test
	@DisplayName("Test 1.1 Regitrar usuario correcto")
	public void test1SaveUser() {
		inicializarServicio();
		
		User u = new User(3,"name","pass");
		User mockUser = new User(3,"name","pass");
		
		Mockito.when(userRepository.findUserById(u.getId())).thenReturn(null);
		Mockito.when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(mockUser);
		
		Assertions.assertEquals(u.getId(),mockUser.getId());
		Assertions.assertEquals(u.getUserName(),mockUser.getUserName());
		Assertions.assertEquals(u.getUserName(),mockUser.getUserName());
		
	}
	
}
