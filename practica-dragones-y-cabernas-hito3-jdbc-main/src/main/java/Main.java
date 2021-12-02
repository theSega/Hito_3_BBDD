import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import game.model.Arma;
import game.model.Dragon;

public class Main {
    // @TODO: Sustituya xxxx por los parámetros de su conexión

    private static final String DB_SERVER = "localhost";

    private static final int DB_PORT = 3306;

    private static final String DB_NAME = "hito2";

    private static final String DB_USER = "root";

    private static final String DB_PASS = "root";

    private static Connection conn;


    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://" + DB_SERVER + ":" + DB_PORT + "/" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER, DB_PASS);

        // @TODO pruebe sus funciones
        //Hito3 _ JDBC _ GRUPO 4 _ CI.TSI-T22

        //1.
        nuevo_dragon("Viseryon", "Negro", 200000);

        //2.
        //Nuestros Id de Escuadrones son 14632, 87393, 76391 y 13256;
        int escuadron = 14632;
        List<Dragon> lista1 = squad_derrota_dragones(escuadron);
        Iterator<Dragon> it1 = lista1.iterator();
        System.out.println("Dragones derrotados por el escuadron " + escuadron + ":");
        System.out.println("\tNombreD\t\tVida\tApariencia");
        while (it1.hasNext()) {
            Dragon derrotado = it1.next();
            System.out.println("\t- " + derrotado.getName() +
                    "\t" + derrotado.getLife() +
                    "\t" + derrotado.getAppareance());
        }
        System.out.println();

        //3.
        String forja = "Forja de Tébez";
        List<Arma> lista2 = mostrar_hachas(forja);
        Iterator<Arma> it2 = lista2.iterator();
        System.out.println("Hachas Forjadas en la " + forja + ":");
        System.out.println("\tNombreA\t\t\t\tDaño\tPeso");
        while (it2.hasNext()) {
            Arma hacha = it2.next();
            System.out.println("\t- " + hacha.getName() +
                    "\t" + hacha.getDamage() +
                    "\t" + hacha.getWeight());
        }
        System.out.println();

        //4.
        String guerrero = "Stanto";
        System.out.println("El guerrero " + guerrero + " porta un/una " + espada_porta_guerrero(guerrero));

        conn.close();
    }

    // @TODO resuelva las siguientes funciones...

    public static void nuevo_dragon(String nombre, String apariencia, int vida) throws SQLException {
        // @TODO: complete este método para que cree un nuevo dragón en la base de datos

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //Obtenemos Dragon con más vida
            stmt = conn.prepareStatement("SELECT NombreD FROM dragon WHERE vida = (SELECT Max(vida) from Dragon)");
            rs = stmt.executeQuery();
            rs.next();
            // Insert Nuevo Dragon en Tabla Dragon
            stmt = conn.prepareStatement("INSERT INTO dragon (nombreD, apariencia, vida) VALUES (?,?,?)");
            stmt.setString(1, nombre);
            stmt.setString(2, apariencia);
            stmt.setInt(3, vida);
            stmt.executeUpdate();
            // Insert para hacer que el Nuevo Dragon sea desbloqueado por el Dragon con mas vida, o sea,
            // el ultimo que se desbloqueba anteriormente
            stmt = conn.prepareStatement("INSERT INTO dragon_desbloquea_dragon (nombreD1, nombreD2) VALUES (?, ?)");
            stmt.setString(1, rs.getString("NombreD"));
            stmt.setString(2, nombre);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se ha podido insertar el dragon " + nombre + " en la base de datos");

        }


    }

    public static List<Dragon> squad_derrota_dragones(int id_squad) throws SQLException {
        // @TODO: complete este método para que devuelva una lista de los dragones derrotados por el squad
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto dragon para cada uno de los dragones, y añadirlos a la lista

        List<Dragon> lista = new ArrayList<Dragon>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM dragon WHERE NombreD IN (" +
                    "SELECT NombreD FROM escuadron_derrota_dragon WHERE IdE = " + id_squad + ")");
            while (rs.next()) {
                Dragon dragon = new Dragon(rs.getString("NombreD"),
                        rs.getInt("Vida"),
                        rs.getString("Apariencia"));
                lista.add(dragon);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido obtener una lista de dragones derrotados por el escuadron " + id_squad);
        }
        return lista;
    }


    public static List<Arma> mostrar_hachas(String nombre_forja) throws SQLException {
        // @TODO: complete este método para que muestre por pantalla las hachas que pueden forjarse en "nombre_forja"
        // Tenga en cuenta que la consulta a la base de datos le devolverá un ResultSet sobre el que deberá
        // ir iterando y creando un objeto con cada hacha disponible en esa forja, y añadirlos a la lista

        List<Arma> lista = new ArrayList<Arma>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM arma WHERE Clase = 'Tanque' and NombreA IN (" +
                    "SELECT NombreA FROM forja_crea_arma WHERE NombreF = '" + nombre_forja + "')");
            while (rs.next()) {
                Arma arma = new Arma(rs.getString("NombreA"),
                        rs.getInt("Daño"),
                        rs.getInt("Peso"),
                        rs.getString("Clase"));
                lista.add(arma);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido obtener una lista de hachas forjadas en la " + nombre_forja);
        }
        return lista;
    }


    public static String espada_porta_guerrero(String nombre_guerrero) throws SQLException {
        // @TODO: complete este método para que devuelva el nombre de la espada que porta el guerrero "nombre_guerrero"

        List<Arma> lista = new ArrayList<Arma>();
        Statement query = null;
        ResultSet rs = null;
        try {
            query = conn.createStatement();
            rs = query.executeQuery("SELECT NombreA FROM personaje_compra_arma " +
                    "WHERE NombreP = '" + nombre_guerrero + "' AND Carga = true");
            rs.next();
        } catch (SQLException e) {
            System.out.println("No se ha podido obetener la espada que porta el guerrero " + nombre_guerrero);
        }
        return rs.getString("NombreA");
    }


}
