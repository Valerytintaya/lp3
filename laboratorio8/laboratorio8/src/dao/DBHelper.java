package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final String URL = "jdbc:sqlite:alquilerdeautos.db";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL);
                System.out.println("Conectado a la base de datos correctamente.");
            }
        } catch (SQLException e) {
            System.err.println(" Error al conectar con la base de datos: " + e.getMessage());
        }
        return connection;
    }
}
