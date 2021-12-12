package ormRPGgame.model;

import javax.persistence.*;

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

}
