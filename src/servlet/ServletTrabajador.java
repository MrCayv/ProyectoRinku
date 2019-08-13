package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrabajadorDAO;
import model.Trabajador;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletTrabajador")
public class ServletTrabajador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTrabajador() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("opcion");
		if(action == null) action="";
        try {
            switch (action) {
            case "new":
                nuevo(request, response);
                break;
            case "insert":
                insertar(request, response);
                break;
            case "delete":
                eliminar(request, response);
                break;
            case "edit":
                editar(request, response);
                break;
            case "update":
                actualizar(request, response);
                break;
            default:
            	listaTrabajadores(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void listaTrabajadores(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Trabajador> listTrabajador = TrabajadorDAO.consultar();
        request.setAttribute("listaTrabajadores", listTrabajador);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/trabajadores/listaTrabajadores.jsp");
        dispatcher.forward(request, response);
    }
 
    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/trabajadores/nuevoTrabajador.jsp");
        dispatcher.forward(request, response);
    }
 
    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Trabajador trabajador = TrabajadorDAO.buscar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/trabajadores/editarTrabajador.jsp");
        request.setAttribute("trabajador", trabajador);
        dispatcher.forward(request, response);
    }
 
    private void insertar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        int rol = Integer.parseInt(request.getParameter("rol"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
 
        Trabajador t = new Trabajador(nombre, rol, tipo, 1, -1, 1);
        TrabajadorDAO.guardar(t);
        response.sendRedirect("./ServletTrabajador");
    }
 
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String nombre = request.getParameter("nombre");
        int rol = Integer.parseInt(request.getParameter("rol"));
        int tipo = Integer.parseInt(request.getParameter("tipo"));
 
        Trabajador t = new Trabajador(nombre, rol, tipo, -1, 1, 1);
        t.setId(id);
        TrabajadorDAO.editar(t);
        response.sendRedirect("./ServletTrabajador");
    }
 
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        TrabajadorDAO.eliminar(id, 1);
        response.sendRedirect("./ServletTrabajador");
 
    }

}
