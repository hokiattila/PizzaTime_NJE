package javagyakorlat.pizzatime.controller;

import javagyakorlat.pizzatime.model.ContactForm;
import javagyakorlat.pizzatime.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/uzenet")
    public String listMessages(Model model) {
        // Üzenetek lekérdezése időrendben
        List<ContactForm> messages = messageRepository.findAll();
        messages.sort(null); // Alapértelmezett rendezés használata (Comparable alapján)
        model.addAttribute("messages", messages);
        return "uzenet";
    }
}
