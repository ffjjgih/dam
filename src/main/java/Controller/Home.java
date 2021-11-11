package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daohomeimplements;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Daohomeimplements dao;
	private ArrayList<Model.Home> lsthome;
	private ArrayList<Model.Home> lstbanner;
	private ArrayList<Model.Home> lstposter;

	public Home() {
		this.dao = new Daohomeimplements();
		this.lsthome = new ArrayList<Model.Home>();
		this.lstbanner = new ArrayList<Model.Home>();
		this.lstposter = new ArrayList<Model.Home>();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showbanner(request, response);
		showposter(request, response);
		getall(request, response);
		String iduser = request.getParameter("index");
		request.setAttribute("idcustomer", iduser);
		request.getRequestDispatcher("/Customer/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showbanner(HttpServletRequest request, HttpServletResponse response) {
		try {
			this.lsthome = this.dao.gethomeall();
			for (Model.Home x : lsthome) {
				if (x.getTitle() == null) {
					this.lstbanner.add(x);
				}
			}
			request.setAttribute("dsbanner", lstbanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showposter(HttpServletRequest request, HttpServletResponse response) {
		try {
			this.lsthome =this.dao.gethomeall();
			for (Model.Home x : lsthome) {
				if (x.getTitle() != null) {
					this.lstposter.add(x);
				}
			}
			request.setAttribute("dsposter", lstposter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getall(HttpServletRequest request, HttpServletResponse response) {
		this.lsthome =this.dao.gethomeall();
		request.setAttribute("lsthome", this.lsthome);
	}
}
