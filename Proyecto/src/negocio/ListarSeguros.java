package negocio;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ListarSeguros {
	private java.sql.Connection conexion;
	
	public ListarSeguros() {
		
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
}
