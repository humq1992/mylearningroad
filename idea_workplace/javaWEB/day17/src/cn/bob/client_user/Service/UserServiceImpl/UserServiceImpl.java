package cn.bob.client_user.Service.UserServiceImpl;

import cn.bob.client_user.Service.UserService;
import cn.bob.client_user.dao.UserDao;
import cn.bob.client_user.dao.UserDaoImpl.UserDaoImpl;
import cn.bob.client_user.domain.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> findall() {
        List<User> list = userDao.findall();

        return list;
    }

    @Override
    public User login(User user) {
        User u = userDao.login(user);

        return u;
    }

    @Override
    public User find(int uid) {
        User u = userDao.find(uid);
        return u;
    }

    @Override
    public void submitupdate(User user) {
        userDao.submitupdate(user);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(int uid) {
        userDao.delete(uid);
    }

    @Override
    public void deleteselected(String[] ids) {
        userDao.deleteselected(ids);
    }

    @Override
    public int getcount(User u) {
        int count=userDao.getcount(u);
        return count;
    }

    @Override
    public List<User> findbypage(int currentpage, int rows,User u) {
        int start=(currentpage-1)*rows;
        List<User> list = userDao.findbypage(start, rows,u);
        return list;
    }
}
