const URL = "http://localhost:8081/";
window.onload = verifySession();

let addReimbBtn = document.getElementById("addReimbBtn");
addReimbBtn.onclick = addReimb;
let viewMyOpenBtn = document.getElementById("viewMyOpenBtn");
viewMyOpenBtn.onclick = viewMyOpen;
let viewMyAllBtn = document.getElementById("viewMyAllBtn");
viewMyAllBtn.onclick = viewMyAll;
let viewAllOpenBtn = document.getElementById("viewAllOpenBtn");
viewAllOpenBtn.onclick = viewAllOpen;
let viewByUserBtn = document.getElementById("viewByUserBtn");
viewByUserBtn.onclick = viewByUser;
let logoutBtn = document.getElementById("logoutBtn");
logoutBtn.onclick = logout;

function verifySession(){
	let cookieUser = getCookie("id");
	if (cookieUser == "" ){
		window.location = 'http://localhost:8081/login.html';
	}
	if (getCookie("role")=="1"){
		window.location = 'http://localhost:8081/employee.html';
	}
	else window.location = 'http://localhost:8081/login.html';
}
function getCookie(val) {
  let name = val + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let vals = decodedCookie.split(';');
  for(let i = 0; i <vals.length; i++) {
    let val = vals[i];
    while (val.charAt(0) == ' ') {
      val = val.substring(1);
    }
    if (val.indexOf(name) == 0) {
      return val.substring(name.length, val.length);
    }
  }
  return "";
}

function addReimb(){
	window.location = 'http://localhost:8081/addReimb.html';
}
function viewMyOpen(){
	window.location = 'http://localhost:8081/viewMyOpen.html';
}
function viewMyAll(){
	window.location = 'http://localhost:8081/viewMyAll.html';
}
function viewAllOpen(){
	window.location = 'http://localhost:8081/viewAllOpen.html';
}
function viewByUser(){
	window.location = 'http://localhost:8081/viewByUser.html';
}
function logout(){
	window.location = 'http://localhost:8081/logout.html';
}