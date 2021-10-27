const URL = "http://localhost:8082/"

letbuttonRow = document.getElementById("buttonRow")
let reimbButton = document.createElement("button");
let addReimbButton = document.getElementById('addHomeButton');
let loginButton = document.getElementById('loginButton');

reimbButton.onclick = getReimbs;
addReimbButton.onclick = addReimb;
loginButton.onclick = loginToApp;

reimbButton.innerText= "View Reimbursements";
addReimButton.innerText= "Submit Request";

async function loginToApp(){
    let user = {
        username:document.getElementById("username").value,
        password:document.getElementById("password").value
    }

    let response = await fetch(URL+"login", {
        method:"POST",
        body:JSON.stringify(user),
        credentials:"include" //this will save the cookie when we revieve it
    });

    if(response.status===200){
        document.getElementsByClassName("formClass")[0].innerHTML='';
        buttonRow.appendChild(avengerButton);
        buttonRow.appendChild(homeButton);
    }
    else{
        let para = document.createElement("p");
        para.setAttribute("style", "color:red")
        para.innerText = "LOGIN FAILED"
        document.getElementsByClassName("formClass")[0].appendChild(para);
    }
}

async function getAvengers(){
    let response = await fetch(URL+"avengers", {credentials:"include"});
    
    if(response.status === 200){
        let data = await response.json();
        populateAvengersTable(data);
    }else{
        console.log("No response fetching Avengers");
    }
}

function populateAvengersTable(data){
    let tbody = document.getElementById('avengerBody');

    tbody.innerHTML=""; // will clear the table before populating in case use clicks button a bunch

    for(let avenger of data) {
        let row = document.createElement("tr");

        for(let cell in avenger) {
            let td = document.createElement('td');
            if(cell!="home") {
                td.innerText=avenger[cell];
            }else if(avenger[cell]) {
                td.innerText= `${avenger[cell].name}: ${avenger[cell].streetNumber} ${avenger[cell].streetName} ${avenger[cell].city}, ${avenger[cell].region} ${avenger[cell].zip} ${avenger[cell].country}`;
            }
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }  
}

async function getHomes() {
    let response = await fetch(URL+"homes", {credentials:"include"});
    if(response.status === 200) {
        let data = await response.json();
        populateHomesTable(data);
    }else{
        console.log("No response from Homes");
    }
    
}

function populateHomesTable(data) {
    let tbody = document.getElementById('homeBody');

    tbody.innerHTML=""; // will clear the table before populating in case use clicks button a bunch

    for(let home of data) {
        let row = document.createElement("tr");
        for(let cell in home) {
            let td = document.createElement('td');
            td.innerText=home[cell];
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }  
}

function getNewReimb(){
    let newReimbType = document.getElementById("type").value;
    let newstreetNum = document.getElementById("homeStreetNum").value;
    let newstreetName = document.getElementById("homeStreetName").value;
    let newCity = document.getElementById("homeCity").value;
    let newRegion = document.getElementById("homeRegion").value;
    let newZip = document.getElementById("homeZipcode").value;
    let newCountry = document.getElementById("homeCountry").value;

    let home = {
        name:newName,
        streetNumber:newstreetNum,
        streetName:newstreetName,
        city:newCity,
        region:newRegion,
        zip:newZip,
        country:newCountry
    }
    return home;
}

async function addHome(){
    let home =  getNewHome();
    let response = await fetch(URL+"homes", {
    method:'POST',
    body:JSON.stringify(home)
    });
    if(response.status===201){
        console.log("Home created successfuly");
    }else {
        console.log("Error creating Home");
    }
}