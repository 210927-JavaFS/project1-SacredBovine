const URL = "http://localhost:8081/";
window.onload = verifySession();

function verifySession(){
	let cookieUser = getCookie("id");
	if (cookieUser == "" ){
		window.location = 'http://localhost:8081/login.html';
	}
}

let addReimbBtn = document.getElementById("addReimbBtn");
addReimbBtn.onclick = addReimb;
let viewOpenBtn = document.getElementById("viewOpenBtn");
viewOpenBtn.onclick = viewOpen;
let viewAllBtn = document.getElementById("viewAllBtn");
viewAllBtn.onclick = viewAll;
let logoutBtn = document.getElementById("logoutBtn");
logoutBtn.onclick = logout;

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
function viewOpen(){
	window.location = 'http://localhost:8081/viewMyOpen.html';
}
function viewAll(){
	window.location = 'http://localhost:8081/viewMyAll.html';
}
function logout(){
	window.location = 'http://localhost:8081/logout.html';
}
	