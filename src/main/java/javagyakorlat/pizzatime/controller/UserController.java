package javagyakorlat.pizzatime.controller;

import jakarta.validation.Valid;
import javagyakorlat.pizzatime.model.User;
import javagyakorlat.pizzatime.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/post-login")
    public String postLogin(Authentication authentication, jakarta.servlet.http.HttpSession session) {
        session.setAttribute("username", authentication.getName());
        return "redirect:/";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult result, Model model, @RequestParam("confirmPassword") String confirmPassword, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("validationErrors", result.getFieldErrors());
            return "registration";
        }

        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("passwordError", "A jelszavak nem egyeznek!");
            return "registration";
        }

        user.setPermission("user");
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Sikeres regisztráció, mostmár beléphetsz!");

        return "redirect:/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
}
