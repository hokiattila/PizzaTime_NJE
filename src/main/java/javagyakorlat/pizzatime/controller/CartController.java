package javagyakorlat.pizzatime.controller;

import javagyakorlat.pizzatime.model.Cart;
import javagyakorlat.pizzatime.model.Pizza;
import javagyakorlat.pizzatime.services.CartService;
import javagyakorlat.pizzatime.services.OrderService;
import javagyakorlat.pizzatime.services.PizzaService;
import javagyakorlat.pizzatime.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        model.addAttribute("cart", cartService.getCart(session));
        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(HttpSession session, @RequestParam String pizzaNev, @RequestParam int quantity) {
        Pizza pizza = pizzaService.getPizzaByNev(pizzaNev);
        cartService.addToCart(session, pizza, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(HttpSession session, @RequestParam String pizzaNev) {
        cartService.removeFromCart(session, pizzaNev);
        return "redirect:/cart";
    }
    @PostMapping("/order/complete")
    public String completeOrder(HttpSession session, Authentication authentication, Model model) {
        try {
            // Kinyerjük a felhasználónevet (vagy az id-t, ha hozzáadtuk a UserDetails-be)
            org.springframework.security.core.userdetails.User user =
                    (org.springframework.security.core.userdetails.User) authentication.getPrincipal();
            String username = user.getUsername(); // Ezt az adatot felhasználhatod az azonosításhoz

            // A userId lekérése, ha a username alapján dolgozol
            int userId = userService.findUserIdByUsername(username); // Példa metódus

            Cart cart = cartService.getCart(session);
            orderService.saveOrder(cart, userId);
            model.addAttribute("cartItems", cart.getItems());
            cartService.clearCart(session);
            return "order-confirmation";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Rendelés feldolgozása sikertelen!");
            return "index";
        }
    }

}
