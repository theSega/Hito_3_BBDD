package ormRPGgame.model;

import com.sun.xml.internal.ws.developer.Serialization;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Monstruo")
public class Monstruo implements Serializable {

    private enum CodMon {
        Goblin, Troll, Espectro
    }

    @Id
    @Column(name = "CodM", nullable = false)
    @Enumerated(EnumType.STRING)
    private CodMon CodM;

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

    public Monstruo(String tipoMonstruo, String Nombre, long Vida, long Oro, Rol clase) throws IllegalArgumentException {
        try {
            this.CodM = CodMon.valueOf(tipoMonstruo);
            this.NombreM = Nombre;
            this.Vida = Vida;
            this.Oro = Oro;
            this.ClaseM = clase;
            personajes = new HashSet<>();
        } catch (IllegalArgumentException e) {
            System.out.println("Ese monstruo no es valido, solo valen: ");
            for (CodMon monstruo : CodMon.values())
                System.out.println(monstruo);
        }
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

    public Set<Personaje> getPersonajes() {
        return personajes;
    }
}
