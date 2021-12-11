package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// @TODO completar las anotaciones de la clase

@Entity
@Table(name = "Personaje")
public class Personaje {

    @Id
    @Column(name = "NombreP", nullable = false, length = 15)
    private String NombreP;

    @Column(name = "Oro", nullable = false)
    private long Oro;

    @Column(name = "Nivel", nullable = false)
    private long Nivel;

    @Column(name = "Fuerza", nullable = false)
    private long Fuerza;

    @Column(name = "Mana", nullable = false)
    private long Mana;

    @Column(name = "Vida", nullable = false)
    private long Vida;

    // 1-N con Daga
    @ManyToOne(optional = false)
    @JoinColumn(name = "TipoD")
    private Daga TipoD;

    // 1-N con Jugador
    @ManyToOne(optional = false)
    @JoinColumn(name = "IdJ")
    private Jugador IdJ;

    // 1-N con Rol
    @ManyToOne(optional = false)
    @JoinColumn(name = "ClaseP")
    private Rol ClaseP;

    // N-M con Escuadron
    @ManyToMany(mappedBy = "PersonajesMiembros")
    private Set<Escuadron> escuadron;

    // N-M con Monstruo
    @ManyToMany()
    @JoinTable(name = "Personaje_Derrota_Monstruo")
    private Set<Monstruo> MonstruosDerrotados;

    public Personaje() {
    }

    public Personaje(String nombre, Rol Clase, long Oro, long Nivel, Daga daga, Jugador jugador) {
        // @TODO completar el constructor de la clase.
        //  Para ello es necesario un string con el nombre del mago y un objeto de la clase daga
        //  Inicialice el resto de atributos a los valores que considere oportunos
        this.NombreP = nombre;
        this.Oro = Oro;
        this.Nivel = Nivel;
        //Fuerza
        if (Nivel <= 80)
            this.Fuerza = Nivel + 10;
        else if (Nivel % 2 == 0 /*Par*/)
            this.Fuerza = 80 + (Nivel / 2);
        else
            this.Fuerza = 80 + (Nivel / 2) - 1;
        //Mana y Vida
        if (Clase.getRol().equals("Mago")) {
            this.Mana = 300L * Nivel;
            this.Vida = 300L * Nivel;
        } else if (Clase.getRol().equals("Guerrero")) {
            this.Mana = 200L * Nivel;
            this.Vida = 500L * Nivel;
        } else if (Clase.getRol().equals("Tanque")) {
            this.Mana = 100L * Nivel;
            this.Vida = 700L * Nivel;
        } else {
            this.Mana = 0;
            this.Vida = 0;
        }
        this.TipoD = daga;
        this.IdJ = jugador;
        this.ClaseP = Clase;
    }

    public String getNombre() {
        return this.NombreP;
    }

    public long getOro() {
        return Oro;
    }

    public long getNivel() {
        return Nivel;
    }

    public long getFuerza() {
        return Fuerza;
    }

    public long getMana() {
        return Mana;
    }

    public long getVida() {
        return Vida;
    }

    public String getDaga() {
        return TipoD.getNombre();
    }

    public long getId() {
        return IdJ.getId();
    }

    public String getRol() {
        return ClaseP.getRol();
    }

    public Set<Escuadron> getEscuadrones() {
        return escuadron;
    }

    public Set<Monstruo> getMonstruosDerrotados() {
        return MonstruosDerrotados;
    }
}
