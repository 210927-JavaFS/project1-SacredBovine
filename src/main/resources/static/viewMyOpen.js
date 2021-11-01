const URL = "http://localhost:8081/";
let backBtn = document.getElementById("backBtn");
backBtn.onclick = back;
window.onload = verifySession();

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
	getOpen();
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

async function getOpen(){
  let response = await fetch(URL+"reimbs/user/"+getCookie("id"));
  if(response.status===200){
    let data = await response.json();
	onlyOpen(data);
  }else{
    console.log("Reimbs not available. "+response);
  }
}

function onlyOpen(reimbs){
	let myOpen = [];
	for(i=0; i < reimbs.length; i++){ 
		let reimbTemp = {
			reimbAmount:null,
			reimbAuthor:{
				ersUserId:null,
				userFirstName:null,
				userLastName:null
			},
			reimbDescription:null,
			reimbId:null,
			reimbStatus:{
				status:null,
				statusId:null
			},
			reimbSubmitted:null,
			reimbType:{
				type:null,
				typeId:null
			}
		}	
		for(let cell in reimbs[i]){ 
			 switch (cell){ 	  
				case "reimbId":
					if(reimbs[i][cell]!=null){
						reimbTemp.reimbId = reimbs[i][cell];
					}			
					break;		  
				case "reimbAmount" :
					if(reimbs[i][cell]!=null){
						reimbTemp.reimbAmount = reimbs[i][cell];
					}			
					break;		  
				case "reimbSubmitted":
					if(reimbs[i][cell]!=null){
						let date = new Date(reimbs[i][cell]);
						reimbTemp.reimbSubmitted = date;
					}			
					break;	  		  
				case "reimbDescription":
					if(reimbs[i][cell]!=null){
						reimbTemp.reimbDescription = reimbs[i][cell];
					}
					break;		  
				case "reimbAuthor":
					if(reimbs[i][cell]!=null){
						reimbTemp.reimbAuthor.ersUserId = reimbs[i][cell].ersUserId
						reimbTemp.reimbAuthor.userFirstName = reimbs[i][cell].userFirstName
						reimbTemp.reimbAuthor.userLastName = reimbs[i][cell].userLastName;
					}		
					break;	
				case "reimbStatus":
					if(reimbs[i][cell]!=null){
						reimbTemp.reimbStatus.status = reimbs[i][cell].status;
						reimbTemp.reimbStatus.statusId = reimbs[i][cell].statusId;
					}
					break;					
				case "reimbType":
					if(reimbs[i][cell]!=null){
						reimbTemp.reimbType.type = reimbs[i][cell].type;
						reimbTemp.reimbType.typeId = reimbs[i][cell].typeId;
					}
					break;
			  }  
		}
		if(reimbTemp.reimbStatus.statusId==1){
			myOpen.push(reimbTemp);	
		}
	}
	populateReimbsTable(myOpen);
}

function populateReimbsTable(reimbs){	
  let tbody = document.getElementById("reimbBody");
  tbody.innerHTML="";
  for(let reimb of reimbs){
    let row = document.createElement("tr");
    let td0 = document.createElement("td");
	td0.innerText = reimb.reimbId;
	row.appendChild(td0);
	let td1 = document.createElement("td");
	td1.innerText = reimb.reimbAmount;
	row.appendChild(td1);
	let td2 = document.createElement("td");
	td2.innerText = reimb.reimbDescription;
	row.appendChild(td2);
	let td3 = document.createElement("td");
	td3.innerText = reimb.reimbAuthor.ersUserId + " : " + reimb.reimbAuthor.userFirstName + " " + reimb.reimbAuthor.userLastName;
	row.appendChild(td3);
	let td4 = document.createElement("td");
	td4.innerText = reimb.reimbSubmitted;
	row.appendChild(td4);
	let td5= document.createElement("td");
	td5.innerText = reimb.reimbType.type;
	row.appendChild(td5);
	let td6 = document.createElement("td");
	td6.innerText = reimb.reimbStatus.status;
	row.appendChild(td6);
    tbody.appendChild(row);
  }
} 
	

