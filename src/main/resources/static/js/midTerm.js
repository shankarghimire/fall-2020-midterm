//console.log("Testing midTerm.js ...");
//alert("Testing midTerm.js ...");

const formMatrix = document.getElementById("form-matrix");
const rowSize = document.getElementById("rowSize");
const searchText = document.getElementById('searchText');
const btnSearch = document.getElementById("btn-Search");
const divLabels = document.getElementById("div-labels");
const matrixData = document.getElementById('matrixData');
const startRow = document.getElementById('startRow');
const startCol = document.getElementById('startCol');
const endRow = document.getElementById('endRow');
const endCol = document.getElementById('endCol');
const btn1 = document.getElementById('btn1');
let lblId = "lbl-";


window.addEventListener('load',(e)=>{
	//console.log("Testing the load event...");
	//console.log("Matrix Size: " + rowSize.value);
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
	divLabels.style.width= (bb * 30) + 'px';
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
		
	//console.log("end of the Load method ...");

},false);


formMatrix.addEventListener('submit',(e)=>{
	console.log("Testing the click event of btn search...");
	console.log("Matrix Size: " + rowSize.value);
	//alert('Testing btn-Search click event!...');
	
	let startRowIndex = 0;
	let startColIndex = 0;
	let endRowIndex = 0;
	let endColIndex = 0;
	let matrixSize = 0;
	
	matrixSize = parseInt(rowSize.value);
	startRowIndex = parseInt(startRow.value);
	startColIndex = parseInt(startCol.value);
	endRowIndex = parseInt(endRow.value);
	endColIndex = parseInt(endCol.value);
	console.log("Start Row : " , startRowIndex);
	console.log("Start col: " , startColIndex);
	console.log("End Row : ", endRowIndex);
	console.log("EndCol : ", endColIndex);
	
	let i = 0;
	let j = 0;
	lblId = "";
	for(i = 0; i < matrixSize; i++){
		for(j = 0; j < matrixSize; j++){
			if( (i >= startRowIndex && i <= endRowIndex) && (j >= startColIndex && j <= endColIndex)){
				
				//lblId= "lbl-" + i + "-" + j;
				//document.getElementById(lblId).style.backgroundColor="#ffff00";
			}
		}
	}
	console.log("end of the btnSearch method ...");

},false);

btn1.addEventListener('click',(e)=>{
	console.log("Testing the click event of btn search...");
	console.log("Matrix Size: " + rowSize.value);
	//alert('Testing btn-Search click event!...');
	
	let startRowIndex = 0;
	let startColIndex = 0;
	let endRowIndex = 0;
	let endColIndex = 0;
	let matrixSize = 0;
	matrixSize = parseInt(rowSize.value);
	startRowIndex = parseInt(startRow.value);
	startColIndex = parseInt(startCol.value);
	endRowIndex = parseInt(endRow.value);
	endColIndex = parseInt(endCol.value);
	console.log("Start Row : " , startRowIndex);
	console.log("Start col: " , startColIndex);
	console.log("End Row : ", endRowIndex);
	console.log("EndCol : ", endColIndex);
	
	let i = 0;
	let j = 0;
	lblId = "";
	for(i = 0; i < matrixSize; i++){
		for(j = 0; j < matrixSize; j++){
			if( (i >= startRowIndex && i <= endRowIndex) && (j >= startColIndex && j <= endColIndex)){
				
				lblId= "lbl-" + i + "-" + j;
				document.getElementById(lblId).style.backgroundColor="#ffff00";
			}
		}
	}
	console.log("end of the btnSearch method ...");

},false);