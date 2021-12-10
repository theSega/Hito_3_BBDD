package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Monstruo")
public class Monstruo {

    private enum CodM {
        Goblin, Troll, Espectro
    }

    @Id
    @Column(name = "CodM", nullable = false)
    @Enumerated(EnumType.STRING)
    private CodM CodM;

    @Id
    @Column(name = "NombreM", nullable = false, length = 15, unique = true)
    private String NombreM;

    @Column(name = "Vida", nullable = false)
    private long Vida;

    @Column(name = "Oro", nullable = false)
    private long Oro;

    // 1-N con Rol
    @ManyToOne(optional = false)
    @JoinColumn(name = "ClaseM")
    private Rol ClaseM;

    // N-M con Personaje
    @ManyToMany(mappedBy = "MonstruosDerrotados")
    private Set<Personaje> personajes;

    public Monstruo() {

    }

    public String getCodigo() {
        return this.CodM.toString();
    }

    public String getNombre() {
        return this.NombreM;
    }

    public long getVida() {
        return Vida;
    }

    public long getOro() {
        return Oro;
    }

    public String getRol() {
        return ClaseM.toString();
    }
}
