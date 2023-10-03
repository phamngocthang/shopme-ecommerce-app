package com.progamming.ShopmeBackEnd.user;

import com.progamming.ShopmeCommon.entity.Role;
import com.progamming.ShopmeCommon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String listAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("listUser", userList);
        return "users";
    }

    @GetMapping("/users/new")
    public String newUser(Model model) {
        User user = new User();
        List<Role> roleList = userService.getRoles();
        model.addAttribute("user", user);
        model.addAttribute("listRole", roleList);
        return "users_form";
    }

    @PostMapping("/users/save")
    public String saveUser(User user) {
        System.out.println(user);
        return "redirect:/users";
    }
}
