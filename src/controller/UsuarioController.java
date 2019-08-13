package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch(opcion) {
			case "crear":
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crearUsuario.jsp");
				requestDispatcher.forward(request, response);
				break;
			case "listar":
				//RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/consultarUsuarios.jsp");
				break;
			default:
				System.out.println("default");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		Usuario usuario = new Usuario(
				request.getParameter("usuario"),
				request.getParameter("pass"),
				request.getParameter("nombre"),
				1,
				-1,
				1
		);
	}

}
