package com.example.hibernate_demo;

import com.example.hibernate_demo.domain.Account;
import com.example.hibernate_demo.domain.User;
import com.example.hibernate_demo.repository.AccountRepository;
import com.example.hibernate_demo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HibernateDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void hashAndEquals() {
		User user1 = new User();
		User user2 = new User();
		Account account1 = new Account();

		int hash1 = user1.hashCode();
		int hash2 = user2.hashCode();
		int hash3 = account1.hashCode();

		assertEquals(hash1, hash2);
		assertNotEquals(hash1, hash3);

		boolean equal = user1.equals(user2);
		assertFalse(equal);

		Date date = new Date();

		user1.setId(256L);
		user1.setUsername("test1");
		user1.setPassword("pass1");
		user1.setCreatedDate(date);
		user1.setUpdatedDate(date);

		user2.setId(257L);
		user2.setUsername("test2");
		user2.setPassword("pass2");
		user2.setCreatedDate(date);
		user2.setUpdatedDate(date);

		hash1 = user1.hashCode();
		hash2 = user2.hashCode();

		assertEquals(hash1, hash2);

		equal = user1.equals(user2);
		assertFalse(equal);
	}

	@Autowired
	UserRepository userRepository;

	@Autowired
	AccountRepository accountRepository;

	@Test
	@Disabled
	void prepareData() {
		final int INDEX = 3;

		User user = new User();
		user.setUsername("user" + INDEX);
		user.setPassword("password" + INDEX);

		Account account = new Account();
		account.setFirstName("user" + INDEX);
		account.setLastName("test" + INDEX);
		account.setDateOfBirth(new Date());
		account.setUser(user);

		user = userRepository.save(user);
		account = accountRepository.save(account);

		assertNotNull(user.getId());
		assertNotNull(account.getId());
	}
}
