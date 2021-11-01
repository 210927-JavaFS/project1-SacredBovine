const URL = "http://localhost:8081/";

window.onload = verifySession();

let approveBtn = document.getElementById("approveBtn");
let denyBtn = document.getElementById("denyBtn");
approveBtn.onclick = approveReimb;
denyBtn.onclick = denyReimb;
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
	} else getOpen();
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

async function getByReimbId(reimbId){
  let reimbResponse = await fetch(URL+"reimbs/"+ reimbId);
  if (reimbResponse.status===200){
	  let reimb = await reimbResponse.json();
	  console.log(reimb);
	  return reimb;
  }else{
	  console.log("encountered error");
	  return false;
  }
} 

async function getByUserId(userId){
  let userResponse = await fetch(URL+"user/"+ userId);
  if (userResponse.status===200){
	  console.log(userResponse);
	  let reimbResolver = await userResponse.json();
	  console.log("getByUserId " + reimbResolver);
	  return reimbResolver;
  }else{
	  console.log("encountered error");
	  return false;
  }
} 

async function getOpen(){
  let response = await fetch(URL+"reimbs/open");
  if(response.status===200){
    let data = await response.json();
    populateReimbsTable(data);
  }else{
    console.log("Reimbs not available. "+response);
  }
}

async function updateReimb(reimb){
	if(reimb!=null){
		let response = await fetch(URL+"reimbs", {
			method:'PUT',
			body:JSON.stringify(reimb)
		});
	}
	getOpen();
}

async function approveReimb(){
  let id = document.getElementById("reimbId").value;
  if(id != null){
	let reimb = await getByReimbId(id);
	let ts=Date.now();
	reimb.reimbStatus={
				statusId: 2,
				status: 'approved'
	};
	resolver = await getByUserId(getCookie("id"));
	resolverObj = toUser(resolver);
	reimb.reimbResolver = resolverObj;
	reimb.reimbResolved=ts;
	updateReimb(reimb);
  }
}

async function denyReimb(){
  let id = document.getElementById("reimbId").value;
  if(id != null){
	let reimb = await getByReimbId(id);
	let ts=Date.now();
	reimb.reimbStatus={
				statusId: 3,
				status: 'denied'
	};
	resolver = await getByUserId(getCookie("id"));
	resolverObj = toUser(resolver);
	reimb.reimbResolver = resolverObj;
	reimb.reimbResolved=ts;
	updateReimb(reimb);
  }
}

function toUser(data){
	console.log("toUser ");
	console.log(data);
	let user = {
			ersUserId:data.ersUserId,
			ersUserName:data.ersUserName,
			ersPassword:data.ersPassword,			
			userFirstName:data.userFirstName,
			userLastName:data.userLastName,			
			userEmail:data.userEmail,
			userRole:{
				roleId:data.userRole.roleId,
				role:data.userRole.role
			}
		}	
	return user;
}
	
function populateReimbsTable(data){
  let tbody = document.getElementById("reimbBody");

  tbody.innerHTML="";

  for(let reimb of data){
    let row = document.createElement("tr");
    for(let cell in reimb){ 
	  let td = document.createElement("td");
	  switch (cell){ 	  
		  case "reimbId":
			if(reimb[cell]!=null){
				td.innerText = reimb[cell];
				row.appendChild(td);
			}			
			break;		  
		  case "reimbAmount" :
			if(reimb[cell]!=null){
				td.innerText = reimb[cell];
				row.appendChild(td);
			}			
			break;		  
		  case "reimbSubmitted":
			if(reimb[cell]!=null){
				let date = new Date(reimb[cell]);
				td.innerText = date;
				row.appendChild(td);
			}			
			break;	  		  
		  case "reimbDescription":
			if(reimb[cell]!=null){
				td.innerText = reimb[cell];
				row.appendChild(td);
			}
			break;		  
		  case "reimbAuthor":
			//console.log(reimb[cell]);
			if(reimb[cell]!=null){
				td.innerText = `${reimb[cell].ersUserId}: ${reimb[cell].userFirstName} ${reimb[cell].userLastName}`;
				row.appendChild(td);
			}		
			break;		  
		  case "reimbStatus":
			if(reimb[cell]!=null) {
				td.innerText = `${reimb[cell].status}`;
				row.appendChild(td);
			}
			break;		  
		  case "reimbType":
			if(reimb[cell]!=null){
				td.innerText = `${reimb[cell].type}`;
				row.appendChild(td);
			}		
	  }  
    }
    tbody.appendChild(row);
  }
} 