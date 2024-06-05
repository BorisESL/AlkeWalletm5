package conexion;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionDb {

    private final static String URL = "jdbc:mysql://localhost:3306/usuarios";
    private static String usuario = "root";
    private static String pass = "conycata2019";
    private static BasicDataSource pool;

    static {
        try {
            // Registrar el controlador MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver MySQL registrado exitosamente.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al registrar el driver MySQL: " + e.getMessage());
            throw new RuntimeException("Error al cargar el driver MySQL", e);
        }
    }

    // Métodos
    public static BasicDataSource obtenerPool() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(URL); // envía URL como ruta de acceso
            pool.setUsername(usuario); // envía usuario de la BD
            pool.setPassword(pass); // envía password usuario BD
            pool.setInitialSize(3); // valor de los parámetros iniciales
            pool.setMinIdle(3); // establece tiempo mínimo de 3 segundos de espera
            pool.setMaxIdle(10); // establece tiempo máximo de 10 segundos de espera
        }
        return pool;
    }

    public static Connection obtenerConexion() throws SQLException {
        System.out.println("Intentando obtener conexión...");
        Connection conn = obtenerPool().getConnection();
        if (conn != null) {
            System.out.println("Conexión obtenida exitosamente.");
        } else {
            System.out.println("No se pudo obtener la conexión.");
        }
        return conn;
    }

    public static void main(String[] args) {
        try (Connection connection = obtenerConexion()) {
            if (connection != null) {
                System.out.println("Conexión exitosa.");
            } else {
                System.out.println("No hay conexión.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
