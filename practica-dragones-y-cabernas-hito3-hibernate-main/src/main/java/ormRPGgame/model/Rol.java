package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rol")
public class Rol {

    private enum Clases {
        Guerrero, Mago, Tanque
    }

    @Id
    @Column(name = "Clase")
    @Enumerated(EnumType.STRING)
    private Clases Clase;

    // 1-N con Personaje
    @OneToMany(mappedBy = "ClaseP")
    private Set<Personaje> personaje;

    // 1-N con Monstruo
    @OneToMany(mappedBy = "ClaseM")
    private Set<Monstruo> monstruo;

    // 1-N con Habilidades
    @OneToMany(mappedBy = "ClaseH")
    private Set<Habilidades> habilidades;

    // 1-N con Arma
    @OneToMany(mappedBy = "ClaseA")
    private Set<Arma> armas;

    public Rol() {
    }

    public Rol(String clase) throws IllegalArgumentException {
        try {
            this.Clase = Clases.valueOf(clase);
            personaje = new HashSet<>();
            monstruo = new HashSet<>();
            habilidades = new HashSet<>();
            armas = new HashSet<>();
        } catch (IllegalArgumentException e) {
            System.out.println("Ese rol no es valido, solo valen: ");
            for (Clases rol : Clases.values())
                System.out.println(rol);
        }
    }

    public String getRol() {
        return this.Clase.toString();
    }

    public Clases getClase(String clase) throws IllegalArgumentException {
        try {
            return Clases.valueOf(clase);
        } catch (IllegalArgumentException ex) {
            System.out.println("El rol " + clase + " no existe");
            return null;
        }
    }

    public Set<Personaje> getPersonajes() {
        return personaje;
    }

    public Set<Monstruo> getMonstruos() {
        return monstruo;
    }

    public Set<Habilidades> getHabilidades() {
        return habilidades;
    }

    public Set<Arma> getArmas() {
        return armas;
    }

}
