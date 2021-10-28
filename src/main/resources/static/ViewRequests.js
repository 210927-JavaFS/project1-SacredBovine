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
		  case "reimbAuhor":
			if(reimb[cell]!=null) td.innerText = `${reimb[cell].ersUserId}:  ${reimb[cell].userFirstName}`;
			break;
		  case "reimbResolver":
			if(reimb[cell]!=null) td.innerText = `${reimb[cell].ersUserId}:  ${reimb[cell].userFirstName}`;
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
	  
	  
	  
	  /*if(cell!="home"){
        td.innerText=reimb[cell];
      }else if(reimb[cell]){
        td.innerText = `${reimb[cell].name}: ${reimb[cell].streetNumber} ${reimb[cell].streetName} ${reimb[cell].city } ${avenger[cell].region}, ${avenger[cell].zip} ${avenger[cell].country}`
      }*/
      row.appendChild(td);
    }
    tbody.appendChild(row);
  }
}