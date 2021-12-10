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

    // 1-N con Personaje
    @OneToMany(mappedBy = "ClaseP")
    private Set<Personaje> personaje;

    // 1-N con Monstruo
    @OneToMany(mappedBy = "ClaseM")
    private Set<Monstruo> monstruo;

    // 1-N con Habilidades
    @OneToMany(mappedBy = "ClaseH")
    private Set<Habilidades> habilidades;

    public Rol() {
    }

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
