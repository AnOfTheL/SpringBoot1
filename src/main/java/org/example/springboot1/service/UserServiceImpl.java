package org.example.springboot1.service;

import org.example.springboot1.model.User;
import org.example.springboot1.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    @Transactional
    public void saveUser(User user) { userRepo.saveUser(user); }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userRepo.getUserById(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, String name, String lastName, byte age) {
        userRepo.updateUser(id, name, lastName, age);
    }

    @Override
    @Transactional
    public void deleteUserById(long id) {
        userRepo.deleteUserById(id);
    }
}
