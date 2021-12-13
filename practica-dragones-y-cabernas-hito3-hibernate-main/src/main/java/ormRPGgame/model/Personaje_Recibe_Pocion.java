package ormRPGgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Personaje_Recibe_Pocion")
public class Personaje_Recibe_Pocion {

    @Id
    @Column(name = "placeholder")
    private long Placeholder;

    public Personaje_Recibe_Pocion() {
    }
}
