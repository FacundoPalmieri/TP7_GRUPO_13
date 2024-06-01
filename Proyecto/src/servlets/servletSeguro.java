package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.AccesoDB;
import negocio.ListarSeguros;
import negocio.ListarTiposSeguro;
import negocio.Seguro;
import negocio.TipoSeguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servletSeguro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null) {
			ListarTiposSeguro ts = new ListarTiposSeguro();
		    ArrayList<TipoSeguro> listaTiposSeguros=new ArrayList<TipoSeguro>();
		    listaTiposSeguros = ts.listarTodos();
		    request.setAttribute("ListaTipos", listaTiposSeguros);
		    
		    ListarSeguros ls = new ListarSeguros();
		    ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>();
		    listaSeguros=ls.listar();
		    int idSeguro=1;
		    if(listaSeguros.size()>0) {
		    	idSeguro = listaSeguros.get(listaSeguros.size()-1).getId()+1;
		    }
		    request.setAttribute("idSeguro", idSeguro);
		    
		    RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
		    rd.forward(request, response);
		};
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	/*
			String descripcion = request.getParameter("txtDescripcion");
		    String tipoSeguroParam = request.getParameter("tipoSeguro");
		    int idTipo = 1; 
		    

		    if (tipoSeguroParam != null && !tipoSeguroParam.isEmpty()) {
		        idTipo = Integer.parseInt(tipoSeguroParam);
		    }

		    double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
		    double costoAsegurado = Double.parseDouble(request.getParameter("txtCostoMaximo"));

		    TipoSeguro tipoSeguro = new TipoSeguro(idTipo, null);
		    Seguro seguro = new Seguro(0, descripcion, costoContratacion, costoAsegurado, tipoSeguro);

		    boolean exito = agregarSeguro(seguro);
		    if (exito) {
		        response.getWriter().println("El seguro fue agregado exitosamente.");
		    } else {
		        response.getWriter().println("Hubo un problema al agregar el seguro.");
		    }*/
	    }
		
		/*
	    private List<TipoSeguro> obtenerTiposSeguros() {
	        List<TipoSeguro> tiposSeguros = new ArrayList<>();
	        Connection connection = null;
	        PreparedStatement statement = null;
	        ResultSet resultSet = null;

	        try {
	            connection = AccesoDB.getConnection();
	            String sql = "SELECT idTipo, descripcion FROM tipoSeguros";
	            statement = connection.prepareStatement(sql);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                int idTipo = resultSet.getInt("idTipo");
	                String descripcion = resultSet.getString("descripcion");
	                tiposSeguros.add(new TipoSeguro(idTipo, descripcion));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (resultSet != null) {
	                try {
	                    resultSet.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            AccesoDB.closeConnection(connection);
	        }
	        return tiposSeguros;
	    }*/
		
		/*
	    private boolean agregarSeguro(Seguro seguro) {
	        Connection connection = null;
	        PreparedStatement statement = null;

	        try {
	            connection = AccesoDB.getConnection();
	            String sql = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)";
	            statement = connection.prepareStatement(sql);
	            statement.setString(1, seguro.getDescripcion());
	            statement.setInt(2, seguro.getTipoSeguro().getIdTipo());
	            statement.setDouble(3, seguro.getCostoContratacion());
	            statement.setDouble(4, seguro.getCostoMaximoAsegurado());

	            int rowsInserted = statement.executeUpdate();
	            return rowsInserted > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        } finally {
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            AccesoDB.closeConnection(connection);
	        }
	    }*/

}
