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

import Dao.Daocartimplement;
import Dao.Daohoadon;
import Dao.Daouserimplement;
import Model.Hoadon;
import Model.User;

@WebServlet({ "/Cart",
	"/Cart/delete",
	"/Cart/pay" 	
})
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daocartimplement daocart;
	private Daouserimplement daouser;
	private Daohoadon daohd;
	private List<Model.Cart> lstcart;
	private User u;

	public Cart() {
		super();
		this.daocart = new Daocartimplement();
		this.daouser = new Daouserimplement();
		this.lstcart = new ArrayList<Model.Cart>();
		this.u = new User();
		this.daohd=new Daohoadon();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request.getParameter("index") == null) {
			request.setAttribute("idcustomer", null);
		} else {
			int indexxx = Integer.parseInt(request.getParameter("index"));
			request.setAttribute("idcustomer", indexxx);
			getallprice(request, response, indexxx);
			getcart(request, response, indexxx);
			getinforuser(request, response, indexxx);
			
		}
		request.getRequestDispatcher("/Customer/Cart.jsp").forward(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		int indexxx = Integer.parseInt(request.getParameter("index"));
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if(url.contains("pay")) {
		try {
			paycart(request, response, indexxx);
			response.sendRedirect(request.getContextPath()+"/Pay?index="+indexxx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	private void getcart(HttpServletRequest request, HttpServletResponse response, int indexx) {
		this.lstcart = this.daocart.showcartbyid(indexx);
		request.setAttribute("dsgiohang", lstcart);

	}

	private void getallprice(HttpServletRequest request, HttpServletResponse response, int indexx) {
		this.lstcart = this.daocart.showcartbyid(indexx);
		double tongtien = 0;
		for(Model.Cart x:lstcart) {
			tongtien+=x.getGia();
		}
		request.setAttribute("tongcong", tongtien);
	}

	private void getinforuser(HttpServletRequest request, HttpServletResponse response, int indexx) {
		this.u = this.daouser.findbyid(indexx);
		request.setAttribute("nguoidung", u);
	}
	
	private void paycart(HttpServletRequest request, HttpServletResponse response, int indexx) throws Exception {
		LocalDateTime datetime = LocalDateTime.now();
		Timestamp datetimesql = Timestamp.valueOf(datetime);
		for(Model.Cart x:lstcart) {
			Hoadon h=new Hoadon();
			h.setUser(x.getUser());
			h.setFood(x.getFood());
			h.setTrangthai("waiting line");
			h.setGia(x.getFood().getGia());
			h.setSoluong(1);
			h.setThoigian(datetimesql);
			this.daocart.delete(x);
			this.daohd.create(h);
		}
		
	}
}
