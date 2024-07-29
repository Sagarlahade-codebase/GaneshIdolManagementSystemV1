package ganeshmurthi.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Servlet implementation class customerGetOrderStatus
 */
@WebServlet("/customerGetOrderStatus")
public class customerGetOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustomerDao customerDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerGetOrderStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDao order = new OrderDaoImpl();
		List<OrderTable> ot = new ArrayList<OrderTable>();
		OrderTable ot1 =null;
		String cusername = request.getSession(false).getAttribute("customer").toString();
		System.out.println( cusername);
		
		customerDao = new CustomerDaoImpl();
		Long cid = customerDao.getCidFromVendor(cusername);
	
		
		List<OrderBean> ordbean = new OrderDaoImpl().getAllOrdersByCid(cid);
		Iterator<OrderBean> itr = ordbean.iterator();
		OrderBean tmp = new OrderBean();
		//OrderBean ob=null;
		while(itr.hasNext()) {
			ot1= new OrderTable();
			ot1.setOrder(itr.next());
			ot1.setIdol(new IdolDaoImpl().getIdolInfo(ot1.getOrder().getIdolid()));
			ot1.setVendor(new VendorDaoImpl().getVendorDetails(ot1.getOrder().getVid()));
			ot1.setImage(new ImageDaoImpl().getImageFromImageIdNew(ot1.getOrder().getImageid()));
			ot1.setPaymentBean(new PaymentDaointerffaceImpl().getPayment(ot1.getOrder().getOid()));
			ot.add(ot1);
			
		}
		
		
		 RequestDispatcher dispatcher=request.getRequestDispatcher("./customerorderstatus.jsp");
		 request.setAttribute("orderData", ot);
 		dispatcher.forward(request, response);

	}

}
