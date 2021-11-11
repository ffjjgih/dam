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

@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Daouserimplement dao;
       private User u;
       int index;
    public Profile() {
    	this.dao=new Daouserimplement();
    	this.u=new User();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		index=Integer.parseInt(request.getParameter("index"));
		
		this.u=this.dao.findbyid(index);
		request.setAttribute("idcustomer", index);
		request.setAttribute("user", u);
		request.getRequestDispatcher("/Customer/Profile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			if(!request.getParameter("sdt").matches("0[0-9]{9,10}")){
				response.sendRedirect(request.getContextPath() +"/Profile?index="+u.getUserid()+"&&error=2");
			}else {
			BeanUtils.populate(this.u, request.getParameterMap());
			this.dao.changeprofile(this.u);
			response.sendRedirect(request.getContextPath()+"/Profile?index="+u.getUserid());
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
