package web.service;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User showUserByID(int id);
    void add(User user);

    User update(int id);

    void delete(int id);
}
