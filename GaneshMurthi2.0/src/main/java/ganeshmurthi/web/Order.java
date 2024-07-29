package ganeshmurthi.web;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import com.google.gson.Gson;

import ganeshmurthi.dao.CustomerDao;
import ganeshmurthi.dao.CustomerDaoImpl;
import ganeshmurthi.dao.IdolDao;
import ganeshmurthi.dao.IdolDaoImpl;
import ganeshmurthi.dao.ImageDao;
import ganeshmurthi.dao.ImageDaoImpl;
import ganeshmurthi.dao.OderTableDao;
import ganeshmurthi.dao.OrderDao;
import ganeshmurthi.dao.OrderDaoImpl;
import ganeshmurthi.dao.OrderTableDaoImpl;
import ganeshmurthi.dao.VendorDao;
import ganeshmurthi.dao.VendorDaoImpl;
import ganeshmurthi.model.CustomerBean;
import ganeshmurthi.model.IdolBean;
import ganeshmurthi.model.Imagebean;
import ganeshmurthi.model.OrderBean;
import ganeshmurthi.model.OrderTable;

/**
 * Servlet implementation class Order
 */
@WebServlet("/order")
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	OrderDao orderDao;
	CustomerDao customerDao;
	IdolDao idolDao;
	ImageDao imageDao;
	
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//RequestDispatcher dispatcher=request.getRequestDispatcher("CheckImages.jsp");
		//dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//String Type=request.getParameter("type");
		//String Colour=request.getParameter("colour");
		//String Size=request.getParameter("size");
		//String Desposible=request.getParameter("desposible");
		
		//int size = Integer.parseInt(Size);
		
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
	       String body = stringBuilder.toString();
		
		ObjectMapper mapper = new ObjectMapper();
	    Map<String,Object> map = mapper.readValue(body, Map.class);
	       
	       System.out.println(map.get("type"));
	       
	       String Type = (String) map.get("type");
	       String Colour = (String) map.get("colour");
	       String sizeOfIdol = (String) map.get("sizeOfIdol");
	       int size = Integer.parseInt(sizeOfIdol);
	       
		
		String cusername = request.getSession(false).getAttribute("customer").toString();
		//String cusername="cust@gmail.com";
		System.out.println( cusername);
		String jsonResponse = "";
		
			
			customerDao = new CustomerDaoImpl();
		    Long cid = customerDao.getCidFromVendor(cusername);
		    System.out.println(cid);
		    ArrayList<OrderTable> orderLst = new ArrayList<OrderTable>();
		    System.out.println("arr order "+ orderLst);
		    OderTableDao orderTableDao;
		    orderTableDao = new OrderTableDaoImpl();
		    orderLst = orderTableDao.StoreOrder(Type,size,Colour,cid);
		    
		    System.out.println("order "+ orderLst);
		    
		    String json = new Gson().toJson(orderLst);
		    
		    //final ByteArrayOutputStream out1 = new ByteArrayOutputStream();
		    
		    //final ObjectMapper mapper1 = new ObjectMapper();  
		   // mapper1.writeValue(out1, orderLst);
		    //final byte [] data = out1.toByteArray();
		    //jsonResponse = new String(data);
		    
		    //jsonResponse = mapper1.writeValueAsString(orderLst);
		     System.out.println("json "+json);
		  //  CustomerBean customerDetails;
		    //customerDetails = customerDao.getCustomerDetails(cid);
		    
		   // idolDao = new IdolDaoImpl();
		    
		    //Iterator<OrderTable> iter = orderLst.iterator();
		    
		    //ArrayList<Long> imageId = new ArrayList<Long>();
		    
		   // while (iter.hasNext()) {
	          //  System.out.print(iter.next() + " ");
	            //imageId.add(iter.next().getImage());
	        //}
		    
		   // ArrayList<OrderTable> lstImageData = new ArrayList<OrderTable>();
		   // imageDao = new ImageDaoImpl();
		    //lstImageData = imageDao.getImageFromImageId(imageId);
		    
		    
		    
		    
		    //Long imageId = idolDao.getImageIdfromIdolTable(Size,Colour);
		   
		    //Long vid = idolDao.getVidFromImageId(imageId);
		    
		    //Long idolId = idolDao.getIdolIdfromIdolTable(Size,Colour);
		    
		    //OrderBean orderBean = new OrderBean(cid,vid,idolId,imageId,1L,1L,"yes","complete");
		    //orderDao = new OrderDaoImpl();
			//orderDao.regOrder(orderBean);
			
			//ArrayList<String> lst1 = new ArrayList<String>();
			//ArrayList<String> lst2 = new ArrayList<String>();
		
			//lst1 = imageDao.getImageFromType(Type);
			
//			for(int i=0;i<lst1.size();i++) {
//				String pathString = lst1.get(i);
//				String newPathString = pathString.replace("GaneshMurthi\\src\\main\\webapp", ".");
//				lst2.add(newPathString);
//			}
			
			//request.setAttribute("list", lst1);
			
	
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(json);
		//RequestDispatcher dispatcher=request.getRequestDispatcher("./customerorder.html");
		//dispatcher.forward(request, response);
	}

}
