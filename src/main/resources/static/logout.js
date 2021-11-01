const URL = "http://localhost:8081/";

window.onload = logout();

function logout(){
	document.cookie = "id= "; path="http://localhost";
	document.cookie = "name= "; path="http://localhost";
	document.cookie = "role= "; path="http://localhost";
	window.location = 'http://localhost:8081/login.html';
}