package ormRPGgame.model;

import javax.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {

    private enum Clase {
        Guerrero, Mago, Tanque
    }

    @Id
    @Column(name = "clase")
    @Enumerated(EnumType.STRING)
    private Clase clase;


    public Rol(String clase) throws IllegalArgumentException {
        try {
            this.clase = Clase.valueOf(clase);
        } catch (IllegalArgumentException e) {
            System.out.println("Ese rol no es valido, solo valen: ");
            System.out.println(" Guerrero\nTanque\nMago");
        }
    }

    public String getRol() {
        return this.clase.toString();
    }


}
