package com.guru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.guru.model.User;

//Services should wire in Repository objects to a persistent store
//using the UserDataStub as a stand-in for a db representation - Guru
@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAllUsers() {
		return UserDataStub.getAllUsers();
	}

	@Override
	public User getUser(Integer id) {
		return UserDataStub.getUser(id);
	}

	@Override
	public User save(User user) {
		return UserDataStub.save(user);
	}

	@Override
	public User update(Integer id, User user) {
		return UserDataStub.update(id, user);
	}

	@Override
	public User delete(Integer id) {
		return UserDataStub.delete(id);
	}

	@Override
	public List<User> findUserByName(String name) {
		return UserDataStub.findUserByName(name);
	}

}
