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

import ganeshmurthi.dao.CustomerDaoImpl;
import ganeshmurthi.dao.IdolDaoImpl;
import ganeshmurthi.dao.ImageDaoImpl;
import ganeshmurthi.dao.OrderDao;
import ganeshmurthi.dao.OrderDaoImpl;
import ganeshmurthi.dao.OrderTableDaoImpl;
import ganeshmurthi.dao.VendorDao;
import ganeshmurthi.dao.VendorDaoImpl;
import ganeshmurthi.model.CustomerBean;
import ganeshmurthi.model.IdolBean;
import ganeshmurthi.model.OrderBean;
import ganeshmurthi.model.OrderTable;

/**
 * Servlet implementation class getReceivedOrderStatus
 */
@WebServlet("/getReceivedOrderStatus")
public class getReceivedOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDao order;
	VendorDao vendor;
	List<OrderBean> orderData;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getReceivedOrderStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		order = new OrderDaoImpl();
		List<OrderTable> ot = new ArrayList<OrderTable>();

		orderData = order.getAllOdersOfVendor(
				new VendorDaoImpl().getvendorid(request.getSession(false).getAttribute("vendor").toString()));
		RequestDispatcher dispatcher = request.getRequestDispatcher("./orders.jsp");
		Long cid;

		Iterator<OrderBean> itr = orderData.iterator();

		OrderTable ot1 = null;
		IdolBean idl = new IdolBean();
		CustomerBean cust1 = new CustomerBean();
		while (itr.hasNext()) {
			OrderBean tmpBean = itr.next();
			ot1 = new OrderTable();
			ot1.setOrder(tmpBean);
			cust1 = new CustomerDaoImpl().getCustomerDetails(tmpBean.getCid());
			ot1.setCustomer(cust1);

			ot1.setIdol(new IdolDaoImpl().getIdolInfo(tmpBean.getIdolid()));

			ot1.setImage(new ImageDaoImpl().getImageFromImageIdNew(tmpBean.getImageid()));

			ot.add(ot1);

		}

		request.setAttribute("custOrd", ot);

		dispatcher.forward(request, response);

	}

}
