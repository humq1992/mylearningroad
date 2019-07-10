package cn.bob.client_user.Service;

import cn.bob.client_user.dao.UserDao;
import cn.bob.client_user.dao.UserDaoImpl.UserDaoImpl;
import cn.bob.client_user.domain.User;

import java.util.List;

public interface UserService {

     List<User>  findall();

     User login(User user);

     User find(int uid);

     void submitupdate(User user);

     void add(User user);

     void delete(int uid);
     void deleteselected(String[] ids);


     int getcount(User u);

     List<User> findbypage(int i, int rows,User u);
}
