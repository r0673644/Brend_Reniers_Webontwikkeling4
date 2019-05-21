// version of getNewQuote with plain old JavaScript code only
var xHRObject = new XMLHttpRequest();

function getNewQuote () {
    xHRObject.open("GET", "ChatServlet", true);
    xHRObject.onreadystatechange = getData;
    xHRObject.send(null);
}

function getData () {
    if (xHRObject.status == 200) {
        if (xHRObject.readyState == 4) {
            var serverResponse = JSON.parse(xHRObject.responseText);
            var Comments = serverResponse.comments;

            var quoteDiv = document.getElementById("chat");
            var quoteParagraph = quoteDiv.childNodes[0];

            if (quoteParagraph == null) {
                quoteParagraph = document.createElement('p');
                quoteParagraph.id = "chatText";
                var chatText = document.createTextNode(chat);
                quoteParagraph.appendChild(chatText);
                chatDiv.appendChild(chatParagraph);
            }
            else {
                var chatText = document.createTextNode(chat);
                chatParagraph.removeChild(chatParagraph.childNodes[0]);
                chatParagraph.appendChild(chatText);
            }
            setTimeout(getchat, 2000);
        }
    }
}