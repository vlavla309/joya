package com.joya.order.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.joya.common.controller.Controller;
import com.joya.common.controller.ModelAndView;
import com.joya.common.web.Delimiter;
import com.joya.order.domain.Orders;
import com.joya.order.service.OrderService;
import com.joya.order.service.OrderServiceImpl;
import com.joya.orderitem.domain.OrderItems;
import com.joya.orderitem.service.OrderItemService;
import com.joya.orderitem.service.OrderItemServiceImpl;
import com.joya.product.domain.Product;
import com.joya.product.service.ProductService;
import com.joya.product.service.ProductServiceImpl;
import com.joya.user.domain.User;
import com.joya.user.service.UserService;
import com.joya.user.service.UserServiceImpl;

public class CreateOrderActionController implements Controller {
	OrderService orderServ=new OrderServiceImpl();
	OrderItemService orderItemServ=new OrderItemServiceImpl();
	ProductService productServ=new ProductServiceImpl();
	UserService userServ = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView();

		//로그인 여부를 췤
		String userEmail=(String) request.getAttribute("email");

		// 먼저 주문번호 생성를 해야함
		int orderId=orderServ.getNewOrderId();
		int price=0;

		//주문자 정보
		String email=request.getParameter("email");
		String orderer=request.getParameter("ordername");
		String orderphone=request.getParameter("orderphone");
		String before_use_point_price = request.getParameter("before_use_point_price");
		String paymentType=request.getParameter("payment");
		int usedpoint=0;
		//주문자의 전체 포인트
		String totalpoint = request.getParameter("totalpoint");
		String totalPrice = request.getParameter("totalPrice");
		//주문자가 주문할 때 사용한 포인트
		String usedpointStr = request.getParameter("used_point");
		if(usedpointStr!=null) {
			usedpoint=Integer.parseInt(usedpointStr);
		}
		//주문하고 남은 포인트
		String rest_point = request.getParameter("rest_point");
		//주소 
		String address1 = request.getParameter("address1"); //postcode
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String orderaddress = address1+"###"+address2+"###"+address3;

		// 배송지 정보
		// 받는사람 이름
		String receiver=request.getParameter("receiver");
		// 받는사람 전화번호
		String receivephone = request.getParameter("receivephone");
		// 배송지 주소
		String receiveaddress1 = request.getParameter("receiveaddress1"); //postcode
		String receiveaddress2 = request.getParameter("receiveaddress2");
		String receiveaddress3 = request.getParameter("receiveaddress3");
		String receiveaddress = receiveaddress1+"###"+receiveaddress2+"###"+receiveaddress3;
		// 배송메세지
		String deliverymsg = request.getParameter("deliverymsg");

		//주문접수, 주문취소, 결제완료, 배송중, 배송완료
		String status = "주문접수"; //기본값

		//order items 리스트를 만들기 위해 makeOrderItems 메소드에 미리 생성된 order id를 넘겨줌 
		List<OrderItems> orderItems=null;

		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equalsIgnoreCase("cart")) {
				String cartInfo = URLDecoder.decode(cookie.getValue(), "utf-8");
				//makeOrderItems는 쿠키에 저장되어있는 장바구니를 읽고, 파싱해서 리스트로 반환
				orderItems=makeOrderItems(orderId, cartInfo);
			}
		}

		//주문금액 계산
		for (OrderItems orderItem : orderItems) {
			int productId=orderItem.getProductId();
			/* 주문한 상품들의 productid로 상품 가격의 단가를 가져온다. */
			Product product=productServ.read(productId);
			/* 주문 수량과 단가를 곱하고 누적해서 주문 상품들에 대한 총 가격을 계산. */
			price+=orderItem.getAmount()*product.getPrice();
		}

		Orders order=new Orders();
		if(userEmail!=null) {
			order.setEmail(email);
		}else {
			order.setEmail("anonymous@joa.com");
			order.setGstEmail(email);
		}

		order.setOrderId(orderId);
		order.setPrice(price);
		order.setOrderer(orderer);
		order.setReceiver(receiver);
		order.setPayment(price-usedpoint);
		order.setAddress(receiveaddress);
		order.setPhone(orderphone);
		order.setStatus(status);
		order.setPaymentType(paymentType);
		order.setUsedPoint(usedpoint);
		order.setMassage(deliverymsg);
		System.out.println(order);
		
		orderServ.create(order);

		//주문항목 db에 입력
		for (OrderItems orderItem : orderItems) {
			orderItemServ.create(orderItem);
		}

		//사용한포인트가있을경우 포인트 차감
		if(usedpoint!=0) {
			User user=userServ.read(email);
			int curPoint=user.getPoint();
			user.setPoint(curPoint-usedpoint);
			userServ.modify(user);
		}

		mav.addObject("order", order);
		mav.setView("/order/result.jsp");
		return mav;
	}

	private List<OrderItems> makeOrderItems(int orderId, String cookieValue){
		//productid#@#amount@@@productid#@#amount@@@productid#@#amount 형식으로 쿠키에 cart가 저장되어 있음.
		List<OrderItems> list=new ArrayList<OrderItems>();
		String[] cartItems=cookieValue.split(Delimiter.CART_ITEM); //@@@
		for (String item : cartItems) {
			String productId=item.split(Delimiter.CART_ITEM_INFO)[0]; //#@#
			String amount=item.split(Delimiter.CART_ITEM_INFO)[1];
			OrderItems orderItem=new OrderItems(Integer.parseInt(productId),orderId,Integer.parseInt(amount));
			list.add(orderItem);
		}
		return list;
	}

}
