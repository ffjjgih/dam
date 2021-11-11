package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import Dao.Daohomeimplements;
import Model.Home;
@MultipartConfig()
@WebServlet({
	"/Banner",
	"/Banner/insert",
	"/Banner/edit",
	"/Banner/update",
	"/Banner/delete"
})
public class Banner extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int index,id;
	private Daohomeimplements dao;
	private Home h=new Home();
    public Banner() {
        super();
		this.dao = new Daohomeimplements();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();

		index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idadmin", index);
		if(url.contains("edit")) {
			id=Integer.parseInt(request.getParameter("id"));
			valuebanner(request, response,id);
		}
		request.getRequestDispatcher("/Admin/Createbanner.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		if(url.contains("insert")) {
			insertbanner(request, response);
		}else if(url.contains("update")){
				updatebanner(request, response,id);
		}
		response.sendRedirect(request.getContextPath()+ "/Homeadmin?index="+index);
	}

	private void insertbanner(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part part=request.getPart("banner");
			String realpath=request.getServletContext().getRealPath("/images");
			String namefile=Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				 Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+System.getProperty("file.separator")+namefile);
			Home home = new Home();
			BeanUtils.populate(home, request.getParameterMap());
			home.setBanner("images"+System.getProperty("file.separator")+namefile);
			this.dao.create(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updatebanner(HttpServletRequest request, HttpServletResponse response,int id) {
		try {
			Part part=request.getPart("banner");
			String realpath=request.getServletContext().getRealPath("/images");
			String namefile=Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				 Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+System.getProperty("file.separator")+namefile);
			Home home = new Home();
			BeanUtils.populate(home, request.getParameterMap());
			home.setBanner("images"+System.getProperty("file.separator")+namefile);
			home.setIdhome(id);
			this.dao.update(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void valuebanner(HttpServletRequest request, HttpServletResponse response,int id) {
		Home home=this.dao.findbanner(id);
		request.setAttribute("h", home);
	}
	
	
}
