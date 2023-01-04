package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User showUserByID(int id) {
        return userDAO.showUserByID(id);
    }

    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Override
    @Transactional
    public User update(User user, int id) {
        User userToUpdate = showUserByID(id);
        userToUpdate.setId(user.getId());
        userToUpdate.setName(user.getName());
        userToUpdate.setSurname(user.getSurname());
        return userDAO.update(userToUpdate, id);

    }

    @Override
    @Transactional
    public void delete(int id) {
        User userToDelete = showUserByID(id);
        userDAO.delete(userToDelete.getId());
    }

}
