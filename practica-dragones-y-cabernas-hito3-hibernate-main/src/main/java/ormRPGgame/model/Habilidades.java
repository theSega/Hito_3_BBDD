package ormRPGgame.model;

import javax.persistence.*;
import javax.xml.soap.Text;

@Entity
@Table(name = "Habilidades")
public class Habilidades {

    @Id
    @Column(name = "NombreH", nullable = false, unique = true, length = 20)
    private String NombreH;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String Descripcion;

    // 1-N con Rol
    @ManyToOne(optional = false)
    @JoinColumn(name = "ClaseH")
    private Rol ClaseH;

    public Habilidades() {
    }

    public Habilidades(String Nombre, String Descripcion, Rol Clase) {
        this.NombreH = Nombre;
        this.Descripcion = Descripcion;
        this.ClaseH = Clase;
    }

    public String getNombre() {
        return NombreH;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getRol() {
        return ClaseH.getRol();
    }

}
