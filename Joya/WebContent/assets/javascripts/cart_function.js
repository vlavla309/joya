/**
 * 장바구니 기능
 * author 김형주
 */

/**
 * 맵에서 키가 타입이 다르면 값이 같아도 다르다!!
 * 쿠키에 한줄로 저장되어있는 장바구니 정보를 파싱해서 Map객체로 관리한다
 * 맵객체에서 key값은 상품id Value값은 상품수량이다
 */
var DELIMITER_CART_ITEM="@@@";
var DELIMITER_CART_ITEM_INFO="#@#";


//테스트 
$(document).ready(function(){
	//장바구니 쿠키 체크
	checkCartCookie();
})



//장바구니 쿠키 존재 여부 확인 후 없으면 생성
function checkCartCookie(){
	//JQuery를 이용해 cart 쿠키의 값을 가져옴
	var cartInfo=$.cookie("cart");
	
	//쿠키의 값이 비어있으면 cart 쿠키를 신규로 생성 (유효기간2일, 패스:/)
	if(!cartInfo){
		//expired 단위 2일
		$.cookie("cart", " ", {expired:2, path:'/'} );
	}
}

/*장바구니에 새 품목 추가*/
function addCartItem(productId, amount){
	
	//장바구니 정보 Map객체 가져오기
	var cartMap=getCartMap();
	
	//Map에 새 품목 추가
	cartMap.set(productId, amount);
	
	//Map객체를 다시 쿠키값으로 설정
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

//쿠키값을 파싱후 Map객체로 반환
function getCartMap(){
	//쿠키값을 얻음
	var cartCookieValue=$.cookie("cart");
	//빈 맵객체 생성
	var cartMap=new Map();

	
	if(cartCookieValue!=" "){//쿠키값이 비어있을경우 빈 Map 반환
		//쿠키값을 구획문자로 파싱(품목별로 나눔)
		var cartItems=cartCookieValue.split(DELIMITER_CART_ITEM);
		//배열을 foreach 문으로 수행
		cartItems.forEach(function(item, i, array) {
			//하나의 품목을 다시 파싱하여 상품id와 수량을 얻고 다시 맵객체에 집어넣음
			cartMap.set(item.split(DELIMITER_CART_ITEM_INFO)[0],item.split(DELIMITER_CART_ITEM_INFO)[1]);
		})
	}
	return cartMap;
}

/**Map객체를 다시 구분자가 포함된 문자열로 바꾼 뒤 쿠키값으로 지정 */
function setCartCookie(cartMap){
	var cartCookieValue="";

	var i=0;
	cartMap.forEach(function(value, key) {
		cartCookieValue+=(key+DELIMITER_CART_ITEM_INFO+value);
		if((++i)!=cartMap.size){
			cartCookieValue+=DELIMITER_CART_ITEM;
		}
	})
	$.cookie("cart", cartCookieValue, {expired:2, path:'/'});
}

/**카트 맵의 사이즈 즉 장바구니 품목 개수 반환*/
function getCartSize(){
	return getCartMap().size;
}

/**맵객체의 값 출력*/
function printMap(cartMap){
	for(var [key, value] of cartMap){
		console.log("key:"+key+" val:"+value);
	}
}