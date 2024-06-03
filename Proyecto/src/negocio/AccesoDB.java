package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Aca se programara la logica para conectarse a la DB
//Comentar la contrase�a incorrcta para la base de datos

public class AccesoDB {

	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user ="root";
    private static String pass = "root";
<<<<<<< HEAD
    //private static String pass = "ROOT";
=======
//    private static String pass = "ROOT";
>>>>>>> 68c844c888e74fc95e3802e2a5151f460511277a
    private static String dbName = "segurosgroup";
    private static Connection conexion;

	
	public static Connection getConnection() throws SQLException {
        // Registrar el driver de MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontr� el driver de MySQL", e);
        }

        // Obtener la conexi�n
        try {
        	conexion = DriverManager.getConnection(host + dbName , user , pass);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        return conexion;
    }

    /**
     * Cierra una conexi�n a la base de datos
     * @param connection Conexi�n a cerrar
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
