package dev.deej_tsn.Blog.service;

import java.util.List;

import dev.deej_tsn.Blog.entity.User;

public interface UserService {
    List<User> findAll();
    
    User getUserByID(int user_id);

    void insertUser(User user);

    void updateUser(User user);



    public void deleteUser(User user);


}   
