package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daohomeimplements;

/**
 * Servlet implementation class DeleteHome
 */
@WebServlet("/DeleteHome")
public class DeleteHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daohomeimplements dao;
    public DeleteHome() {
    	this.dao=new Daohomeimplements();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index=Integer.parseInt(request.getParameter("index"));
			try {
				int id=Integer.parseInt(request.getParameter("id"));
				this.dao.deletehome(id);
				response.sendRedirect(request.getContextPath()+"/Homeadmin?index="+index);
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect(request.getContextPath()+"/Homeadmin?index="+index);
			}	
		
	}

}
