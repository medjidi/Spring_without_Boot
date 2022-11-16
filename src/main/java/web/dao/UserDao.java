package web.dao;

import web.models.User;

import java.util.List;


public interface UserDao {

    void creat(User user);

    void delete(long id);

    User getUser(long id);

    void update(User user);

    List<User> getListOfUsers();

    void cleanUsersTable();
}
