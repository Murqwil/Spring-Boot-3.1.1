package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String getUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "index";
    }

    @GetMapping("/add")
    public String showAddUserForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String showDeleteUserForm() {
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteUsers(@RequestParam int id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String showUpdateUserForm() {
        return "update";
    }

    @PostMapping("/update")
    public String updateUsers(int id, User user) {
        userService.updateUserById(id, user);
        return "redirect:/users";
    }
}

