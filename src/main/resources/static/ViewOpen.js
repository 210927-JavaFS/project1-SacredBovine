const URL = "http://localhost:8081/";

let viewOpenButton = document.getElementById("viewOpenButton");
viewOpenButton.onclick = getOpen;
let approveBtn = document.getElementById("approveBtn");
let denyBtn = document.getElementById("denyBtn");
approveBtn.onclick = approveReimb;
denyBtn.onclick = denyReimb;

async function getById(id){
  let response = await fetch(URL+"reimbs/"+ id);
  if (response.status===200){
	  let reimb = await response.json();
	  console.log(reimb);
	  return reimb;
  }else{
	  console.log("encountered error");
	  return false;
  }
}
  
async function getOpen(){
  let response = await fetch(URL+"open");
  //console.log(response);
  if(response.status===200){
    let data = await response.json();
    populateReimbsTable(data);
  }else{
    console.log("Reimbs not available. "+response);
  }
}

async function updateReimb(reimb){
	if(reimb!=null){
		//console.log(reimb);
		//console.log(JSON.stringify(reimb));
		let response = await fetch(URL+"reimbs", {
			method:'PUT',
			body:JSON.stringify(reimb)
		});
	}
}

function populateReimbsTable(data){
  let tbody = document.getElementById("reimbBody");

  tbody.innerHTML="";

  for(let reimb of data){
	//  console.log(reimb);
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
				td.innerText = `${reimb[cell].ersUserID}: ${reimb[cell].userFirstName} ${reimb[cell].userLastName}`;
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


async function approveReimb(){
  let id = document.getElementById("reimbId").value;
 // console.log(JSON.stringify(reimb));
  if(id != null){
	let reimb = await getById(id);
	console.log(reimb);
	reimb.reimbStatus={
				statusId: 2,
				status: 'approved'
	};
	console.log(reimb);
	updateReimb(reimb);
  }
}
async function denyReimb(){
  let id = document.getElementById("reimbId").value;
 // console.log(JSON.stringify(reimb));
  if(id != null){
	let reimb = await getById(id);
	//console.log(reimb);
	reimb.reimbStatus={
				statusId: 3,
				status: 'denied'
	};
	updateReimb(reimb);
  }
}
