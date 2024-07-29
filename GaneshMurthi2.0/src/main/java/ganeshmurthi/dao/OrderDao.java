package ganeshmurthi.dao;

import java.sql.SQLException;
import java.util.List;

import ganeshmurthi.model.IdolBean;
import ganeshmurthi.model.OrderBean;

public interface OrderDao {
OrderBean getOrderDetails(Long orderId) throws SQLException;
List<OrderBean> getAllOdersOfVendor(Long vid);
int regOrder(IdolBean idolBean,Long custId);
Long acceptOrder(IdolBean idol);
boolean updateStatus(Long orderid,String status) throws SQLException;
List<OrderBean> getAllOrdersByCid(Long cid);
}
