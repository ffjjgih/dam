package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daouserimplement;
import Model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouserimplement dao;
	private User u;

	public Login() {
		super();
		this.u = new User();
		this.dao = new Daouserimplement();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tk = request.getParameter("username");
		String mk = request.getParameter("password");
		u = this.dao.login(tk, mk);
		if(u!=null) {
			if (u.getRoles().trim().equalsIgnoreCase("Customer")) {
				response.sendRedirect(request.getContextPath()+"/Home?index=" + u.getUserid());
			} else {
				response.sendRedirect(request.getContextPath()+"/Homeadmin?index=" + u.getUserid());
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/Login?error=1");
		}
	}

}
