package ormRPGgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ciudad")
public class Ciudad {

    @Id
    @Column(name = "NombreC")
    private String NombreC;

    public Ciudad() {
    }

    public String getNombre() {
        return NombreC;
    }
}
