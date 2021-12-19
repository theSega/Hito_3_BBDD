import ormRPGgame.Controller;
import ormRPGgame.model.Jugador;
import ormRPGgame.model.Personaje;
import ormRPGgame.model.Daga;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {

        try {
            Controller controlador = new Controller();
            //@TODO añada las llamadas a las funciones de la clase Controller.java necesarias
            //para la creación de la daga y el mago.
            Daga daga = controlador.createDaga("Daga de Madera");
            Jugador jugador = controlador.createJugador("TheLegend27");
            Personaje mago = controlador.createMago("Magin", daga, jugador, 0, 1);

            if (daga != null && mago != null)
                System.out.println("Se ha creado el mago " + mago.getNombre() + " de nivel 1 con la daga " + daga.getNombre());

        } catch (SQLException e) {
            System.err.println("Se ha producido un error en la conexión con la base de datos");
            e.printStackTrace();
        }
    }

}
