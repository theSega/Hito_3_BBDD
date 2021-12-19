package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dragon")
public class Dragon {

    @Id
    @Column(name = "NombreD", unique = true, nullable = false, length = 25)
    private String NombreD;

    @Column(name = "Apariencia", nullable = false, length = 10)
    private String Apariencia;

    @Column(name = "Vida", nullable = false)
    private long Vida;

    // N-M con Escuadron
    @ManyToMany(mappedBy = "DragonesDerrotados")
    private Set<Escuadron> escuadrones;

    // N-M con Dragon
    @ManyToMany()
    @JoinTable(name = "Dragon_Desbloquea_Dragon")
    private Set<Dragon> DesbloqueaDragones;

    public Dragon() {
    }

    public Dragon(String Nombre, String Apariencia, long Vida) {
        this.NombreD = Nombre;
        this.Apariencia = Apariencia;
        this.Vida = Vida;
        escuadrones = new HashSet<>();
        DesbloqueaDragones = new HashSet<>();
    }

    public String getNombre() {
        return NombreD;
    }

    public String getApariencia() {
        return Apariencia;
    }

    public long getVida() {
        return Vida;
    }

    public Set<Escuadron> getEscuadrones() {
        return escuadrones;
    }

    public Set<Dragon> getDragonesDesbloqueables() {
        return DesbloqueaDragones;
    }
}
