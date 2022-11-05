<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%    
   	response.setHeader("Access-Control-Allow-origin", "http://puhu17.cafe24.com");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소를 입력해주세요.</title>
<style>
  table {
    width: 300px;
    border: 1px solid #444444;
	text-align:center;
}


 </style>
</head>

<body>
<p>주소를 입력해 주세요.</p>
<input type="text" id="address" placeholder="입력하세요" style="width:290px">
<br>
<br>	
<table>
<thead style="border : 1px solid #444444">
<tr>
	<th  style="width:80px">우편번호</th>
	<th>주소</th>	
</tr>
</thead>
<tbody id="body">
</tbody>
</table>
</body>

<script>

var httpRequest;
var addr = document.getElementById("address");
var data;
var trs = [];
var addressTableBody = document.getElementById("body");
for(var i = 0 ; i < 10 ; i ++){
var tr = document.createElement("tr");
var td1 = document.createElement("td");
var td2 = document.createElement("td");
addressTableBody.append(tr);
tr.append(td1);
tr.append(td2);
trs.push(tr);
td1.setAttribute('name',"postcode");
td2.setAttribute('name',"fulladdress");
}
inputVals = (i)=>{
	window.parent.postMessage({ "postcode" : data[i]["postcode"],"fulladdress":data[i]["fulladdress"] }, '*');
	console.log("try");
	//self.close();
}
var timer;
addr.addEventListener('input', function(e) {
    if(timer) {
        clearTimeout(timer);
    }
    timer = setTimeout(()=> {
    	if(addr.value.length >=2)
    	makeRequest();
    }, 300);
});
function makeRequest() {
  httpRequest = new XMLHttpRequest();

  if(!httpRequest) {
    alert('실패!');
    return false;
  }

  httpRequest.onreadystatechange = receiveContents;
  httpRequest.open('GET', 'http://puhu17.cafe24.com/addressapi/getaddress/'+addr.value+'/');
  httpRequest.send();
}


const receiveContents = ()=> {
  if (httpRequest.readyState === XMLHttpRequest.DONE) {
    if (httpRequest.status === 200) {
      data = JSON.parse(httpRequest.responseText);
      var idx = 0;
      trs.forEach( (obj)=>{
    	  var child = obj.childNodes;
    	  console.log(child);
    	 if(data[idx]!=null){
    		 child[0].innerHTML= "<a onclick='javascript: inputVals("+idx+")'>"+data[idx]["postcode"]+"</a>";
    		 child[1].innerHTML= "<a onclick='javascript: inputVals("+idx+")'>"+data[idx]["fulladdress"]+"</a>";
    	 }else{ 
    		child[0].innerText="";
    		child[1].innerText="";
    	 }
    	 idx++;
      })
    } else {
    }
  }


}

</script>
</html>