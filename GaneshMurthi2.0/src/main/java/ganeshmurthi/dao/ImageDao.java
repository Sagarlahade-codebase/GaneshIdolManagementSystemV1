package ganeshmurthi.dao;

import java.util.ArrayList;
import java.util.List;

import ganeshmurthi.model.ContentBean;
import ganeshmurthi.model.Imagebean;
import ganeshmurthi.model.OrderTable;

public interface ImageDao {
	int regImage(Imagebean Image);
	Long getImageIdFromImageTable(String image);
	
	ArrayList<OrderTable> getImageFromImageId(ArrayList<Long> imageId);
	Imagebean getImageFromImageIdNew(Long imageId);
}
