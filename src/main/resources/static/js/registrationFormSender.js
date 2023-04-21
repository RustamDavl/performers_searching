
    var form = document.querySelector('#regForm');
    form.addEventListener('submit', (e) => {
        e.preventDefault();
    
    
    var formData = new FormData(regForm);
    var object = {};
    formData.forEach(function(value, key){
        object[key] = value;
    });
    var jsonRegForm = JSON.stringify(object);
    
    
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/api/v1/people", true);
    
    xhr.setRequestHeader("Accept", "application/json");
    xhr.setRequestHeader("Content-type", "application/json");   
    xhr.send(jsonRegForm);
    
    
    
    xhr.onload = () => {
        if(xhr.status == 201 || xhr.status == 200)
        window.location.href="/pages/mainExecutorPage.html";
    }
    
    })

    

