package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daouserimplement;
import Model.Gmail;
import Model.User;
import Service.Emailutils;

@WebServlet("/Forgotpassword")
public class Forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User u;
	private Daouserimplement dao;

	public Forgotpassword() {
		this.u = new User();
		this.dao = new Daouserimplement();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/Forgotpassword.jsp").forward(request, response);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		try {
			String mail = request.getParameter("email");
			String user_name = request.getParameter("username");
			u = dao.finduser(mail, user_name);
			if (u != null) {
				Gmail gmail = new Gmail();
				gmail.setFrom("lambcph16980@fpt.edu.vn");
				gmail.setTo(mail);
				gmail.setFrompassword("hunter26");
				StringBuilder builder = new StringBuilder();
				builder.append("Dear").append(u.getFullname()).append("</br>");
				builder.append("Your password is</b>").append(u.getPass()).append("</b>");
				builder.append("regards");
				builder.append("administrator");
				gmail.setContent(builder.toString());
				Emailutils emailUtils = new Emailutils();
				emailUtils.send(gmail);
				response.sendRedirect(request.getContextPath()+"/Login");
			} else {
				response.sendRedirect(request.getContextPath()+"/Forgotpassword?error=1");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
