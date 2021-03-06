const URL = "http://localhost:8081/";

let loginBtn = document.getElementById("loginBtn");
loginBtn.onclick = login;

async function login(){
  let loginReq = {
    username:document.getElementById("username").value,
    password:document.getElementById("password").value
  }

  let response = await fetch(URL+"user/login", {
    method:"POST",
    body:JSON.stringify(loginReq),
    credentials:"include" 
  });
  if(response.status===200){
    let data = await response.json();
	let user={
		userId:data.id,
		username:data.name,
		userRole:data.role
	}
	var expires = (new Date(Date.now()+ 60)).toUTCString();
	document.cookie = "id="+user.userId; "expires="+expires; path="http://localhost";
	document.cookie = "name="+user.username; "expires="+expires; path="http://localhost";
	document.cookie = "role="+user.userRole; "expires="+expires; path="http://localhost";
	redirect(user);
  }
  else{
    let para = document.createElement("p");
    para.setAttribute("style", "color:red")
    para.innerText = "LOGIN FAILED"
    document.getElementsByClassName("formClass")[0].appendChild(para);
  }
}

function redirect(user){
	if (user.userRole == 1){
		window.location.replace('http://localhost:8081/employee.html');
	} else if(user.userRole ==2){
		window.location.replace('http://localhost:8081/manager.html');
	}
	else{
		//Who are you?
		window.location.replace('http://localhost:8081/login.html');
	}
}
	