
package cz.pprochaty.web.model.dao;

import cz.pprochaty.web.model.User;
import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    List<User> getAllUsers();
    void deleteUser(Integer user_id);
    void addUser(User user);
    void updateUser(User user);
    User getUserByLogin(String login);
    User getUserByUserName(String login);
}
