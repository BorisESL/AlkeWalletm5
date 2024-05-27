package conexion;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionDb {


    private final static String URL = "jdbc:mysql://localhost:3306/alke_wallet";
    private static  String usuario = "root";
    private static String pass = "conycata2019";
    private static BasicDataSource pool;

    //metodos

    public static BasicDataSource obtenerPool() throws SQLException {

        if (pool==null) {
            pool = new BasicDataSource();
            pool.setUrl(URL); //envia url como ruta de acceso
            pool.setUsername(usuario); //enviar usuario de la BD
            pool.setPassword(pass); //enviar password usuario BD
            pool.setInitialSize(3); //valor de los parametros iniciales
            pool.setMinIdle(3); //establece tiempo minimo de 3 segundos de espera
            pool.setMaxIdle(10); //establece tiempo maximo de 10 segundos de espera



        }
        return pool;
    }

    public static Connection obtenerConexion() throws SQLException {

        return obtenerPool().getConnection(); //retornar conexion
    }

    public static void main(String[] args)  {
        Connection connection = null;
        try {
            connection = obtenerConexion();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection == null) {
            System.out.println("No hay conexion");
        }
        System.out.println("Conexion exitosa");
    }

}
