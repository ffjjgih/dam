package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daohomeimplements;
import Model.Home;

@WebServlet({ 
	"/Homeadmin",
	"/Homeadmin/delete"
})
public class Homeadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daohomeimplements dao;
	private List<Home> lsthome;
	private List<Home> lstbanner;
	private List<Home> lstposter;
	int index,id;
	public Homeadmin() {
		super();
		this.dao = new Daohomeimplements();
		this.lsthome = new ArrayList<Home>();
		this.lstbanner = new ArrayList<Home>();
		this.lstposter = new ArrayList<Home>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showhome(request, response);
		index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idadmin", index);
		request.getRequestDispatcher("/Admin/Homeadmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
	
	private void showhome(HttpServletRequest request, HttpServletResponse response) {
		try {
			this.lsthome = this.dao.gethomeall();
			request.setAttribute("dshome", lsthome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
