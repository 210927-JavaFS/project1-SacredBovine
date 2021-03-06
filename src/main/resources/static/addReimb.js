const URL = "http://localhost:8081/";
window.onload = verifySession();
let addReimbBtn = document.getElementById('addReimbBtn');
addReimbBtn.onclick = addReimb;
let backBtn = document.getElementById("backBtn");
backBtn.onclick = back;

function back(){
	if (getCookie("role")=="1"){
		window.location = 'http://localhost:8081/employee.html';
	}
	else if(getCookie("role")=="2"){
		window.location = 'http://localhost:8081/manager.html';
	}
	else window.location = 'http://localhost:8081/login.html';
}

function verifySession(){
	let cookieUser = getCookie("id");
	if (cookieUser == "" ){
		window.location = 'http://localhost:8081/login.html';
	}
}

function getCookie(value) {
  let name = value + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let cookies = decodedCookie.split(';');
  for(let i = 0; i <cookies.length; i++) {
    let value = cookies[i];
    while (value.charAt(0) == ' ') {
      value = value.substring(1);
    }
    if (value.indexOf(name) == 0) {
      return value.substring(name.length, value.length);
    }
  }
  return "";
}

function isMoney(input){
	try{
		let remainder = (input*100)%1;
		if (remainder==0){
			return true;
		}
		else{
			let para = document.createElement("p");
			para.setAttribute("style", "color:red");
			para.innerText = "Improper Dollar Amount";
			document.getElementsByClassName("addReimbForm")[0].appendChild(para);
			return false;
		}
	}catch(error){
		let para = document.createElement("p");
		para.setAttribute("style", "color:red");
		para.innerText = "Improper Dollar Amount";
		document.getElementsByClassName("addReimbForm")[0].appendChild(para);
	}
}

async function addReimb(){
  let reimb = getNewReimb();
  if(reimb != null){
	let response = await fetch(URL+"reimbs", {
		method:'POST',
		body:JSON.stringify(reimb),
		credentials:"include"
  });
  if(response.status===201){
    console.log("Reimbursement request submitted.");
  }else{
    console.log("Something went wrong submitting the request.");
  }}else{
	console.log("Something went wrong creating the request.");
  }
  back();
}

function getNewReimb(){
  if(document.querySelector('input[name="type"]:checked').value != null){
	let newAmount = document.getElementById("amount").value;
	if(isMoney(newAmount)){
		let newDescription = document.getElementById("description").value;
		let newSubmitted = Date.now();
		let reimb =  {
			reimbAmount:newAmount,
			reimbSubmitted:newSubmitted,
			reimbDescription:newDescription,
			reimbAuthor:getCookie("id"),
			reimbStatus:1,
			reimbType:document.querySelector('input[name="type"]:checked').value
		}
		return reimb;
	}
  }
  return null;
}