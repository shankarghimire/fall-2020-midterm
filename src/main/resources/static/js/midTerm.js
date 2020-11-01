//console.log("Testing midTerm.js ...");
//alert("Testing midTerm.js ...");

const formMatrix = document.getElementById("form-Matrix");
const rowSize = document.getElementById("rowSize");
const btnSearch = document.getElementById("btn-Search");
const divLabels = document.getElementById("div-labels");


btnSearch.addEventListener('click',(e)=>{
	console.log("Testing the click event of btn search...");
	console.log("Matrix Size: " + rowSize.value);
	let bb = 0;
	bb= rowSize.value;
	divLabels.innerHTML="";
	divLabels.style.width= (bb * 30) + 'px';
	divLabels.style.height= (bb * 30) + 'px';
	
	let labelElement = document.createElement("label");
	let aa = "test";
	//labelElement.setAttribute("value",aa);
	//labelElement.setAttribute("id","lbl1");
	labelElement.setAttribute("for","text1");
	divLabels.appendChild(labelElement);
	let i=0;
	let j=0;
	let rows = parseInt( rowSize.value);
	let cols = parseInt( rowSize.value);
	for(i = 0; i < rows; i++){
		for(j = 0; j < cols; j++){
			let newLabel = document.createElement("label");
			let lblId='lbl'+'-'+i+'-'+j;
			newLabel.setAttribute("id",lblId);
			divLabels.appendChild(newLabel);
			let lblCurrent = document.getElementById(lblId);
			lblCurrent.innerHTML="A";
			//lblCurrent.style.border="1px solid red";
			lblCurrent.style.width="20px";
			lblCurrent.style.textAlign="center";
			lblCurrent.style.backgroundColor="#ffffff";
			lblCurrent.style.margin="3px";
			lblCurrent.style.display="inline-block";
		}
		let varBr = document.createElement("br");
		divLabels.appendChild(varBr);
	}
		
	let textElement = document.createElement("input");
	textElement.setAttribute("type","text");
	textElement.setAttribute("value","");
	textElement.setAttribute("name","text1");
	textElement.setAttribute("id","text1");
	

	divLabels.appendChild(textElement);
	/*
	let lblFirst = document.getElementById("lbl1");
	lblFirst.innerHTML="A";
	lblFirst.style.border="1px solid red";
	lblFirst.style.width="20px";
	lblFirst.style.textAlign="center";
	lblFirst.style.backgroundColor="#ffffff";
	*/
	let text1 = document.getElementById("text1");
	//text1.value="testing!!!";
	text1.readOnly=true;
	text1.width="10";
	text1.style.color="red";
	
	document.forms['form-matrix']['text1'].setAttribute("value","Testing!!!");
	console.log("end of the btnSearch method ...");

},false);