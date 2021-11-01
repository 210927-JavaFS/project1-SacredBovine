const URL = "http://localhost:8081/";

let reimbButton = document.getElementById("viewReimbsButton");
reimbButton.onclick = getReimbs;

async function getReimbs(){
  let response = await fetch(URL+"reimbs", {credentials:"include"});
  
  if(response.status===200){
    let data = await response.json();
    populateReimbsTable(data);
  }else{
    console.log("Reimbs not available. "+response);
  }
}

function populateReimbsTable(data){
  let tbody = document.getElementById("reimbBody");

  tbody.innerHTML="";

  for(let reimb of data){
    let row = document.createElement("tr");

    for(let cell in reimb){
      let td = document.createElement("td");
      switch (cell){
		  case "reimbSubmitted":
			if(reimb[cell]!=null){
				let date = new Date(reimb[cell]);
				td.innerText = date;
			}
			break;
		  case "reimbResolved":
			if(reimb[cell]!=null){
				let date = new Date(reimb[cell]);
				td.innerText = date;
			}
			break;	
		  case "reimbAuthor":
			console.log(reimb[cell]);
			if(reimb[cell]!=null){
				td.innerText = `${reimb[cell].ersUserID}: ${reimb[cell].userFirstName} ${reimb[cell].userLastName}`;
			}
			break;
		  case "reimbResolver":
		  console.log(reimb[cell]);
			if(reimb[cell]!=null){
				td.innerText = `${reimb[cell].ersUserID}: ${reimb[cell].userFirstName} ${reimb[cell].userLastName}`;
			}
			break;
		  case "reimbStatus":
			if(reimb[cell]!=null) td.innerText = `${reimb[cell].status}`
			break;
		  case "reimbType":
			if(reimb[cell]!=null) td.innerText = `${reimb[cell].type}`
			break;
		  default :
			 td.innerText=reimb[cell];
			 break;
	  } 
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}