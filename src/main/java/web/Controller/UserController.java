package web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.models.User;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printAllUsers(ModelMap model) {
        model.addAttribute("list", userService.getListUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") long id, Model model){
        model.addAttribute("user",userService.get(id));
        return "user";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "creater";
    }

    @PostMapping()
    public String creat(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.get(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id){
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/users";
    }





}