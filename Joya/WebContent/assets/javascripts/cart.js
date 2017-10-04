/**
 * 장바구니 기능
 * author 김형주
 */

/**
 * 맵에서 키가 타입이 다르면 값이 같아도 다르다!!
 */
var DELIMITER_CART_ITEM="@@@";
var DELIMITER_CART_ITEM_INFO="#@#";


$(document).ready(function(){
	//장바구니 쿠키 체크
	checkCartCookie();

	addCartItem("1", 10);
	addCartItem("2", 10);
	addCartItem("3", 10);
	addCartItem("2", 10);
	addCartItem("3", 10);
	
	removeCartItem("2");
//	updateCartItem("3", 30);
	console.log($.cookie("cart"));
})



//장바구니 쿠키 존재 여부 확인 후 없으면 생성
function checkCartCookie(){
	var cartInfo=$.cookie("cart");
	if(!cartInfo){
		$.cookie("cart", "", {expired:2, path:'/'} );
	}
}

/*장바구니에 새 품목 추가*/
function addCartItem(productId, amount){
	var cartMap=getCartMap();
	cartMap.set(productId, amount);
	setCartCookie(cartMap);
}


function removeCartItem(productId){
	var cartMap=getCartMap();
	cartMap.delete(productId);
	setCartCookie(cartMap);
}

function updateCartItem(productId, amount){
	var cartMap=getCartMap();
	cartMap.delete(productId);
	cartMap.set(productId, amount);
	setCartCookie(cartMap);
}

function getCartMap(){
	var cartCookieValue=$.cookie("cart");
	var cartMap=new Map();

	if(cartCookieValue!=""){
		var cartItems=cartCookieValue.split(DELIMITER_CART_ITEM);
		cartItems.forEach(function(item, i, array) {
			cartMap.set(item.split(DELIMITER_CART_ITEM_INFO)[0],item.split(DELIMITER_CART_ITEM_INFO)[1]);
		})
	}
	return cartMap;
}

function setCartCookie(cartMap){
	var cartCookieValue="";

	var i=0;
	cartMap.forEach(function(value, key) {
		cartCookieValue+=(key+DELIMITER_CART_ITEM_INFO+value);
		if((++i)!=cartMap.size){
			cartCookieValue+=DELIMITER_CART_ITEM;
		}
	})
	$.cookie("cart", cartCookieValue);
}

function getCartSize(){
	return getCartMap().size;
}

function printMap(cartMap){
	for(var [key, value] of cartMap){
		console.log("key:"+key+" val:"+value);
	}
}