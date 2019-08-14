package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovimientoDAO;
import dao.TrabajadorDAO;
import model.Movimiento;
import model.Trabajador;
import utilidades.Fechas;

/**
 * Servlet implementation class ServletMovimiento
 */
@WebServlet("/ServletMovimiento")
public class ServletMovimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMovimiento() {
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
            case "show":
                ver(request, response);
                break;
            default:
            	listaMovimientos(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void listaMovimientos(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Movimiento> listMovimiento = MovimientoDAO.consultar();
        request.setAttribute("listaMovimientos", listMovimiento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/movimientos/listaMovimientos.jsp");
        dispatcher.forward(request, response);
    }
 
    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
        Trabajador trabajador = TrabajadorDAO.buscar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/movimientos/nuevoMovimiento.jsp");
        request.setAttribute("trabajador", trabajador);
        dispatcher.forward(request, response);
    }
 
    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movimiento movimiento = MovimientoDAO.buscar(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/movimientos/editarMovimiento.jsp");
        request.setAttribute("movimiento", movimiento);
        dispatcher.forward(request, response);
    }
 
    private void insertar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        Date fecha = Fechas.stringToDateSql(request.getParameter("fecha"));
        int cant_entregas = Integer.parseInt(request.getParameter("cant_entregas"));
        int cubrio_turno = request.getParameter("cubrio_turno")==null?0:1;
 
        Movimiento m = new Movimiento(id_empleado, fecha, cant_entregas, cubrio_turno, 1, -1, 1);
        MovimientoDAO.guardar(m);
        response.sendRedirect("./ServletMovimiento");
    }
 
    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        Date fecha = null;
        int cant_entregas = Integer.parseInt(request.getParameter("cant_entregas"));
        int cubrio_turno = Integer.parseInt(request.getParameter("cubrio_turno"));
 
        Movimiento m = new Movimiento(id_empleado, fecha, cant_entregas, cubrio_turno, 1, -1, 1);
        m.setId(id);
        MovimientoDAO.editar(m);
        response.sendRedirect("./ServletMovimiento");
    }
 
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        MovimientoDAO.eliminar(id, 1);
        response.sendRedirect("./ServletMovimiento");
    }
    
    private void ver(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movimiento movimiento = MovimientoDAO.buscar(id);
        Trabajador trabajador = TrabajadorDAO.buscar(movimiento.getId_empleado());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/movimientos/verMovimiento.jsp");
        request.setAttribute("movimiento", movimiento);
        request.setAttribute("trabajador", trabajador);
        dispatcher.forward(request, response);
    }

}
