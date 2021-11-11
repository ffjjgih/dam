package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daouserimplement;
import Model.User;

@WebServlet({
	"/Changepassword",
	"/Changepassword/Change"
})
public class Changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouserimplement dao;
	private User u;
	int index;
    public Changepassword() {
    	this.u=new User();
    	this.dao=new Daouserimplement();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idcustomer", index);
		request.getRequestDispatcher("/Customer/Changepassword.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		String oldpass=request.getParameter("oldpw");
		String newpass=request.getParameter("newpw");
		String confirmpass=request.getParameter("confirmpw");
		this.u=this.dao.findbyid(index);
		if(url.contains("Change")) {
			if(u.getPass().trim().equals(oldpass)) {
				if(newpass.equals(confirmpass)) {
					this.dao.changepw(index,newpass);
					response.sendRedirect(request.getContextPath()+"/Changepassword?index="+index);
				}else {
					response.sendRedirect(request.getContextPath()+"/Changepassword?index="+index+"&&error=1");
				}
			}else {
				response.sendRedirect(request.getContextPath()+"/Changepassword?index="+index+"&&error=2");
			}
		}
	}

}
