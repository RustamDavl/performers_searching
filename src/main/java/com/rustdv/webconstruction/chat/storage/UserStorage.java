package com.rustdv.webconstruction.chat.storage;

import java.util.HashSet;
import java.util.Set;

public class UserStorage {

    private static UserStorage instance;
    private Set<String> users;

    private UserStorage() {
        users = new HashSet<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public Set<String> getUsers() {
        return users;
    }

    public void setUser(String userName) {
        if (users.contains(userName)) {
            throw new RuntimeException("User aready exists with userName: " + userName);
        }
        users.add(userName);
    }
}