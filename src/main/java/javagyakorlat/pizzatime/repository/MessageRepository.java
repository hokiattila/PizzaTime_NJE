package javagyakorlat.pizzatime.repository;

import javagyakorlat.pizzatime.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<ContactForm, Integer> {

}
