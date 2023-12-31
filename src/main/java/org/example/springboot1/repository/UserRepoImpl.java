package org.example.springboot1.repository;

import org.example.springboot1.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        em.joinTransaction();
        em.persist(user);
        em.flush();
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void updateUser(long id, String name, String lastname, byte age) {
        em.joinTransaction();

        User user = em.find(User.class, id);
        user.setName(name);
        user.setLastname(lastname);
        user.setAge(age);

        em.flush();
    }

    @Override
    public void deleteUserById(long id) {
        em.joinTransaction();
        User user = em.find(User.class, id);
        em.remove(user);
        em.flush();
    }
}
