package javagyakorlat.pizzatime.model;

public class CartItem {
    private Pizza pizza;
    private int quantity;

    // Getters és Setters
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return pizza.getAr() * quantity;
    }
}
