package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Arma")
public class Arma {

    @Id
    @Column(name = "NombreA", nullable = false, length = 20)
    private String NombreA;

    @Column(name = "Daño", nullable = false)
    private long Daño;

    @Column(name = "Peso", nullable = false)
    private long Peso;

    // 1-N con Rol
    @ManyToOne(optional = false)
    @JoinColumn(name = "ClaseA")
    private Rol ClaseA;

    // N-M con Forja
    @ManyToMany(mappedBy = "ArmasCreadas")
    private Set<Forja> forja;

    // 1-N con Personaje_Compra_Arma
    @OneToMany(mappedBy = "arma")
    private Set<Personaje_Compra_Arma> Compra;

    public Arma() {
    }

    public Arma(String NombreA, Rol Clase, long Daño, long Peso) {
        this.NombreA = NombreA;
        if (Daño < 20)
            Daño = 20;
        this.Daño = Daño;
        if (Peso < 10)
            Peso = 10;
        this.Peso = Peso;
        this.ClaseA = Clase;
        forja = new HashSet<>();
        Compra = new HashSet<>();
    }

    public long getDaño() {
        return this.Daño;
    }

    public long getPeso() {
        return this.Peso;
    }

    public String getNombre() {
        return this.NombreA;
    }

    public String getRol() {
        return this.ClaseA.getRol();
    }

    public Set<Personaje_Compra_Arma> getCompra() {
        return Compra;
    }


}