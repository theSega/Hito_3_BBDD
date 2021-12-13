package ormRPGgame.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Tienda")
public class Tienda {

    @Id
    @Column(name = "NombreT")
    private String NombreT;

    // N-M con Daga
    @ManyToMany()
    @JoinTable(name="Tienda_Vende_Daga")
    private Set<Daga> DagasVendidas;

    public Tienda() {
    }

    public Tienda(String Nombre) {
        this.NombreT = Nombre;
    }

    public String getNombre() {
        return NombreT;
    }

    public Set<Daga> getDagas() {
        return DagasVendidas;
    }


}
