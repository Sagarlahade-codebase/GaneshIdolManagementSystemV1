package ganeshmurthi.dao;

import java.util.ArrayList;

import ganeshmurthi.model.IdolBean;
import ganeshmurthi.model.OrderTable;

public interface OderTableDao {

  ArrayList<OrderTable> StoreOrder(String type, int size, String colour, Long cid);
 
}
