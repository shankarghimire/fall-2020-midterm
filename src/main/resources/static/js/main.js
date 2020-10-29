//alert("Testing");

const formMatrix = document.getElementById('form-matrix');
const readFromFile = document.querySelector('#readFromFile');
const rowSize= document.getElementById('rowSize');
const colSize = document.getElementById('colSize');
const thresHold = document.getElementById('thresHold');
const userOption = document.getElementById('userOption');
const errorElement = document.getElementById('error');
const errorRowSize = document.getElementById('errorRowSize');
const errorUserOption = document.querySelector('#errorUserOption');

window.addEventListener('load',(e)=>{
    // alert("testing");
},false);
formMatrix.addEventListener('submit',(e)=>{
    let messages = [];
    //if(rowSize.value < 1 ){
    //    messages.push("Row Size Cannot be negative!");
    //}
    if(userOption.value ==='-Choose an Option-'){
        messages.push("You must select one option!");
        errorUserOption.innerHTML = "You must select an option!";
        errorUserOption.style.color="red";
        errorUserOption.style.fontWeight="bold";
        errorUserOption.style.fontSize='10px';
    }
    if(messages.length > 0 ){
        e.preventDefault();
        // errorRowSize.innerHTML = messages[0];
        // errorRowSize.style.color="#ff0000";
        // errorRowSize.style.fontWeight="bold";
    }
});

readFromFile.addEventListener('change',(e)=>{
    if(readFromFile.checked){
        rowSize.disabled = true;
        colSize.disabled = true;
        thresHold.disabled = true;
    }else{
        rowSize.disabled = false;
        colSize.disabled = false;
        thresHold.disabled = false;
    }
},false);

userOption.addEventListener('change',(e)=>{

},false);

