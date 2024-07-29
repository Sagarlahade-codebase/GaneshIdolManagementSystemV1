package ganeshmurthi.web;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import ganeshmurthi.dao.CustomerDao;
import ganeshmurthi.dao.CustomerDaoImpl;
import ganeshmurthi.dao.IdolDao;
import ganeshmurthi.dao.IdolDaoImpl;
import ganeshmurthi.dao.OrderDao;
import ganeshmurthi.dao.OrderDaoImpl;
import ganeshmurthi.model.IdolBean;
import ganeshmurthi.utils.EmailUtil;

/**
 * Servlet implementation class finalizeOrder
 */
@WebServlet("/finalizeOrder")
public class finalizeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderDao orderDao;
	private CustomerDao cust;
	private IdolDao idolData;
	private IdolBean idolObj;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public finalizeOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long idolId = Long.parseLong(request.getParameter("idolId"));
		Long priceOfIdol = Long.parseLong(request.getParameter("priceOfIdol"));
		String colorOfIdol =request.getParameter("idolcolor");
		
		orderDao = new OrderDaoImpl();
		String cuser = request.getSession(false).getAttribute("customer").toString();
		cust=new CustomerDaoImpl();
		Long cid = cust.getCidFromVendor(cuser);
		idolData = new IdolDaoImpl();
		idolObj = idolData.getIdolInfo(idolId);
		//start coding here
		int orderId = orderDao.regOrder(idolObj, cid);
		 
		
		
		request.setAttribute("orderId", orderId);
		request.setAttribute("idolData", idolObj);
		
		
		EmailUtil.sendEmail(cuser,"Dear Customer Your Ganesh Murthi Order Confirmed","Your Orde id is : "+orderId);
		
       RequestDispatcher dispatcher = request.getRequestDispatcher("./acceptOrder.jsp");
	   dispatcher.forward(request, response);

		
		
	}

}
