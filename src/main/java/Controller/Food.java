package Controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daocartimplement;
import Dao.Daofoodimplement;
import Dao.Daohoadon;
import Dao.Daouserimplement;
import Model.User;

@WebServlet({ "/Food", "/Food/Pay", "/Food/Cart" })
public class Food extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daofoodimplement dao;
	private Daouserimplement daouser;
	private Daocartimplement daocart;
	private Daohoadon daopay;
	private Model.Food food;
	private List<Model.Food> lst;

	public Food() {
		this.dao = new Daofoodimplement();
		this.food = new Model.Food();
		this.lst = new ArrayList<Model.Food>();
		this.daouser = new Daouserimplement();
		this.daocart = new Daocartimplement();
		this.daopay=new Daohoadon();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showall(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if (request.getParameter("index") == null) {
			request.setAttribute("idcustomer", null);
		} else {
			int index = Integer.parseInt(request.getParameter("index"));
			String iduser = request.getParameter("index");
			request.setAttribute("idcustomer", iduser);
			String url = request.getRequestURL().toString();
			if (url.contains("Cart")) {
				addcart(request, response, index);
			}
		}

		request.getRequestDispatcher("/Customer/Food.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int indexx = Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idcustomer", indexx);
		if (url.contains("Pay")) {
			payfood(request, response);
			request.setAttribute("idcustomer", indexx);
			response.sendRedirect("http://localhost:8080/finaldam/Pay?index="+indexx);
		} else if (url.contains("Cart")) {
			addcart(request, response, indexx);
			response.sendRedirect("http://localhost:8080/finaldam/Food?index="+indexx);
		}
	}

	private void showall(HttpServletRequest request, HttpServletResponse response) {
		try {
			lst = this.dao.showfood();
			request.setAttribute("lstfood", lst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void payfood(HttpServletRequest request, HttpServletResponse response) {
		Model.Hoadon hoadon = new Model.Hoadon();
		int id = Integer.parseInt(request.getParameter("id"));
		
		hoadon.setSoluong(1);
		LocalDateTime datetime = LocalDateTime.now();
		Timestamp datetimesql = Timestamp.valueOf(datetime);
		hoadon.setThoigian(datetimesql);
		Model.Food f = this.dao.findbyid(id);
		hoadon.setGia(f.getGia());
		hoadon.setFood(f);
		User u=this.daouser.findbyid(Integer.parseInt(request.getParameter("index")));
		hoadon.setUser(u);
		hoadon.setTrangthai("Waiting line");
		try {
			this.daopay.create(hoadon);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void addcart(HttpServletRequest request, HttpServletResponse response, int index) {
		Model.Cart cart = new Model.Cart();
		int id = Integer.parseInt(request.getParameter("id"));
		
		cart.setSoluong(1);
		LocalDateTime datetime = LocalDateTime.now();
		Timestamp datetimesql = Timestamp.valueOf(datetime);
		cart.setThoigiandathang(datetimesql);
		this.food = this.dao.findbyid(id);
		cart.setFood(food);
		cart.setUser(this.daouser.findbyid(index));
		cart.setTrangthai("faverites");
		cart.setGia(food.getGia());
		try {
			BeanUtils.populate(cart, request.getParameterMap());
			daocart.create(cart);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
