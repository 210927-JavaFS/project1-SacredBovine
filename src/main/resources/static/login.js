const URL = "http://localhost:8081/";


let loginBtn = document.getElementById("loginBtn");
loginBtn.onclick = login;

async function login(){
  let loginReq = {
    username:document.getElementById("username").value,
    password:document.getElementById("password").value
  }
  console.log(loginReq);
  let response = await fetch(URL+"login", {
    method:"POST",
    body:JSON.stringify(loginReq),
    credentials:"include" //This will save the cookie when we receive it. 
  });
  if(response.status===200){
    let data = await response.json();
	let user={
		userID:data.id,
		username:data.name,
		userRole:data.role
	}
	document.cookie = "id="+user.userID;
	document.cookie = "name="+user.username;
	document.cookie = "role="+user.userRole;
	redirect(user);
  }
  else{
    let para = document.createElement("p");
    para.setAttribute("style", "color:red")
    para.innerText = "LOGIN FAILED"
    document.getElementsByClassName("formClass")[0].appendChild(para);
  }
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

function redirect(user){
	console.log("id: "+getCookie("id")+" name: "+getCookie("name")+" role: "+getCookie("role"));
	if (user.userRole == 1){
		//redirect to employee page
	} else if(user.userRole ==2){
		//redirect to manager page
	}
	else{
		//Who are you?
	}
}
	