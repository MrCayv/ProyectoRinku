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

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
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
                listaUsuarios(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void listaUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Usuario> listUsuario = UsuarioDAO.consultar();
        request.setAttribute("listaUsuarios", listUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuarios/listaUsuarios.jsp");
        dispatcher.forward(request, response);
    }
 
    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuarios/nuevoUsuario.jsp");
        dispatcher.forward(request, response);
    }
 
    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = UsuarioDAO.buscar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/usuarios/editarUsuario.jsp");
        request.setAttribute("usuario", usuario);
        dispatcher.forward(request, response);
 
    }
 
    private void insertar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
 
        Usuario u = new Usuario(usuario, password, nombre, 1, -1, 1);
        UsuarioDAO.guardar(u);
        response.sendRedirect("./ServletUsuario");
    }
 
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
 
        Usuario u = new Usuario(usuario, "", nombre, -1, 1, 1);
        u.setId(id);
        UsuarioDAO.editar(u);
        response.sendRedirect("./ServletUsuario");
    }
 
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        UsuarioDAO.eliminar(id, 1);
        response.sendRedirect("./ServletUsuario");
 
    }

}
