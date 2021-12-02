package ormRPGgame.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// @TODO completar las anotaciones de la clase
public class Daga {
    // @TODO completar las anotaciones de todos los atributos
    @Id
    @Column (name = "TipoD", unique = true, nullable = false)
    private String TipoD;

    public Daga(String nombre) {
        // @TODO completar el constructor de la clase.
        this.TipoD = nombre;
    }

    public String getnombre() {
        return this.TipoD;
    }
}
