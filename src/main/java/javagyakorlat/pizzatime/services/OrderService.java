package javagyakorlat.pizzatime.services;

import jakarta.servlet.http.HttpSession;
import javagyakorlat.pizzatime.model.Cart;
import javagyakorlat.pizzatime.model.CartItem;
import javagyakorlat.pizzatime.model.Orders;
import javagyakorlat.pizzatime.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersRepository orderRepository;

    @Autowired
    private DataSource dataSource;

    public void saveOrder(Cart cart, int userId) {
        String insertOrderSQL = "INSERT INTO Orders (pizzanev, userid, db, felvetel) VALUES (?, ?, ?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertOrderSQL)) {

            System.out.println("Order Save Process Started: " + java.time.LocalDateTime.now());
            System.out.println("User ID: " + userId);
            System.out.println("Cart Items: ");

            for (CartItem item : cart.getItems()) {
                System.out.println("Pizza Name: " + item.getPizza().getNev() + ", Quantity: " + item.getQuantity());

                preparedStatement.setString(1, item.getPizza().getNev());
                preparedStatement.setInt(2, userId);
                preparedStatement.setInt(3, item.getQuantity());
                preparedStatement.setString(4, "2024-12-07 20:07:54");

                preparedStatement.addBatch();
            }

            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println("Inserted orders: " + updateCounts.length);
            System.out.println("Order Save Process Completed: " + java.time.LocalDateTime.now());

        } catch (SQLException e) {
            System.err.println("Error occurred: " + java.time.LocalDateTime.now());
            e.printStackTrace();
            throw new RuntimeException("Failed to save orders to the database.", e);
        }
    }

    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }


    public void clearCart(HttpSession session) {
        session.setAttribute("cart", new Cart());
    }
}



