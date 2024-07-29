package ganeshmurthi.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ganeshmurthi.dao.OrderDaoImpl;

/**
 * Servlet implementation class updateStatus
 */
@WebServlet("/updateStatus")
public class updateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String status = request.getParameter("status");
		Long oid = Long.parseLong(request.getParameter("oid"));
		boolean result = new OrderDaoImpl().updateStatus(oid,status);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("./getReceivedOrderStatus");
 		dispatcher.forward(request, response);

}
	}
