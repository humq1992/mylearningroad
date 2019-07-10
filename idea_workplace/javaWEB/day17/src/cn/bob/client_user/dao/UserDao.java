package cn.bob.client_user.dao;

import cn.bob.client_user.domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findall();
    public User login(User user);
    public User find(int id);
    public void submitupdate(User user);
    public void add(User user);
    public void delete(int uid);
    public void deleteselected(String[] ids);
    public int getcount(User u);
    public List<User> findbypage(int start,int rows, User u);

}
