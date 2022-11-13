package web.Service;

import org.springframework.stereotype.Service;
import web.models.User;

import java.util.List;

public interface UserService {

    User get(long id);
    void save(User user);

    void update(User user);

    void delete(long id);

    List<User> getListUsers();

}
