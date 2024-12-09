package javagyakorlat.pizzatime.controller;

import javagyakorlat.pizzatime.model.ContactForm;
import javagyakorlat.pizzatime.model.User;
import javagyakorlat.pizzatime.repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class KapcsolatController {

    @Autowired
    private ContactFormRepository contactFormRepository;

    // Kapcsolat oldal megjelenítése
    @GetMapping("/kapcsolat")
    public String showContactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "kapcsolat";
    }

    // Kapcsolat form feldolgozása
    @PostMapping("/kapcsolat")
    public String submitContactForm(@ModelAttribute ContactForm contactForm) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // A bejelentkezett felhasználó neve

        if (!"anonymousUser".equals(username)) {
            contactForm.setUsername(username);
        } else {
            contactForm.setUsername("Vendég");
        }

        contactForm.setDate(LocalDateTime.now());
        contactFormRepository.save(contactForm);
        return "redirect:/kapcsolat?success";
    }
}
