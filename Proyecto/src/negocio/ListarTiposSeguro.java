package negocio;

import java.sql.ResultSet;
import java.util.ArrayList;


public class ListarTiposSeguro {
	private java.sql.Connection conexion;
	
	public ListarTiposSeguro(){
		
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
