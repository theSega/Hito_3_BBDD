package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

    @Id
    @Column(name = "NombreC")
    private String NombreC;

    // N-M con Tienda
    @ManyToMany()
    @JoinTable(name = "Tienda_Se_Ubica_Ciudad")
    private Set<Tienda> MisTiendas;

    // 1-N con Forja
    @OneToMany(mappedBy = "NombreC")
    private Set<Forja> MisForjas;

    public Ciudad() {
    }

    public Ciudad(String Nombre) {
        this.NombreC = Nombre;
        MisTiendas = new HashSet<>();
        MisForjas = new HashSet<>();
    }

    public String getNombre() {
        return NombreC;
    }

    public Set<Tienda> getMisTiendas() {
        return MisTiendas;
    }

    public Set<Forja> getMisForjas() {
        return MisForjas;
    }
}
