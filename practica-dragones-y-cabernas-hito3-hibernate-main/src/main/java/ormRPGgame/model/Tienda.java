package ormRPGgame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tienda")
public class Tienda {

    @Id
    @Column(name = "NombreT")
    private String NombreT;

    public Tienda() {
    }
}
