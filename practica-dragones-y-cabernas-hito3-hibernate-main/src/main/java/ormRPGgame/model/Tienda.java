package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tienda")
public class Tienda {

    @Id
    @Column(name = "NombreT")
    private String NombreT;

    // N-M con Daga
    @ManyToMany()
    @JoinTable(name = "Tienda_Vende_Daga")
    private Set<Daga> DagasVendidas;


    // N-M con Ciudad
    @ManyToMany(mappedBy = "MisTiendas")
    private Set<Ciudad> Ciudades;

    public Tienda() {
    }

    public Tienda(String Nombre) {
        this.NombreT = Nombre;
        DagasVendidas = new HashSet<>();
        Ciudades = new HashSet<>();
    }

    public String getNombre() {
        return NombreT;
    }

    public Set<Daga> getDagas() {
        return DagasVendidas;
    }

    public Set<Ciudad> getCiudades() {
        return Ciudades;
    }

}
