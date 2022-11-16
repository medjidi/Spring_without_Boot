package web.Service;

import web.models.User;

import java.util.List;

public interface UserService {

    User getUser(long id);

    void save(User user);

    void update(User user);

    void delete(long id);

    List<User> getListOfUsers();

}
