package com.guru.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.guru.model.User;

public class UserDataStub {
	private static Map<Integer, User> users = new HashMap<Integer, User>();

	// Create some sample users here=>
	static {
		users.put(1, new User(1, "Phil Herold", "Manager", "R&D"));
		users.put(2, new User(2, "Chris Olinger", "CTO", "Executive"));
		users.put(3, new User(3, "John Leveille", "CEO", "Executive"));
	}

	public static List<User> getAllUsers() {
		return new ArrayList<User>(users.values());
	}

	public static User getUser(Integer id) {
		return users.get(id);
	}

	public static User get(Integer id) {
		return users.get(id);
	}

	public static User save(User user) {
		Integer id = users.keySet().stream().mapToInt(Integer::intValue).max().getAsInt() + 1;
		user.setId(id);
		users.put(id, user);
		return user;
	}

	public static User update(Integer id, User user) {
		user.setId(id);
		users.put(id, user);
		return user;
	}

	public static User delete(Integer id) {
		return users.remove(id);
	}

	public static List<User> findUserByName(String name) {
		return users.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
	}

}
