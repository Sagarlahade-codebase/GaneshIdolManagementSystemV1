package ganeshmurthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ganeshmurthi.model.IdolBean;
import ganeshmurthi.model.OrderBean;
import ganeshmurthi.utils.JDBCUtils;


public class OrderDaoImpl implements OrderDao {

	private static final String SELECT_ORDER_BY_ID = "SELECT oid,vid,cid,managementid,imageid,qrid,orderstatus,idolid,managedwell  FROM ordertable where oid = ? ";
	private static final String SELECT_ALL_ORDERS_OF_VENDOR_BY_ID= " select * from (select * from ordertable where vid = ? ) as d INNER join payment p on d.oid= p.orderid ";
	private static final String updateStatus="update ordertable set orderstatus = ? where oid = ?";
	private static final String getAllOrdersByCid = "Select * from ordertable where cid = ?";
	
	@Override
	public OrderBean getOrderDetails(Long orderId)  {
		OrderBean order = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
			preparedStatement.setLong(1,orderId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("oid");
				Long vid = rs.getLong("vid");
				Long cid = rs.getLong("cid");
				Long managementid = rs.getLong("managementid");
				Long imageid = rs.getLong("imageid");
				Long qrid = rs.getLong("qrid");
				Long idolid = rs.getLong("idolid");
				String orderstatus = rs.getString("orderstatus");
				String managedwell = rs.getString("managedwell");

				order= new OrderBean(id,cid,vid,idolid,imageid,qrid,managementid,managedwell,orderstatus);
				
			}
			 connection.close();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return order;
	}
	
	@Override
	public int regOrder(IdolBean idol,Long custId) {
		// TODO Auto-generated method stub
		 int generatedKey = 0;
		 
		 String INSERT_ORDER_SQL = "INSERT INTO ordertable" +
		            "  (cid,vid,orderstatus,idolid,managedwell,imageid,qrid,managementid ) VALUES " +
		            " ( ?, ?, ?,?,?,?,?,?);";
             Long x = null;
		        boolean result = false;


		        try {
		        		Connection connection= JDBCUtils.getConnection();
		        
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_ORDER_SQL, Statement.RETURN_GENERATED_KEYS);
		            		 
		            preparedStatement1.setLong(1, custId);
		            preparedStatement1.setLong(2, idol.getVid());
		            preparedStatement1.setString(3, "pending");
		            preparedStatement1.setLong(4, idol.getIdolid());
		            preparedStatement1.setString(5, "No");
		            preparedStatement1.setLong(6, idol.getImageid());
		            preparedStatement1.setLong(7, 0L);
		            preparedStatement1.setLong(8, 0L);
		            System.out.println(preparedStatement1);
		            // Step 3: Execute the query or update query
		            preparedStatement1.execute();
		            ResultSet rs = preparedStatement1.getGeneratedKeys();
		           
		           
		            
		            if (rs.next()) {
		            	generatedKey = rs.getInt(1);
		            }
		            connection.close();
		        } catch (SQLException e) {
		            // process sql exception
		            printSQLException(e);
		        }
		        return generatedKey;
	}

	private void printSQLException(SQLException ex) {
		// TODO Auto-generated method stub
		 for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	}

	
	@Override
	public List<OrderBean> getAllOdersOfVendor(Long vid) {
		// TODO Auto-generated method stub
		List<OrderBean> orders = new ArrayList<>();
		OrderBean order = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS_OF_VENDOR_BY_ID);) {
			preparedStatement.setLong(1,vid);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Long id = rs.getLong("oid");
				Long vid1 = rs.getLong("vid");
				Long cid = rs.getLong("cid");
				Long managementid = rs.getLong("managementid");
				Long imageid = rs.getLong("imageid");
				Long qrid = rs.getLong("qrid");
				Long idolid = rs.getLong("idolid");
				String orderstatus = rs.getString("orderstatus");
				String managedwell = rs.getString("managedwell");

				 order = new OrderBean(id,cid,vid1,idolid,imageid,qrid,managementid,managedwell,orderstatus);
				
				orders.add(order);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}

		return orders;
	}

	@Override
	public Long acceptOrder(IdolBean idol) {
	return 0L;
	}

	public boolean updateStatus(Long orderid, String status)  {
		try {
			try (Connection connection = JDBCUtils.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(updateStatus)) {
				preparedStatement.setString(1,status);
				preparedStatement.setLong(2,orderid);
				System.out.println(preparedStatement);
				int rs = preparedStatement.executeUpdate();
				if(rs>0) {
					return true;
				}
			
			return false;
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<OrderBean> getAllOrdersByCid(Long cid) {
		// TODO Auto-generated method stub
		OrderBean order;
		List<OrderBean> orders = new ArrayList<OrderBean>();
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(getAllOrdersByCid)) {
			preparedStatement.setLong(1,cid);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Long id = rs.getLong("oid");
				Long vid = rs.getLong("vid");
				Long cid1 = rs.getLong("cid");
				String orderstatus = rs.getString("orderstatus");
				Long idolid = rs.getLong("idolid");
				String managedwell = rs.getString("managedwell");
				Long imageid = rs.getLong("imageid");
				Long qrid = rs.getLong("qrid");
				Long managementid = rs.getLong("managementid");

				 order = new OrderBean(id,cid1,vid,idolid,imageid,qrid,managementid,managedwell,orderstatus);
				
				orders.add(order);
			}
			return orders;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
