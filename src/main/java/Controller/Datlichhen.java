package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daobookimplement;
import Model.Booking;


@WebServlet("/Datlichhen")
public class Datlichhen extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daobookimplement daobook;
    int index;
    public Datlichhen() {
    	this.daobook=new Daobookimplement();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		index=Integer.parseInt(request.getParameter("index"));
		Booking book=new Booking();
		try {
			book = this.daobook.getappointment(index);
			this.daobook.delete(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/Appointment?index="+index);
	}

}
