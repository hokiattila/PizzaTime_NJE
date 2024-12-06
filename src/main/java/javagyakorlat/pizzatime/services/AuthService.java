package javagyakorlat.pizzatime.services;

import javagyakorlat.pizzatime.model.User;
import javagyakorlat.pizzatime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean authenticate(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Felhasználó nem található"));
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
