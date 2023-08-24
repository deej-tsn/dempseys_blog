package dev.deej_tsn.Blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.deej_tsn.Blog.dao.UserDao;
import dev.deej_tsn.Blog.entity.User;
import jakarta.annotation.Resource;


@Service
public class UserServiceImpl implements UserService{

    @Resource
    UserDao usersDao;



    @Override
    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    public void insertUser(User user) {
       usersDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        usersDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        usersDao.deleteUser(user);
    }

    @Override
    public User getUserByID(int user_id) {
        return usersDao.getUserByID(user_id);
    }
    
}
