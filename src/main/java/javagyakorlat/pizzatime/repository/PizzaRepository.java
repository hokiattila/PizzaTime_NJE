package javagyakorlat.pizzatime.repository;

import javagyakorlat.pizzatime.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, String> {
}
