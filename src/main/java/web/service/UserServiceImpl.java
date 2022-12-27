package web.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        TypedQuery<User> userTypedQuery = entityManager.createQuery("from User", User.class);
        return userTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public User showUserByID(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public User update(int id) {
        User userToUpdate = showUserByID(id);
        return entityManager.merge(userToUpdate);

    }

    @Override
    @Transactional
    public void delete(int id) {
        User userToDelete = showUserByID(id);
        entityManager.remove(userToDelete);
    }
}
