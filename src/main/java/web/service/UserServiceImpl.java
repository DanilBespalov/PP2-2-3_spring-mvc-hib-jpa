package web.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        String jpql = "SELECT User FROM User";
        TypedQuery<User> userTypedQuery = entityManager.createQuery(jpql, User.class);
        return userTypedQuery.getResultList();
    }

    @Override
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
