const URL = "http://localhost:8081/";

let addReimbButton = document.getElementById('addReimbButton');
addReimbButton.onclick = addReimb;




function getNewReimb(){
  if(document.querySelector('input[name="type"]:checked').value != null){
	let newAmount = document.getElementById("amount").value; 
	let newDescription = document.getElementById("description").value;
	let newSubmitted = Date.now();
	let reimb =  {
		reimbAmount:newAmount,
		reimbSubmitted:newSubmitted,
		reimbDescription:newDescription,
		//reimbAuthor:1,
		reimbStatus:1,
		reimbType:document.querySelector('input[name="type"]:checked').value
	}
	return reimb;
  }
  return null;
}


async function addReimb(){
  let reimb = getNewReimb();
  console.log(JSON.stringify(reimb));
  if(reimb != null){
	let response = await fetch(URL+"reimbs", {
		method:'POST',
		body:JSON.stringify(reimb),
		credentials:"include"
  });
  if(response.status===201){
    console.log("Reimbursement request submitted.");
  }else{
    console.log("Something went wrong submitting the request.");
  }}else{
	  console.log("Something went wrong creating the request.");
  }
}
