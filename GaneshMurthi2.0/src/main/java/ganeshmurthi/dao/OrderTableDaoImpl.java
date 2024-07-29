package ganeshmurthi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ganeshmurthi.model.IdolBean;
import ganeshmurthi.model.Imagebean;
import ganeshmurthi.model.OrderTable;
import ganeshmurthi.utils.JDBCUtils;

public class OrderTableDaoImpl implements OderTableDao {

	@Override
	public ArrayList<OrderTable> StoreOrder(String type, int size, String colour, Long cid) {
		// TODO Auto-generated method stub
		String SELECT_ORDER_SQL = "SELECT * FROM (SELECT *"
				+ " FROM (SELECT *"
				          + " FROM idoltable i WHERE  i.imageid IN (SELECT i2.imgid"
				                    + " FROM imagetable i2 WHERE  i2.description = ?)) a"
				                        + " WHERE  a.colorofidol = ? AND a.sizeofidol = ?) b"
			                            	+ " INNER JOIN imagetable i3 ON i3.imgid = b.imageid";
		
		//ArrayList<IdolBean> lst = new ArrayList<IdolBean>();
		ArrayList<OrderTable> lst1 = new ArrayList<OrderTable>();
		
		try {
			
			Connection connection= JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.
            prepareStatement(SELECT_ORDER_SQL);
            
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, colour);
            preparedStatement.setInt(3,size);
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            java.sql.ResultSetMetaData meta = rs.getMetaData();
            int column_Count = meta.getColumnCount();
            
            while(rs.next())
            {
            	Long idolid = rs.getLong("idolid");
            	Long vid = rs.getLong("vid");
            	Long contentid = rs.getLong("contentid");
            	int price = rs.getInt("priceofidol");
            	Long Size = rs.getLong("sizeofidol");
            	String color = rs.getString("colorofidol");
            	Long imageId = rs.getLong("imageid");
            	String imageDescription = rs.getString("description");
            	String imageData = rs.getString("imagedata");
            	String isDisposable = rs.getString("isdisposable");
            	
            	OrderTable ordertable = new OrderTable();
            	
                 ordertable.setIdol(new IdolBean(idolid,vid,contentid,price,color,Size,imageId,isDisposable)); 
                
                 ordertable.setImage(new Imagebean(imageId,imageDescription,imageData));
                 
                 lst1.add(ordertable);
               
            	//return rs.getString("imagedata");
            }
            connection.close();
		}catch (SQLException e) {
            printSQLException(e);
        }
		
		return lst1;
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

}
