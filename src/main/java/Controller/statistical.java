package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daobookimplement;
import Dao.Daohoadon;
import Model.Booking;
import Model.Hoadon;
import Service.Downloadfileexcel;

@WebServlet({
	"/statistical",
	"/statistical/appointment",
	"/statistical/hoadon"
})
public class statistical extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Booking> lstbooking;
	private List<Hoadon> lsthd;
	private Daobookimplement daobooking;
	private Daohoadon daohd;
	private Downloadfileexcel excel;
    public statistical() {
        this.daobooking=new Daobookimplement();
        this.daohd=new Daohoadon();
        this.lstbooking=new ArrayList<Booking>();
        this.lsthd=new ArrayList<Hoadon>();
        this.excel=new Downloadfileexcel();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.lstbooking=this.daobooking.getallpaid();
		this.lsthd=this.daohd.getallpail();
		request.setAttribute("lst", this.lstbooking);
		request.setAttribute("lsthd", this.lsthd);
		request.getRequestDispatcher("/Admin/Statistical.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		if(url.contains("appointment")) {
			try {
				this.excel.xuatbooking(lstbooking, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url.contains("hoadon")) {
			try {
				this.lsthd=this.daohd.getallpail();
				System.out.println(this.lsthd.size());
				this.excel.xuathoadon(lsthd, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
