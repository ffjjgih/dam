package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daobookimplement;
import Dao.Daofoodimplement;
import Dao.Daohoadon;
import Dao.Daouserimplement;
import Model.Food;
import Model.User;

@WebServlet({
	"/Deletenotify",
	"/Deletenotify/book",
	"/Deletenotify/hoadon",
	"/Deletenotify/food",
	"/Deletenotify/user"
})
public class Deletenotify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daohoadon daohd;
	private Daobookimplement dao;
	private Food food;
	private Daofoodimplement daofood;
	private Daouserimplement daouser;
    public Deletenotify() {
    	this.daohd=new Daohoadon();
    	this.dao=new Daobookimplement();
    	this.food=new Food();
    	this.daofood=new Daofoodimplement();
    	this.daouser=new Daouserimplement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		int id=Integer.parseInt(request.getParameter("id"));
		int index=Integer.parseInt(request.getParameter("index"));
		if(url.contains("hoadon")) {
			
			this.daohd.cancel(id);
			response.sendRedirect(request.getContextPath()+"/Notify?index="+index);
		}else if(url.contains("book")) {
			this.dao.cancel(id);
			response.sendRedirect(request.getContextPath()+"/Notify?index="+index);
		}else if(url.contains("food")) {
			food=this.daofood.findbyid(id);
			this.daofood.delete(food);
			response.sendRedirect(request.getContextPath()+"/Managefood?index="+index);
		}else if(url.contains("user")) {
			User u = new User();
			u=this.daouser.findbyid(id);
			this.daouser.delete(u);
			response.sendRedirect(request.getContextPath()+"/Manageuser?index="+index);
		}
	}

}
