const URL = "http://localhost:8081/";
window.onload = verifySession();

let addReimbBtn = document.getElementById("addReimbBtn");
addReimbBtn.onclick = addReimb;
let viewOpenBtn = document.getElementById("viewOpenBtn");
viewOpenBtn.onclick = viewOpen;
let viewAllBtn = document.getElementById("viewAllBtn");
viewAllBtn.onclick = viewAll;
let logoutBtn = document.getElementById("logoutBtn");
logoutBtn.onclick = logout;

function verifySession(){
	let cookieUser = getCookie("id");
	if (cookieUser == "" ){
		window.location = 'http://localhost:8081/login.html';
	}
	if (getCookie("role")=="1"){
	}else if(getCookie("role")=="2"){
		window.location = 'http://localhost:8081/manager.html';
	}else window.location = 'http://localhost:8081/login.html';
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

function addReimb(){
	window.location = 'http://localhost:8081/addReimb.html';
}
function viewOpen(){
	window.location = 'http://localhost:8081/viewMyOpen.html';
}
function viewAll(){
	window.location = 'http://localhost:8081/viewMyAll.html';
}
function logout(){
	window.location = 'http://localhost:8081/logout.html';
}
	