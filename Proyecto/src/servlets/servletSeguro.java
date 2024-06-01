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
		 // Recoger datos del formulario
        String descripcion = request.getParameter("txtDescripcion");
        int idTipoSeguro = Integer.parseInt(request.getParameter("tipoSeguro")); 
        double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
        double costoMaximo = Double.parseDouble(request.getParameter("txtCostoMaximo"));

        // Crear objeto Seguro
        Seguro seguro = new Seguro();
        seguro.setDescripcion(descripcion);
        seguro.setCostoContratacion(costoContratacion);
        seguro.setCostoMaximoAsegurado(costoMaximo);
        seguro.setIdTipoSeguro(idTipoSeguro);

        // Insertar seguro en la base de datos
        try {
            insertarSeguro(seguro);
            request.setAttribute("mensaje", "Seguro agregado exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Error al agregar seguro");
        }

        // Redirigir a la página de agregar seguro
        RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
        rd.forward(request, response);
    }

    private void insertarSeguro(Seguro seguro) throws SQLException {
        Connection conexion = null;
        try {
            conexion = AccesoDB.getConnection();
            String query = "INSERT INTO seguros (descripcion, costoContratacion, costoAsegurado, idTipo) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, seguro.getDescripcion());
            ps.setDouble(2, seguro.getCostoContratacion());
            ps.setDouble(3, seguro.getCostoMaximoAsegurado());
            ps.setInt(4, seguro.getIdTipoSeguro());
            ps.executeUpdate();
        } finally {
            AccesoDB.closeConnection(conexion);
        }

		}
	}
