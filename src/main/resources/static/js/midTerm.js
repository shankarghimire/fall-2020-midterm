//console.log("Testing midTerm.js ...");
//alert("Testing midTerm.js ...");

const formMatrix = document.getElementById("form-Matrix");
const rowSize = document.getElementById("rowSize");
const btnSearch = document.getElementById("btn-Search");
const divLabels = document.getElementById("div-labels");
const matrixData = document.getElementById('matrixData');




/*
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
	
	//let lblFirst = document.getElementById("lbl1");
	//lblFirst.innerHTML="A";
	//lblFirst.style.border="1px solid red";
	//lblFirst.style.width="20px";
	//lblFirst.style.textAlign="center";
	//lblFirst.style.backgroundColor="#ffffff";
	
	let text1 = document.getElementById("text1");
	//text1.value="testing!!!";
	text1.readOnly=true;
	text1.width="10";
	text1.style.color="red";
	
	document.forms['form-matrix']['text1'].setAttribute("value","Testing!!!");
	console.log("end of the btnSearch method ...");

},false);
*/

window.addEventListener('load',(e)=>{
	console.log("Testing the load event...");
	console.log("Matrix Size: " + rowSize.value);
	let data=[];
	let data2=[];
	data = matrixData.value;
	let index = 0;
	for(let i =0; i < data.length; i++){
		if(i % 2 === 0){
			data2[index] = data[i];
			index++;
			//console.log(data[i]);
		}
	}
	console.log('Data:' + data2);
	console.log('Data[0]:' + data2[0]);
	console.log('Data[1]:' + data2[1]);
	console.log('Data[2]:' + data2[2]);
	console.log('Data[3]:' + data2[3]);
	console.log('Data[4]:' + data2[4]);
	let bb = 0;
	bb= rowSize.value;
	divLabels.innerHTML="";
	divLabels.style.width= (bb * 25) + 'px';
	divLabels.style.height= (bb * 25) + 'px';
	
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
	index = 0;
	for(i = 0; i < rows; i++){
		for(j = 0; j < cols; j++){
			let newLabel = document.createElement("label");
			let lblId='lbl'+'-'+i+'-'+j;
			newLabel.setAttribute("id",lblId);
			divLabels.appendChild(newLabel);
			let lblCurrent = document.getElementById(lblId);
			lblCurrent.innerHTML= data2[index];
			index++;
			//lblCurrent.style.border="1px solid red";
			lblCurrent.style.width="20px";
			lblCurrent.style.textAlign="center";
			lblCurrent.style.backgroundColor="#ffffff";
			lblCurrent.style.margin="2px";
			lblCurrent.style.display="inline-block";
		}
		let varBr = document.createElement("br");
		divLabels.appendChild(varBr);
	}
		
	//let textElement = document.createElement("input");
	//textElement.setAttribute("type","text");
	//textElement.setAttribute("value","");
	//textElement.setAttribute("name","text1");
	//textElement.setAttribute("id","text1");
	

	//divLabels.appendChild(textElement);
	
	//let lblFirst = document.getElementById("lbl1");
	//lblFirst.innerHTML="A";
	//lblFirst.style.border="1px solid red";
	//lblFirst.style.width="20px";
	//lblFirst.style.textAlign="center";
	//lblFirst.style.backgroundColor="#ffffff";
	
	//let text1 = document.getElementById("text1");
	//text1.value="testing!!!";
	//text1.readOnly=true;
	//text1.width="10";
	//text1.style.color="red";
	
	//document.forms['form-matrix']['text1'].setAttribute("value","Testing!!!");
	console.log("end of the btnSearch method ...");

},false);