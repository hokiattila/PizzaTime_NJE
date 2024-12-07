package javagyakorlat.pizzatime.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(Pizza pizza, int quantity) {
        for (CartItem item : items) {
            if (item.getPizza().getNev().equals(pizza.getNev())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        CartItem newItem = new CartItem();
        newItem.setPizza(pizza);
        newItem.setQuantity(quantity);
        items.add(newItem);
    }

    public void removeItem(String pizzaNev) {
        items.removeIf(item -> item.getPizza().getNev().equals(pizzaNev));
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }
}
