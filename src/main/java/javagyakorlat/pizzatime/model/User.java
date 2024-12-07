package javagyakorlat.pizzatime.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "A felhasználónév nem lehet üres!")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "A név nem lehet üres!")
    @Pattern(regexp = "^[a-zA-ZáéíóöőúüűÁÉÍÓÖŐÚÜŰ ]+$", message = "A név csak betűket tartalmazhat!")
    private String name;

    @Column(nullable = false, unique = true)
    @Email(message = "Érvényes email címet adjon meg!")
    @NotBlank(message = "Az email cím nem lehet üres!")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "A jelszó nem lehet üres!")
    @Size(min = 6, message = "A jelszónak legalább 6 karakter hosszúnak kell lennie!")
    private String password;

    @Column(nullable = false)
    private String permission;

    @Column(nullable = false)
    @NotBlank(message = "A cím nem lehet üres!")
    private String address;

    @Column(nullable = false)
    @NotBlank(message = "A város nem lehet üres!")
    private String city;

    @Column(nullable = false, length = 12)
    @NotBlank(message = "Az irányítószám nem lehet üres!")
    @Pattern(regexp = "\\d{4,12}", message = "Az irányítószámnak csak számokat tartalmazhat, és 4-12 karakter hosszúnak kell lennie!")
    private String zip;

    @Column(nullable = false, length = 18)
    @Pattern(regexp = "\\d{6,15}", message = "A telefonszám csak számokat tartalmazhat, és 6-15 karakter hosszúnak kell lennie!")
    private String phone;

    public @Pattern(regexp = "\\d{6,15}", message = "A telefonszám csak számokat tartalmazhat, és 6-15 karakter hosszúnak kell lennie!") String getPhone() {
        return phone;
    }

    public void setPhone(@Pattern(regexp = "\\d{6,15}", message = "A telefonszám csak számokat tartalmazhat, és 6-15 karakter hosszúnak kell lennie!") String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String username, String name, String email, String password, String permission, String address, String city, String zip, String phone) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.permission = permission;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    public User() {

    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
