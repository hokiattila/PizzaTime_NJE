package javagyakorlat.pizzatime.repository;

import javagyakorlat.pizzatime.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
