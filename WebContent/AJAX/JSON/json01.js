/**
 * 
 */

var xhr = null;
var arr = new Array();

function toServer() {
	//객체얻어오기
	if(window.XMLHttpRequest){ // 객체가 있니?
		xhr = new XMLHttpRequest;
	}else{
		xhr = new ActiveObject("Microsoft.XMLHTTP");
	}
	
	xhr.open("GET", "json01.txt", true); // true:비동기화 작업
	xhr.send(); // get방식으로 json01.txt 요청
	xhr.onreadystatechange = resultProcess;
}
	
function resultProcess() {
	if(xhr.readyState==4 && xhr.status==200){
		arr.push(xhr.responseText);
		alert(arr);
	}
	
	var obj=JSON.parse(xhr.responseText); //특수문자 제거
	
	var disp=document.getElementById("disp");
	var ul=document.createElement("ul");
	var liNode1=document.createElement("li");
	liNode1.innerHTML=obj.name;
	
	var liNode2=document.createElement("li");
	liNode2.innerHTML=obj.age;
	var liNode3=document.createElement("li");
	liNode3.innerHTML=obj.ki;	
	
	ul.appendChild(liNode1);
	ul.appendChild(liNode2);
	ul.appendChild(liNode3);
	disp.appendChild(ul);
}
