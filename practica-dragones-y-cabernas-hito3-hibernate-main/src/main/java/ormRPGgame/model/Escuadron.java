package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Escuadron")
public class Escuadron {

    @Id
    @Column(name = "IdE")
    private long IdE;

    // N-M con Personaje
    @ManyToMany()
    @JoinTable(name = "Personaje_Entra_Escuadron")
    private Set<Personaje> PersonajesMiembros;

    // N-M con Dragon
    @ManyToMany()
    @JoinTable(name = "Escuadron_Derrota_Dragon")
    private Set<Dragon> DragonesDerrotados;

    public Escuadron() {
    }

    public Escuadron(long Id){
        this.IdE = Id;
        this.PersonajesMiembros =  new HashSet<>();
        DragonesDerrotados = new HashSet<>();
    }

    public long getId(){
        return IdE;
    }

    public Set<Personaje> getMiembros() {
        return PersonajesMiembros;
    }

    public Set<Dragon> getDragonesDerrotados() {
        return DragonesDerrotados;
    }


}
