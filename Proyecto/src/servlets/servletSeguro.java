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
import negocio.SeguroDao;
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
		
		
		
	    String paramValue = request.getParameter("Param");
	    if (paramValue != null && paramValue.equals("2")) {
	        try {
	            SeguroDao Sdao = new SeguroDao();
	            ArrayList<Seguro> ListaSeguros = Sdao.listar();
	            
	            request.setAttribute("ListaS", ListaSeguros);
	            
	            RequestDispatcher rd = request.getRequestDispatcher("ListarSeguros.jsp");
	            rd.forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
			 		 
		
	if(Integer.parseInt(request.getParameter("Param")) == 1)  {
			SeguroDao Sdao = new SeguroDao();
		    ArrayList<TipoSeguro> listaTiposSeguros=new ArrayList<TipoSeguro>();
		    listaTiposSeguros = Sdao.listarTodos();
		    request.setAttribute("ListaTipos", listaTiposSeguros);
		    
		 
		 
		 
		    int idSeguro = Sdao.obtenerProximoIdSeguro();
		    
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
		int filas = 0;
	
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

        SeguroDao sDao = new SeguroDao();
        filas = sDao.insertarSeguro(seguro);
        
     // Obtener el ID del nuevo seguro
        int idSeguro = sDao.obtenerProximoIdSeguro();
        
        ArrayList<TipoSeguro> listaTiposSeguros=new ArrayList<TipoSeguro>();
	    listaTiposSeguros = sDao.listarTodos();
	 

        // Redirigir a la página de agregar seguro
        request.setAttribute("cantFilas", filas);
        request.setAttribute("idSeguro", idSeguro);
        request.setAttribute("ListaTipos", listaTiposSeguros);
        RequestDispatcher rd = request.getRequestDispatcher("AgregarSeguro.jsp");
        rd.forward(request, response);
    }
	

}

  
