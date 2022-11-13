package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {}



    @Transactional
    @Override
    public void creat(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User get(long id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void update(User user) {
        user.setEmail(user.getEmail());
        user.setName(user.getName());
        user.setLast_name(user.getLast_name());
        entityManager.merge(user);
    }


    @Transactional(readOnly = true)
    @Override
    public List<User> read() {
        return entityManager.createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public void cleanUsersTable() {

    }
}
