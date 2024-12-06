package javagyakorlat.pizzatime.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int az; // Azonosító

    @Column(name = "pizzanev", nullable = false)
    @NotBlank(message = "A pizza neve nem lehet üres")
    @Size(max = 50, message = "A pizza neve legfeljebb 50 karakter hosszú lehet")
    private String pizzanev;

    @Column(name = "db", nullable = false)
    @Min(value = 1, message = "Legalább 1 pizzát kell rendelni")
    @Max(value = 100, message = "Egyszerre legfeljebb 100 pizzát rendelhet")
    private int db;

    @Column(name = "felvetel", nullable = false)
    @NotNull(message = "A rendelés felvételi ideje nem lehet üres")
    private LocalDateTime felvetel;

    @Column(name = "kiszallitas")
    private LocalDateTime kiszallitas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    @NotNull(message = "A rendeléshez tartoznia kell egy felhasználónak")
    private User user; // Kapcsolat a User entitással

    public int getAz() {
        return az;
    }

    public void setAz(int az) {
        this.az = az;
    }

    public String getPizzanev() {
        return pizzanev;
    }

    public void setPizzanev(String pizzanev) {
        this.pizzanev = pizzanev;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public LocalDateTime getFelvetel() {
        return felvetel;
    }

    public void setFelvetel(LocalDateTime felvetel) {
        this.felvetel = felvetel;
    }

    public LocalDateTime getKiszallitas() {
        return kiszallitas;
    }

    public void setKiszallitas(LocalDateTime kiszallitas) {
        this.kiszallitas = kiszallitas;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
