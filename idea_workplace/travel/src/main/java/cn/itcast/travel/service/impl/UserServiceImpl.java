package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FindUserDao;
import cn.itcast.travel.dao.impl.FindUserDaoImpl;
import cn.itcast.travel.domain.ErrorMessage;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.Md5Util;

public class UserServiceImpl implements UserService {
    @Override
    public User extinctedUsername(User u) {
        FindUserDao findUserDao=new FindUserDaoImpl();
        User user = findUserDao.findUser(u);


        return user;
    }

    @Override
    public void addUser(User u) {
        FindUserDaoImpl findUserDao = new FindUserDaoImpl();
        findUserDao.addUser(u);
        String mailcontent="<a href='http://localhost/travel//UserServlet/active?activeCode="+u.getCode()+"'>这是来自黑马旅游网的激活邮件，请点击激活</a>";
        MailUtils.sendMail(u.getEmail(),mailcontent,"激活您的黑马旅游账号");
    }

    @Override
    public void activUser(String uuid) {
        FindUserDao findUserDao = new FindUserDaoImpl();
        findUserDao.activeuser(uuid);

    }

    @Override
    public User login(String username, String password) {
        FindUserDaoImpl findUserDao = new FindUserDaoImpl();
        String password_md5 = null;
        try {
            password_md5 = Md5Util.encodeByMd5(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FindUserDaoImpl findUserDao1 = new FindUserDaoImpl();
        User user = findUserDao.login(username, password_md5);
        return user;
    }

    @Override
    public User findbyUsername(String username) {
        FindUserDaoImpl findUserDao = new FindUserDaoImpl();
        User user = findUserDao.findbyusername(username);
     return user;
    }
}
