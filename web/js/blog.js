var xhr5;
var xhr2 = new XMLHttpRequest();

function getBlog() {
    xhr5 = new XMLHttpRequest();
    xhr5.open("GET", "Controller?action=GetBlog", true);
    xhr5.onreadystatechange = getData;
    xhr5.send(null);
}

function getData(){
    if(xhr5.status==200 && xhr5.readyState == 4){
        //console.log("getdatalog: " + xhr5.responseText);
        var topics = JSON.parse(xhr5.responseText);
        var output = '';
        for (var i in topics){
            output +=
                '<div class="blog" id="blog" ><ul><li><h3>' + topics[i].thema + '</h3></li><li><strong>' + topics[i].description + '</strong></li>' +
                getComments(topics[i].comments)
                + '</ul></div>'
        }
        document.getElementById("blogDiv").innerHTML = output;
    }
}

function getComments(comments) {
    var output = '';
    for (var j in comments) {
        output +=
            '<li>' + 'Author: ' + comments[j].author.firstName + '</li>' +
            '<li>' + 'Comment: ' + comments[j].comment + '</li>' +
            '<li>' + 'Rating: ' + comments[j].rating + '</li><br>'
            }
    return output;
}

function addComment(){
    var author = document.getElementById("authorinput").value;
    var commentText = document.getElementById("messageinput").value;
    var rating = document.getElementById("ratinginput").value;
    var topic = document.getElementById("topicnrinput").value;
    var information= "author=" + encodeURIComponent(author) +"&commentText=" + encodeURIComponent(commentText) + "&rating=" + encodeURIComponent(rating) + "&topic=" + topic;
    xhr2.open("POST", "Controller?action=AddComment",true);
    xhr2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr2.send(information);
    console.log("it got here");
    getBlog();
}


