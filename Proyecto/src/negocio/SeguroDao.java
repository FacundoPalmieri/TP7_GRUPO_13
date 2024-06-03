package negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;

public class SeguroDao {
	private java.sql.Connection conexion;
	//comentar la contraseña incorrecta segun corresponda
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	//private String pass = "root";
	private String pass = "ROOT";
	private String dbName = "segurosgroup";
	
	 public int insertarSeguro(Seguro seguro) {
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		 
			int filas=0;
			Connection cn = null;
			try
			{
				cn = DriverManager.getConnection(host+dbName, user,pass);
				Statement st = cn.createStatement();
				String query = "Insert into seguros (descripcion, idTipo, costoContratacion, costoAsegurado) values ('"+seguro.getDescripcion()+"','"+seguro.getIdTipoSeguro()+"','"+seguro.getCostoContratacion()+"','"+seguro.getCostoMaximoAsegurado()+"')";
				filas = st.executeUpdate(query);
				
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return filas;
		}
		 
		 
		 
		 
		 
	 
	
	
	
	public ArrayList<Seguro> listar(){
		ArrayList<Seguro> lista = new ArrayList<Seguro>();
		try {
			conexion=AccesoDB.getConnection();
			java.sql.Statement st=conexion.createStatement();
			String query = "Select * from seguros";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				Seguro s = new Seguro();
				s.setId(rs.getInt("idSeguro"));
				s.setDescripcion(rs.getString("descripcion"));
				s.setCostoContratacion(rs.getDouble("costoContratacion"));
				s.setCostoMaximoAsegurado(rs.getDouble("costoAsegurado"));
				TipoSeguro ts = new TipoSeguro();
				ts.setIdTipo(rs.getInt("idTipo"));
				s.setIdTipoSeguro(ts.getIdTipo());
				lista.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				AccesoDB.closeConnection(conexion);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return lista;
	}
	
	
	public ArrayList<TipoSeguro> listarTodos(){
		ArrayList<TipoSeguro> tipos=new ArrayList<TipoSeguro>();
		try {
			conexion=AccesoDB.getConnection();
			java.sql.Statement st=conexion.createStatement();
			String query = "Select * from tiposeguros";
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()){
				TipoSeguro ts = new TipoSeguro();
				ts.setIdTipo(rs.getInt("idTipo"));
				ts.setDescripcion(rs.getString("descripcion"));
				tipos.add(ts);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				AccesoDB.closeConnection(conexion);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return tipos;
	}
	
	
	
	

}
