package javagyakorlat.pizzatime.repository;

import javagyakorlat.pizzatime.model.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends JpaRepository<ContactForm, Integer> {
}
