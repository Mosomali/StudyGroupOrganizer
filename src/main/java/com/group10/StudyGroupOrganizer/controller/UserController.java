package com.group10.StudyGroupOrganizer.controller;

import com.group10.StudyGroupOrganizer.model.User;
import com.group10.StudyGroupOrganizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public String getAllUser(Model model){
        List<User> users =userService.getAllUser();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/{id}")
    public String getuserById(@PathVariable Long id, Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user",user);
        return "user-profile";
    }
    @GetMapping("/new")
    public String showUserForm(Model model){
        model.addAttribute("user", new User());
        return "user-form";
    }
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "group-page";
    }
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id,Model model){
        User user= userService.getUserById(id);
        model.addAttribute("user",user);
        return "user-form";
    }
    @PostMapping("/{id}/edit")
    public String updateUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

}
