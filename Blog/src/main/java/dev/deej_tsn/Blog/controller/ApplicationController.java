package dev.deej_tsn.Blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.deej_tsn.Blog.service.UserService;
import jakarta.annotation.Resource;

import dev.deej_tsn.Blog.entity.User;

@RestController
@RequestMapping("/api")
public class ApplicationController {
    
    @Resource
    UserService userService;

    @GetMapping(value =  "/getAllUsers")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/getUser/{user_id}")
    public User getUserByID(@PathVariable(value = "user_id") int user_id){
        return userService.getUserByID(user_id);
    }
    

    @PostMapping(value = "/insertUser")
    public void createUser(@RequestBody Map<String,String> request) {
        User user = new User();
        System.out.println(request);
        user.setFirstName(request.get("personal_first_name"));
        user.setSecondName(request.get("personal_second_name"));
        user.setEmail("personal_email");
        user.setUserName("username");
        user.setSalt(request.get("salt"));
        user.setPasshash(request.get("passhash"));
        userService.insertUser(user);
    }

    @DeleteMapping(value = "/deleteUser")
    public void deleteUser(@RequestBody Map<String,String> request) {
        User user = new User();
        user.setUserID(request.get("user_id"));
        userService.deleteUser(user);
    }

}
