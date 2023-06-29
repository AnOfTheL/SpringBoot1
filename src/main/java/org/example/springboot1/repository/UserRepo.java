package org.example.springboot1.repository;


import org.example.springboot1.model.User;

import java.util.List;

public interface UserRepo {
    void saveUser(User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    void updateUser(long id, String name, String lastname, byte age);

    User getUserById(long id);
}

