/**
 * 장바구니 페이지 이벤트 처리
 * author 김형주
 */

$(document).ready(function(){
	calcTotalPrice();
	
	$("#update-cart").click(function(){
		updateCartList();
		location.reload();
	})
	
	$(".ji-cart-deleteBtn").click(function(){
		var productId=$(this).attr("value");
		removeCartItem(productId);
		location.reload();
	})
	
	$(".productAmount").change(function(index, target){
		calcItemPrice(this);
		calcTotalPrice();
	})
	
	$("#checkout").click(function(){
		updateCartList();
		location.href="/order/order_add.joya"
	})
	
})


function updateCartList(){
	$(".productAmount").each(function(index, target){
		updateCartItem($(this).attr("name"), $(this).val())
	})
}

function calcItemPrice(target){
	var tar=$(target).attr("name");
	var amount=$(target).val();
	var price=$(".cartItemPrice[name="+tar+"]").text();
	$(".subPrice[name="+tar+"]").text(price*amount);
}

function calcTotalPrice(){
	var totalPrice=0;
	$(".subPrice").each(function(index, target){
		totalPrice+=Number($(this).html());
	})
	$("#subtotalPrice").html(totalPrice);
}	


