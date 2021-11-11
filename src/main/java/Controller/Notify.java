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
import Model.Booking;
import Model.Hoadon;

@WebServlet({"/Notify",
			 "/Notify/paid",
			 "/Notify/cancel",
			 "/Notify/delete",
			 "/Notify/order"
})
public class Notify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daobookimplement dao;
	private Daohoadon daohd;
	private List<Booking> lst;
	private List<Hoadon> lsthd;
    public Notify() {
    	this.lst=new ArrayList<Booking>();
    	this.dao=new Daobookimplement();
    	this.daohd=new Daohoadon();
    	this.lsthd=new ArrayList<Hoadon>();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.lst=this.dao.getallappointment();
		this.lsthd=this.daohd.getallappointment();
		int index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idadmin", index);
		request.setAttribute("lsthd", this.lsthd);
		request.setAttribute("lstbooking", this.lst);
		
		request.getRequestDispatcher("/Admin/Notify.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		if(url.contains("paid")) {
			update(request, response);
			response.sendRedirect(request.getContextPath()+"/Notify");
		}else if(url.contains("order")) {
			order(request, response);
			response.sendRedirect(request.getContextPath()+"/Notify");
		}
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		this.dao.paid(id);
	}
	private void order(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		this.daohd.paid(id);
	}
}
