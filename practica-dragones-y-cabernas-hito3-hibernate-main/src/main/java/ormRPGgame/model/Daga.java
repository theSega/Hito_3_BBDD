package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Daga")
public class Daga {

    @Id
    @Column(name = "TipoD", unique = true, nullable = false, length = 25)
    private String TipoD;

    // 1-N con Personaje
    @OneToMany(mappedBy = "TipoD")
    private Set<Personaje> personaje;

    // N-M con Tienda
    @ManyToMany(mappedBy = "DagasVendidas")
    private Set<Tienda> Tiendas;

    public Daga(String nombre) {
        this.TipoD = nombre;
    }

    public String getNombre() {
        return this.TipoD;
    }

    public Set<Personaje> getPersonajes() {
        return personaje;
    }

    public Set<Tienda> getTiendas(){return Tiendas;}

}
