package com.guru.service;

import java.util.List;

import com.guru.model.User;

public interface UserService {

	List<User> getAllUsers();

	User getUser(Integer id);

	User save(User user);

	User update(Integer id, User user);

	User delete(Integer id);

	List<User> findUserByName(String name);

}
