package com.guru.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guru.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	@Autowired
	private UserService service;

	@Test
	public void testGetAllUsers() {
		assertTrue(!service.getAllUsers().isEmpty());
	}

	@Test
	public void testGetUser() {
		assertTrue("Phil Herold".equals(service.getUser(1).getName()));// based on setup data
	}

	@Test
	public void testSave() {
		service.save(new User(null, "Gurunath Sugavanam", "Java Developer", "R&D"));
		assertTrue(4 == service.getAllUsers().size());
		assertTrue("Gurunath Sugavanam".equals(service.getUser(4).getName()));
	}

	@Test
	public void testUpdate() {
		service.update(4, new User(null, "Gurunath Sugavanam", "Java Consultant", "R&D"));
		assertTrue("Java Consultant".equals(service.getUser(4).getTitle()));
	}

	@Test
	public void testDelete() {
		service.save(new User(null, "Delete User", "Some Stuff", "Accounting"));
		User deleteUser = service.delete(5);
		assertTrue(5 == deleteUser.getId());
		assertTrue("Delete User".equals(deleteUser.getName()));
		assertTrue("Some Stuff".equals(deleteUser.getTitle()));
		assertTrue("Accounting".equals(deleteUser.getDepartment()));
	}

	@Test
	public void testFindUserByName() {
		List<User> findUser = service.findUserByName("Chris Olinger");
		assertTrue(1 == findUser.size());// since there is only one Chris Olinger in our collection
		assertTrue("CTO".equals(findUser.get(0).getTitle()));
	}

}
