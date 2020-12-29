package org.learning.jpa.JPALearning;

import java.util.List;
import java.util.Optional;

import org.learning.jpa.JPALearning.entity.User;
import org.learning.jpa.JPALearning.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserRepsotoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserRepsotoryCommandLineRunner.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User ("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is Created "+user);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : "+userWithIdOne);
		
		List<User> users = userRepository.findAll();
		log.info("All users "+users);
	}

	
	
}
