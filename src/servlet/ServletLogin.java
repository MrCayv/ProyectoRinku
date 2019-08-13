package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
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
		// Establecer el tipo de contenido a mostrar
		response.setContentType("text/html");
		
		// Recuperación de los valores
		String usuario = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		
		// Setear un parametro en session
		// Recuperar el objeto HttpSession
		HttpSession sesion = request.getSession();
		sesion.setAttribute("empresa", "Rinku");
		
		if(!usuario.equals("") && !pass.equals("") && !usuario.equals("joel")) {
			// Recuperar el escritor
			PrintWriter escritor = response.getWriter();
			
			// Generar el contenido dinamico 
			escritor.println("<html><body><h3>Bienvenidos</h3>" +
					"<br> Sistema Rinku</body></html>");
			
			escritor.close();
			sesion.setAttribute("usuario", "cesar");
		} else if(usuario.equals("joel")) {
			response.sendRedirect("ServletError?codigoError=105");
		} else {
			response.sendRedirect("ServletError?codigoError=104");
		}
		
		// Cerrar sesion
		//sesion.invalidate();
	}

}
