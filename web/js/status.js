var xhr = new XMLHttpRequest();
var xhr2 = new XMLHttpRequest();

function changeStatus() {
    var statusText = document.getElementById("statusSubmit").value;
    var information = "status=" + encodeURIComponent(statusText);
    xhr2.open("POST", "Controller?action=ChangeStatus", true);
    xhr2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr2.send(information);
    getStatus();
}

function getStatus() {
    xhr.open("GET", "Controller?action=GetStatus", true);
    xhr.onreadystatechange = getData;
    xhr.send(null);
}

function getData() {
    if (xhr.status == 200) {
        if (xhr.readyState == 4) {
            var serverResponse = JSON.parse(xhr.responseText);
            var statusXML = serverResponse.status;

            var statusDiv = document.getElementById("statusDiv");
            var statusParagraph = statusDiv.childNodes[0];
            var statusText;

            if (statusParagraph == null) {
                statusParagraph = document.createElement('p');
                statusParagraph.id = "statusText";
                statusText = document.createTextNode(statusXML);
                statusParagraph.appendChild(statusText);
                statusDiv.appendChild(statusParagraph);
            } else {
                statusText = document.createTextNode(statusXML);
                statusParagraph.removeChild(statusParagraph.childNodes[0]);
                statusParagraph.appendChild(statusText);
            }
        }
    }
}


