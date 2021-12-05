package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Jugador")
public class Jugador {

    @Column(name = "NombreJ", nullable = false, length = 20)
    private String NombreJ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdJ")
    private long IdJ;
    //1-N con Personaje
    @OneToMany(mappedBy = "IdJ")
    private Set<Personaje> personaje;

    public String getNombre() {
        return NombreJ;
    }

    public long getId() {
        return IdJ;
    }
}
