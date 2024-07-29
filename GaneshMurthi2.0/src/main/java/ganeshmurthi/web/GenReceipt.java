package ganeshmurthi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ganeshmurthi.dao.CustomerDao;
import ganeshmurthi.dao.CustomerDaoImpl;
import ganeshmurthi.dao.IdolDaoImpl;
import ganeshmurthi.dao.ImageDaoImpl;
import ganeshmurthi.dao.OrderDao;
import ganeshmurthi.dao.OrderDaoImpl;
import ganeshmurthi.dao.PaymentDaointerffaceImpl;
import ganeshmurthi.dao.VendorDaoImpl;
import ganeshmurthi.model.OrderBean;
import ganeshmurthi.model.OrderTable;

/**
 * Servlet implementation class GenReceipt
 */
@WebServlet("/GenReceipt")
public class GenReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CustomerDao customerDao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenReceipt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long appOrderId = Long.parseLong(request.getParameter("apporderId"));
		OrderDao order = new OrderDaoImpl();
		OrderTable ot1 =null;
		String cusername = request.getSession(false).getAttribute("customer").toString();
		System.out.println( cusername);
		
		customerDao = new CustomerDaoImpl();
		Long cid = customerDao.getCidFromVendor(cusername);
	
		
		OrderBean ordbean = new OrderDaoImpl().getOrderDetails(appOrderId);
	
	
			ot1= new OrderTable();
			ot1.setOrder(ordbean);
			ot1.setIdol(new IdolDaoImpl().getIdolInfo(ot1.getOrder().getIdolid()));
			ot1.setVendor(new VendorDaoImpl().getVendorDetails(ot1.getOrder().getVid()));
			ot1.setImage(new ImageDaoImpl().getImageFromImageIdNew(ot1.getOrder().getImageid()));
			ot1.setPaymentBean(new PaymentDaointerffaceImpl().getPayment(ot1.getOrder().getOid()));
			ot1.setCustomer(new CustomerDaoImpl().getCustomerDetails(cid));	
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("./receipcustomer.jsp");
		 request.setAttribute("orderData", ot1);
 		dispatcher.forward(request, response);
		
	}

}
