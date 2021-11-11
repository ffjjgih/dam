package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int index;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pay() {
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		index=Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idcustomer", index);
		request.getRequestDispatcher("/Customer/Pay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		index=Integer.parseInt(request.getParameter("index"));
		response.sendRedirect("/finaldam/Home?index="+index);
		
	}

}
