package cn.itcast.travel.service;

import cn.itcast.travel.domain.ErrorMessage;
import cn.itcast.travel.domain.User;

public interface UserService {
    public User extinctedUsername(User u);
    public void addUser(User u);
    public void activUser(String uuid);
    public User login(String username,String password);
    public User findbyUsername(String  username);
}
