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

import Dao.Daofoodimplement;
import Model.Food;

/**
 * Servlet implementation class Managefood
 */
@MultipartConfig
@WebServlet({
	"/Managefood",
	"/Managefood/insert",
	"/Managefood/edit",
	"/Managefood/update",
	"/Managefood/delete"
})
public class Managefood extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Daofoodimplement dao;
     private Food food;
     private List<Food> lst;
    public Managefood() {
        super();
        this.dao=new Daofoodimplement();
        this.food=new Food();
        this.lst=new ArrayList<Food>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		int index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idadmin", index);
		if(url.contains("edit")) {
			editfood(request, response);
		}else if(url.contains("delete")) {
			delete(request, response);
		}
		showall(request, response);
		request.getRequestDispatcher("/Admin/Inforfood.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if(url.contains("insert")) {
			insertfood(request, response);
		}else if(url.contains("update")) {
			updatefood(request, response);
		}
		showall(request, response);
		request.getRequestDispatcher("/Admin/Inforfood.jsp").forward(request, response);
	}

	private void insertfood(HttpServletRequest request, HttpServletResponse response) {
		try {
			Part part=request.getPart("poster");
			String realpath=request.getServletContext().getRealPath("/images");
			String namefile=Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				 Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+System.getProperty("file.separator")+namefile);
			BeanUtils.populate(food, request.getParameterMap());
			this.food.setPoster("images"+System.getProperty("file.separator")+namefile);
			this.dao.create(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void editfood(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			food=this.dao.findbyid(id);
			request.setAttribute("f", food);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void updatefood(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			Part part=request.getPart("poster");
			String realpath=request.getServletContext().getRealPath("/images");
			String namefile=Path.of(part.getSubmittedFileName()).getFileName().toString();
			if(!Files.exists(Path.of(realpath))) {
				 Files.createDirectory(Path.of(realpath));
			}
			part.write(realpath+System.getProperty("file.separator")+namefile);
			
			food=this.dao.findbyid(id);
			food.setPoster("images"+System.getProperty("file.separator")+namefile);
			BeanUtils.populate(food, request.getParameterMap());
			this.dao.update(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			food=this.dao.findbyid(id);
			this.dao.delete(food);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showall(HttpServletRequest request, HttpServletResponse response) {
		try {
			lst=this.dao.showfood();
			request.setAttribute("listfood", lst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
