package javagyakorlat.pizzatime.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int az;

    @Column(nullable = false)
    private String pizzanev;

    @Column(nullable = false)
    private int userid;

    @Column(nullable = false)
    private int db;

    @Column(nullable = false)
    private LocalDateTime felvetel;

    private LocalDateTime kiszallitas;

    // Getters és Setters
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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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
}
