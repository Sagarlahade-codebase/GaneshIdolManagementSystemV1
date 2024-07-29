package payment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Servlet implementation class Paymentgateway
 */
@WebServlet("/PaymentGateway")
public class Paymentgateway extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paymentgateway() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		com.razorpay.Order porder = null;
		try {
		RazorpayClient razorpay = new RazorpayClient("rzp_test_lZmuryZn8heqcu", "Y6RY5xdD3wsc3lXUy6E34uTv");

		  JSONObject orderRequest = new JSONObject();
		  orderRequest.put("amount", Long.parseLong(request.getParameter("priceofidol"))*100); 
		  orderRequest.put("currency", "INR");

		  porder = razorpay.Orders.create(orderRequest);
		  
		} catch (RazorpayException e) {
		  // Handle Exception
		  System.out.println(e.getMessage());
		}
		
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();

		
		JsonElement json = new Gson().toJsonTree(porder);
		  json.getAsJsonObject().addProperty("appOrderId", Long.parseLong(request.getParameter("appOrderId")));
		  json.getAsJsonObject().addProperty("idolprice", Long.parseLong(request.getParameter("priceofidol")));

		  out.print(json);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
