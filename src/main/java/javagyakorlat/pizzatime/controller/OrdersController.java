package javagyakorlat.pizzatime.controller;

import jakarta.servlet.http.HttpSession;
import javagyakorlat.pizzatime.model.Orders;
import javagyakorlat.pizzatime.model.User;
import javagyakorlat.pizzatime.services.OrderService;
import javagyakorlat.pizzatime.services.PizzaService;
import javagyakorlat.pizzatime.services.UserService;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/orders")
    public String ordersPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");


        List<Orders> orders = orderService.getAllOrders();
        for(Orders order : orders)
        {
            order.pizzakep = pizzaService.getPizzaByNev(order.getPizzanev()).getImg();
            order.useremail = userService.findUserEmailById(order.getUserid());
        }
        model.addAttribute("orders", orders);
        model.addAttribute("user", user);
        return "orders";
    }
}
