package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReporteDAO;
import model.Reporte;

/**
 * Servlet implementation class ServletMovimiento
 */
@WebServlet("/ServletReporte")
public class ServletReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletReporte() {
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
		try {
            reporte(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
	private void reporte(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
		String mes = request.getParameter("mes");
    	String year = request.getParameter("year");
    	
    	Date fecha = new Date();
        if(mes != null && year != null) {
        	fecha.setMonth(Integer.parseInt(mes)-1);
        	fecha.setYear(Integer.parseInt(year)-1900);
        } else {
        	mes = (fecha.getMonth()+1) + "";
        	year = (fecha.getYear()+1900) + "";
        }
		
        List<Reporte> reporte = ReporteDAO.reporte(fecha.getMonth()+1, fecha.getYear()+1900);
        request.setAttribute("reporte", reporte);
        request.setAttribute("mes", mes);
        request.setAttribute("year", year);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/reportes/reporte.jsp");
        dispatcher.forward(request, response);
    }
 
}
