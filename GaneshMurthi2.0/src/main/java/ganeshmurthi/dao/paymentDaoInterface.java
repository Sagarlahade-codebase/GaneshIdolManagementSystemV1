package ganeshmurthi.dao;

import ganeshmurthi.model.PaymentDao;

public interface paymentDaoInterface {

	void regPayment(PaymentDao pay);
	PaymentDao getPayment(Long appOrderId);
}
