package ormRPGgame.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Pocion")
public class Pocion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CodP", nullable = false)
    private long CodP;

    @Column(name = "RecVida")
    private long RecVida;

    @Column(name = "RecMana")
    private long RecMana;

    // 1-N con Personaje_Recibe_Pocion
    @OneToMany(mappedBy = "pocion")
    private Set<Personaje_Recibe_Pocion> pociones;

    public Pocion(){
    }

    public Pocion(long RecVida, long RecMana){
        this.RecVida = RecVida;
        this.RecMana = RecMana;
    }

    public long getCodigo() {
        return CodP;
    }

    public long getRecVida() {
        return RecVida;
    }

    public long getRecMana() {
        return RecMana;
    }

    public Set<Personaje_Recibe_Pocion> getPocion() {
        return pociones;
    }

}
