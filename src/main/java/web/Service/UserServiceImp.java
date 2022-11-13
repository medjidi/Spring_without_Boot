package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public User get(long id) {
      return userDao.get(id);
   }

   @Transactional
   @Override
   public void save(User user) {
      userDao.creat(user);
   }

   @Transactional
   @Override
   public void update(User user){
      userDao.update(user);
   }

   @Override
   public void delete(long id) {
      userDao.delete(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> getListUsers() {
      return userDao.read();
   }




}
