package org.example.springboot1.repos;


import org.example.springboot1.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo {
    void saveUser(User user);

    void deleteUserById(long id);

    List<User> getAllUsers();

    void updateUser(long id, String name, String lastname, byte age);

    User getUserById(long id);
}

