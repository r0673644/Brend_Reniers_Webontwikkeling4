var xhr5 = new XMLHttpRequest();

function getBlog() {
    xhr5.open("GET", "Controller?action=GetBlog", true);
    xhr5.onreadystatechange = getData;
    xhr5.send(null);
}

function getData(){
    if(xhr5.status==200 && xhr5.readyState == 4){
        var topics = JSON.parse(xhr5.responseText);
        var output = '';
        for (var i in topics){
            output +=
                '<div class="blog" id="blog" ><ul><li><h3>' + topics[i].thema + '</h3></li><li><strong>' + topics[i].description + '</strong></li>' +
                getComments(topics[i].comments )
                + '</ul></div>'
        }
        setTimeout(getBlog, 3000);
        document.getElementById("blogDiv").innerHTML = output;
    }
}

function getComments(comments) {
    var output = '';
    for (var j in comments) {
        console.log(comments[j].author);
        output +=
            '<li>' + 'Author: ' + comments[j].author.firstName + '</li>' +
            '<li>' + 'Comment: ' + comments[j].comment + '</li>' +
            '<li>' + 'Rating: ' + comments[j].rating + '</li><br>'
            }
    return output;
}

function getDataOud() {
    if (xhr5.status == 200) {
        if (xhr5.readyState == 4) {
            var serverResponse = JSON.parse(xhr5.responseText);

            var blogXML = serverResponse.status;

            var blogDiv = document.getElementById("blogDiv");
            var blogParagraph = blogDiv.childNodes[0];
            var blogText;

            if (blogParagraph === null) {
                blogParagraph = document.createElement('p');
                blogParagraph.id = "blogText";
                blogText = document.createTextNode(serverResponse);
                blogParagraph.appendChild(blogText);
                blogDiv.appendChild(blogParagraph);
            } else {
                blogText = document.createTextNode(blogXML);
                blogParagraph.removeChild(blogParagraph.childNodes[0]);
                blogParagraph.appendChild(blogText);
            }
        }
    }
}


