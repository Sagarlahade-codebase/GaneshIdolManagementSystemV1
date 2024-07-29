package ganeshmurthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ganeshmurthi.model.PaymentDao;
import ganeshmurthi.utils.JDBCUtils;

public class PaymentDaointerffaceImpl implements paymentDaoInterface {

	@Override
	public void regPayment(PaymentDao pay) {
		// TODO Auto-generated method stub
		
		String INSERT_PAYMENT = "INSERT INTO payment" +
	            "  (PaymentId,pdate,orderid,porderid,signiture ) VALUES " +
	            " ( ?, ?, ?,?,?);";
        
	        int result;
			try {
	        		Connection connection= JDBCUtils.getConnection();
	            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_PAYMENT);
	            		 
	            preparedStatement1.setString(1, pay.getPaymentId());
	            preparedStatement1.setTimestamp(2,pay.getDate());
	            preparedStatement1.setLong(3, pay.getOrderId());
	            preparedStatement1.setString(4, pay.getPorderid());
	            preparedStatement1.setString(5,pay.getSigniture());
	           
	            System.out.println(preparedStatement1);
	            // Step 3: Execute the query or update query
	            result = preparedStatement1.executeUpdate();
	            System.out.println("payment data inserted");
	            connection.close();
	        } catch (SQLException e) {
	            // process sql exception
	            System.out.println(e);
	        }

	}

	@Override
	public PaymentDao getPayment(Long appOrderId) {
		
		Connection connection;
        PaymentDao payment = new PaymentDao();

		 try {
	        	 connection= JDBCUtils.getConnection();
	            PreparedStatement preparedStatement = connection.
	            prepareStatement("SELECT PaymentId,pdate,orderid,porderid,signiture FROM payment"
	            		+ " where orderid = ?");
	            preparedStatement.setLong(1, appOrderId);         		 
	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            if(rs.next())
	            {
	            	payment.setPaymentId( rs.getString("PaymentId"));
	            	payment.setPorderid(rs.getString("porderid"));
	            	payment.setSigniture(rs.getString("signiture"));
	            	payment.setOrderId(rs.getLong("orderid"));
	            	payment.setDate(rs.getTimestamp("pdate"));
	            }
	            
	            connection.close();
	        } catch (SQLException e) {
	        	System.out.println(e);
	        }
	        return payment;
		
	}

}
