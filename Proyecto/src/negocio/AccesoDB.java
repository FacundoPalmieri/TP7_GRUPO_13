package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Aca se programara la logica para conectarse a la DB

public class AccesoDB {

	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user ="root";
    private static String pass = "root";
    private static String dbName = "segurosgroup";

	
	public static Connection getConnection() throws SQLException {
        // Registrar el driver de MySQL
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de MySQL", e);
        }

        // Obtener la conexión
        return DriverManager.getConnection(host + dbName , user , pass);
    }

    /**
     * Cierra una conexión a la base de datos
     * @param connection Conexión a cerrar
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
