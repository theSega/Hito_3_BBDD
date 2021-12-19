package ormRPGgame;

import ormRPGgame.model.Jugador;
import ormRPGgame.model.Personaje;
import ormRPGgame.model.Daga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ormRPGgame.model.Rol;

import javax.management.relation.Role;
import java.sql.*;


/**
 * Controlador de la aplicación. Por favor, revise detenidamente la clase y complete las partes omitidas
 * atendiendo a los comentarios indicados mediante @TODO
 */
public class Controller {

    private Session session;

    /**
     * Crea un nuevo controlador
     */
    public Controller() {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        SessionFactory sessionFactory = new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();

        this.session = sessionFactory.openSession();
    }

    /**
     * Crea un nuevo mago
     * param nickname nombre de usuario
     *
     * @return el nuevo usuario creado
     * @throws SQLException
     */

    public Daga createDaga(String nombre) throws SQLException {
        // @TODO complete este metodo para crear de forma presistente una daga
        session.beginTransaction();
        Daga daga = new Daga(nombre);
        session.save(daga);
        session.getTransaction().commit();
        return daga;
    }

    public Personaje createMago(String magician, Daga daga, Jugador jugador, long oro, long nivel) throws SQLException {
        // @TODO complete este metodo para crear de forma presistente un mago
        Rol clase = createRol("Mago");
        session.beginTransaction();
        Personaje mago = new Personaje(magician, clase, oro, nivel, daga, jugador);
        session.save(mago);
        session.getTransaction().commit();
        jugador.getPersonajes().add(mago);
        return mago;
    }

    public Jugador createJugador(String nombre) throws SQLException {
        Jugador jugador = new Jugador(nombre);
        session.beginTransaction();
        session.save(jugador);
        session.getTransaction().commit();
        return jugador;
    }

    public Rol createRol(String clase) {
        Rol rol = new Rol();
        //Comprueba si la clase es valida
        if (rol.getClase(clase) != null) {
            //Comprueba si la clase ya existe en la base, si es asi la devuelve para su uso, si no, devuelve NULL
            rol = session.get(Rol.class, rol.getClase(clase));
            if (rol == null) {
                //Si es NULL y por ende no existe en la BBDD, se crea la clase
                rol = new Rol(clase);
                session.beginTransaction();
                session.save(rol);
                session.getTransaction().commit();
            }
        }
        return rol;
    }

}
