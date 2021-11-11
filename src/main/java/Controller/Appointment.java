package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daobookimplement;
import Dao.Daostoreimplement;
import Dao.Daouserimplement;
import Model.Booking;
import Model.User;

@WebServlet({ "/Appointment", "/Appointment/book", "/Appointment/delete" })
public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daobookimplement daobook;
	private Daouserimplement daouser;
	private Booking b;
	private Daostoreimplement daostore;

	public Appointment() {
		super();
		this.daobook = new Daobookimplement();
		this.daouser = new Daouserimplement();
		this.b = new Booking();
		this.daostore = new Daostoreimplement();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("index") == null) {
			request.setAttribute("idcustomer", null);
		} else {
			int index = Integer.parseInt(request.getParameter("index"));
			request.setAttribute("idcustomer", index);
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			request.setAttribute("idcustomer", index);
			check_appointment(request, response, index);
		}
		request.getRequestDispatcher("/Customer/Booking.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int index = Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idcustomer", index);
		if(request.getParameter("ngaydatban").length()==0) {
			response.sendRedirect(request.getContextPath()+"/Appointment?index="+index+"&&error=1");
		}else if(Integer.parseInt(request.getParameter("soluong"))<1) {
			response.sendRedirect(request.getContextPath()+"/Appointment?index="+index+"&&error=2");
		}else {
			make_an_appointment(request, response, index);
		check_appointment(request, response, index);
		response.sendRedirect(request.getContextPath()+"/Appointment?index="+index);
		}
	}

	private void make_an_appointment(HttpServletRequest request, HttpServletResponse response, int index) {
		User u = this.daouser.findbyid(index);
		Booking book = new Booking();
		book.setUser(u);
		book.setStore(this.daostore.findbyid(Integer.parseInt(request.getParameter("address"))));
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setTrangthai("Waiting line");
			this.daobook.create(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void check_appointment(HttpServletRequest request, HttpServletResponse response, int index) {
		this.b = this.daobook.getappointment(index);
		request.setAttribute("lich_hen", b);
	}
}
