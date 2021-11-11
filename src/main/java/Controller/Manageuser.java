package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daouserimplement;
import Model.User;

@WebServlet({ "/Manageuser", "/Manageuser/edit", "/Manageuser/insert", "/Manageuser/update", "/Manageuser/delete" })
public class Manageuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouserimplement dao;

	public Manageuser() {
		super();
		this.dao = new Daouserimplement();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idadmin", index);
		String url = request.getRequestURL().toString();
		if (url.contains("edit")) {
			edituser(request, response);
		}
		showuser(request, response);
		request.getRequestDispatcher("/Admin/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("insert")) {
			insertuser(request, response);
		} else if (url.contains("update")) {
			updateuser(request, response);
		}
		showuser(request, response);
		request.getRequestDispatcher("/Admin/User.jsp").forward(request, response);
	}

	private void showuser(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<User> lst = this.dao.findadmin();
			request.setAttribute("lstuser", lst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertuser(HttpServletRequest request, HttpServletResponse response) {
		try {
			User u = new User();
			BeanUtils.populate(u, request.getParameterMap());
			u.setRoles("Admin");
			this.dao.create(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void edituser(HttpServletRequest request, HttpServletResponse response) {
		try {
			User u = new User();
			int id = Integer.parseInt(request.getParameter("id"));
			u = this.dao.findbyid(id);
			request.setAttribute("users", u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateuser(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			User u = new User();
			u = this.dao.findbyid(id);
			BeanUtils.populate(u, request.getParameterMap());
			this.dao.update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
