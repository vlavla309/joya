package com.joya.order.domain;

public class Orders {
	private int orderId;
	private String email;
	private int price;
	private String orderer;
	private String receiver;
	private String address;
	private String phone;
	private String status;
	private String paymentType;
	private int usedPoint;
	private String paymentDate;
	private int payment;
	private int cardNo;
	private int approvalNo;
	private String orderDate;
	
	public Orders() {}
	
	
	
	public Orders(int orderId, String email, int price, String orderer, String receiver, String address, String phone,
			String status, String paymentType, int usedPoint, String paymentDate, int payment, int cardNo,
			int approvalNo, String orderDate) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.price = price;
		this.orderer = orderer;
		this.receiver = receiver;
		this.address = address;
		this.phone = phone;
		this.status = status;
		this.paymentType = paymentType;
		this.usedPoint = usedPoint;
		this.paymentDate = paymentDate;
		this.payment = payment;
		this.cardNo = cardNo;
		this.approvalNo = approvalNo;
		this.orderDate=orderDate;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrderer() {
		return orderer;
	}

	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getUsedPoint() {
		return usedPoint;
	}

	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public int getApprovalNo() {
		return approvalNo;
	}

	public void setApprovalNo(int approvalNo) {
		this.approvalNo = approvalNo;
	}
	
	

	public String getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}



	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", email=" + email + ", price=" + price + ", orderer=" + orderer
				+ ", receiver=" + receiver + ", address=" + address + ", phone=" + phone + ", status=" + status
				+ ", paymentType=" + paymentType + ", usedPoint=" + usedPoint + ", paymentDate=" + paymentDate
				+ ", payment=" + payment + ", cardNo=" + cardNo + ", approvalNo=" + approvalNo + ", orderDate="
				+ orderDate + "]";
	}



	
	
}
