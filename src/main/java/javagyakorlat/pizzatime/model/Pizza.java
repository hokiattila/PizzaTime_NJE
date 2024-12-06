package javagyakorlat.pizzatime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Pizza {

    @Id
    @NotBlank(message = "A pizza neve nem lehet üres!")
    @Size(max = 50, message = "A pizza neve legfeljebb 50 karakter lehet!")
    private String nev;

    @NotBlank(message = "A kép neve nem lehet üres!")
    @Size(max = 50, message = "A kép neve legfeljebb 50 karakter lehet!")
    private String img;

    @NotNull(message = "Az ár megadása kötelező!")
    @Min(value = 1, message = "Az árnak legalább 1 Ft-nak kell lennie!")
    private Integer ar;

    @NotNull(message = "A vegetáriánus mező nem lehet üres!")
    private Boolean vegetarianus;

    // Getters és Setters
    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Boolean getVegetarianus() {
        return vegetarianus;
    }

    public void setVegetarianus(Boolean vegetarianus) {
        this.vegetarianus = vegetarianus;
    }
}
