package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daobookimplement;
import Dao.Daohoadon;
import Dao.Daouserimplement;
import Model.Booking;
import Model.Hoadon;
import Model.User;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daobookimplement daobook;
	private Daohoadon daohd;
	private List<Hoadon> lsthd;
	private List<Booking> lstbook;
	private Daouserimplement daouser;
	private User u;
    public History() {
    	this.daohd=new Daohoadon();
    	this.daobook=new Daobookimplement();
    	this.lstbook=new ArrayList<Booking>();
    	this.lsthd=new ArrayList<Hoadon>();
    	this.u=new User();
    	this.daouser=new Daouserimplement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idcustomer", index);
		this.u=this.daouser.findbyid(index);
		this.lstbook=this.daobook.findbyuser(u);
		this.lsthd=this.daohd.findbyuser(u);
		request.setAttribute("lst", this.lstbook);
		request.setAttribute("lsthd", this.lsthd);
		request.getRequestDispatcher("/Customer/History.jsp").forward(request, response);
		
	}

}
