package payment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ganeshmurthi.dao.PaymentDaointerffaceImpl;
import ganeshmurthi.model.PaymentDao;

/**
 * Servlet implementation class PaymentSuccess
 */
@WebServlet("/PaymentSuccess")
public class PaymentSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccess() {
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

		String body = null;
		    StringBuilder stringBuilder = new StringBuilder();
		    BufferedReader bufferedReader = null;

		    try {
		        InputStream inputStream = request.getInputStream();
		        if (inputStream != null) {
		            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		            char[] charBuffer = new char[128];
		            int bytesRead = -1;
		            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
		                stringBuilder.append(charBuffer, 0, bytesRead);
		            }
		        } else {
		            stringBuilder.append("");
		        }
		    } catch (IOException ex) {
		        throw ex;
		    } finally {
		        if (bufferedReader != null) {
		            try {
		                bufferedReader.close();
		            } catch (IOException ex) {
		                throw ex;
		            }
		        }
		    }

		    body = stringBuilder.toString();
		    ObjectMapper mapper = new ObjectMapper();
		    Map<String,Object> map = mapper.readValue(body, Map.class);
   
		    Long appOrderId= Long.parseLong( map.get("appOrderId").toString());  // new PaymentDaointerffaceImpl().regPayment(new PaymentDao((String)map.get("payid")));
		    Timestamp date = new Timestamp(Long.parseLong(map.get("created_at").toString())*1000);
		    String porderid =map.get("porderid").toString();
		    String paymentId =map.get("payid").toString();
		    String signature =map.get("signature").toString();

			new PaymentDaointerffaceImpl().regPayment(new PaymentDao(paymentId, date, appOrderId, porderid, signature));

	}

}
