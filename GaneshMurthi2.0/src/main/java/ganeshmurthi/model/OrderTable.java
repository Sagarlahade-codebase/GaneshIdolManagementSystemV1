package ganeshmurthi.model;

public class OrderTable {
	
	private OrderBean order;
	private VendorBean vendor;
	private QRCodeBean QRBean;
	private IdolManagementBean IdolManage;
	private Imagebean image;
	private IdolBean idol;
	private CustomerBean customer;
	private PaymentDao paymentBean;
	
	public PaymentDao getPaymentBean() {
		return paymentBean;
	}
	public void setPaymentBean(PaymentDao paymentBean) {
		this.paymentBean = paymentBean;
	}
	public OrderBean getOrder() {
		return order;
	}
	public void setOrder(OrderBean order) {
		this.order = order;
	}
	public VendorBean getVendor() {
		return vendor;
	}
	public void setVendor(VendorBean vendor) {
		this.vendor = vendor;
	}
	public QRCodeBean getQRBean() {
		return QRBean;
	}
	public void setQRBean(QRCodeBean qRBean) {
		QRBean = qRBean;
	}
	public IdolManagementBean getIdolManage() {
		return IdolManage;
	}
	public void setIdolManage(IdolManagementBean idolManage) {
		IdolManage = idolManage;
	}
	public Imagebean getImage() {
		return image;
	}
	public void setImage(Imagebean image) {
		this.image = image;
	}
	public IdolBean getIdol() {
		return idol;
	}
	public void setIdol(IdolBean idol) {
		this.idol = idol;
	}
	public CustomerBean getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}
	
}
