package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daouserimplement;
import Model.User;

@WebServlet({ "/Registration", "/Registration/login" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouserimplement daousers;
	private User u;

	public Registration() {
		super();
		this.daousers = new Daouserimplement();
		this.u = new User();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		request.getRequestDispatcher("/Customer/Registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		if (url.contains("login")) {
				createuser(request, response);
			
		}
		
	}

	private void createuser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		User user=new User();
			try {
				this.u.setRoles("Customer");
				BeanUtils.populate(u, request.getParameterMap());
				user=this.daousers.checkuser(u.getUsername());
					if(user==null){
						this.daousers.create(u);
						response.sendRedirect(request.getContextPath()+ "/Login");
					}else {
						response.sendRedirect(request.getContextPath()+"/Registration?error=1");
					}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
	}

}
