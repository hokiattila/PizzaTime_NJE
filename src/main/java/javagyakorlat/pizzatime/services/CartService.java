package javagyakorlat.pizzatime.services;

import javagyakorlat.pizzatime.model.Cart;
import javagyakorlat.pizzatime.model.Pizza;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class CartService {
    private static final String SESSION_CART_KEY = "cart";

    public Cart getCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute(SESSION_CART_KEY);
        if (cart == null) {
            cart = new Cart();
            session.setAttribute(SESSION_CART_KEY, cart);
        }
        return cart;
    }

    public void addToCart(HttpSession session, Pizza pizza, int quantity) {
        Cart cart = getCart(session);
        cart.addItem(pizza, quantity);
    }

    public void removeFromCart(HttpSession session, String pizzaNev) {
        Cart cart = getCart(session);
        cart.removeItem(pizzaNev);
    }

    public void clearCart(HttpSession session) {
        session.setAttribute("cart", new Cart());
    }
}
