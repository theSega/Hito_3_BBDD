package ormRPGgame.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Rol")
public class Rol {

    private enum Clase {
        Guerrero, Mago, Tanque
    }

    @Id
    @Column(name = "Clase")
    @Enumerated(EnumType.STRING)
    @OneToMany(mappedBy = "Clase")
    private Clase Clase;

    //1-N con Personaje
    @OneToMany(mappedBy = "Clase")
    private Set<Personaje> personaje;


    public Rol(String clase) throws IllegalArgumentException {
        try {
            this.Clase = Clase.valueOf(clase);
        } catch (IllegalArgumentException e) {
            System.out.println("Ese rol no es valido, solo valen: ");
            System.out.println(" Guerrero\nTanque\nMago");
        }
    }

    public String getRol() {
        return this.Clase.toString();
    }


}
