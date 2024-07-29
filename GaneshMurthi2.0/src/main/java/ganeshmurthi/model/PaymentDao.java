package ganeshmurthi.model;

import java.sql.Timestamp;

public class PaymentDao {
String paymentId;
java.sql.Timestamp date;
Long orderId;
String porderid;
String Signiture;
public String getPaymentId() {
	return paymentId;
}
public void setPaymentId(String paymentId) {
	this.paymentId = paymentId;
}
public java.sql.Timestamp getDate() {
	return date;
}
public void setDate(java.sql.Timestamp date) {
	this.date = date;
}
public Long getOrderId() {
	return orderId;
}
public void setOrderId(Long orderId) {
	this.orderId = orderId;
}
public String getPorderid() {
	return porderid;
}
public void setPorderid(String porderid) {
	this.porderid = porderid;
}
public String getSigniture() {
	return Signiture;
}
public void setSigniture(String signiture) {
	Signiture = signiture;
}
public PaymentDao(String paymentId, Timestamp date, Long orderId, String porderid, String signiture) {
	super();
	this.paymentId = paymentId;
	this.date = date;
	this.orderId = orderId;
	this.porderid = porderid;
	this.Signiture = signiture;
}
public PaymentDao() {
	super();
	// TODO Auto-generated constructor stub
}


}
