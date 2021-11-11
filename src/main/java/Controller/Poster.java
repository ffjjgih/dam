package Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
	"/Poster",
	"/Poster/insert",
	"/Poster/edit",
	"/Poster/update"
})
public class Poster extends HttpServlet {
	int index,id;
	private static final long serialVersionUID = 1L;
	private Daohomeimplements dao;
    public Poster() {
        super();
        this.dao=new Daohomeimplements();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idadmin", index);

		if(url.contains("edit")) {
			id=Integer.parseInt(request.getParameter("id"));
			Model.Home home=this.dao.findbanner(id);
			request.setAttribute("h", home);
		}
		request.getRequestDispatcher("/Admin/Createevents.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if(url.contains("insert")) {
			createposter(request, response);
			System.out.print("abdc");
		}else if(url.contains("update")) {
			updateposter(request, response);
			System.out.print("abc");
		}
		response.sendRedirect(request.getContextPath()+"/Homeadmin?index="+index);
	}

	private void createposter(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part part=request.getPart("poster");
			String realpath=request.getServletContext().getRealPath("/images");
			String namefile=Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				 Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+System.getProperty("file.separator")+namefile);
			Home home = new Home();
			BeanUtils.populate(home, request.getParameterMap());
			home.setPoster("images"+System.getProperty("file.separator")+namefile);
			this.dao.create(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updateposter(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part part=request.getPart("poster");
			String realpath=request.getServletContext().getRealPath("/images");
			String namefile=Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				 Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+System.getProperty("file.separator")+namefile);
			Home home = new Home();
			BeanUtils.populate(home, request.getParameterMap());
			home.setPoster("images"+System.getProperty("file.separator")+namefile);
			home.setIdhome(id);
			this.dao.update(home);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
