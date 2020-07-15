/**
 * 
 */
var arr = new Array();
var xhr = null;

function startRequest() {
	// alert("OK");
	// 객체 XMLHttpRequest -> 웹브라우저

	if (window.XMLHttpRequest) { // 윈도우의 XMLHttpRequest 객체있다면
		xhr = new XMLHttpRequest;
	} else { // 없다면
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}

	arr.push(xhr);
	alert(arr.join("\n"));

	xhr.open("GET", "responseXML.xml", true);
	xhr.send();
	xhr.onreadystatechange = resultProcess; // callback함수

}

function resultProcess() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		arr.push(xhr.responseXML);
		// alert(arr.join("\n"));

		var xmlDoc = xhr.responseXML;
		var studentList = xmlDoc.getElementsByTagName("student");

		var disp = document.getElementById("disp");

		for (var i = 0; i < studentList.length; i++) {
			var student = studentList[i];
			var subElement = student.childNodes;			

			var div = document.createElement("div");

			for (var j = 0; j < subElement.length; j++) {

				if (subElement[j].nodeType == 1) {
					var span = document.createElement("span");
					span.innerHTML = subElement[j].childNodes[0].nodeValue
							+ "&nbsp;";

					div.appendChild(span);
				}
			}
			disp.appendChild(div);
		}
	}

}