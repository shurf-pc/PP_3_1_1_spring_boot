package web.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    UserService userService;

    public UserController(@Qualifier("useRepository") UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String user(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping(value = "/updateUser", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    @ResponseBody
    public String updateUser(@RequestParam Long id, @RequestParam String name, @RequestParam String email) {
        if (name.isEmpty() || email.isEmpty()) {
            return "success=false";
        }
        if (userService.updateUser(new User(id, name, email))) {
            return "success=true&" + "id=" + id + "&name=" + name + "&email=" + email;
        } else {
            return "success=false";
        }
    }

    @PostMapping(value = "/addUser", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    @ResponseBody
    public String addUser(@RequestParam String name, @RequestParam String email) {
        if (name.isEmpty() || email.isEmpty()) {
            return "success=false";
        }
        Long id = userService.addUser(name, email);
        if (id != -1) {
            return "success=true" + "&id=" + id + "&name=" + name + "&email=" + email;
        } else {
            return "success=false";
        }
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam Long id) {
        if (userService.deleteUser(id)) {
            return "success=true&" + "id=" + id;
        } else {
            return "success=false";
        }
    }
}
