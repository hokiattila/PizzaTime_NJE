package javagyakorlat.pizzatime.services;

import javagyakorlat.pizzatime.model.Pizza;
import javagyakorlat.pizzatime.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza getPizzaByNev(String nev) {
        return pizzaRepository.findById(nev).orElseThrow(() -> new IllegalArgumentException("Pizza not found: " + nev));
    }
}
