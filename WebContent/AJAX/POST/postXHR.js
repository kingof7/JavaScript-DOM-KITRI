/**
 * 
 */

var xhr = null;
var arr = new Array();

function toServer() {
	var msg = document.getElementById("createForm").msg.value;
	//arr.push(msg);
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest;
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// get방식
	//xhr.open("GET", "command.jsp?msg=" + msg, true); // 요청방식, 서버파일,
													// 비동기식(정적페이지)
	//xhr.send();
	
	// post방식
	xhr.open("POST", "command.jsp", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("msg=" + msg);
	xhr.onreadystatechange = process;
	
	//alert(arr.join("\n"));
}
// command.jsp가 아래 함수에 다시던져줌
function process() {

	if (xhr.readyState == 4 && xhr.status == 200){ // 잘넘어오는 상태 // https://www.w3schools.com/js/js_ajax_http_response.asp // 참고
		arr.push("aaa" + xhr.responseText);
		
		var disp=document.getElementById("disp");
		disp.innerText=xhr.responseText; // hi
	}

	alert(arr.join("\n"));

}
