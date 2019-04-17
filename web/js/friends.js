var xhr3 = new XMLHttpRequest();
var xhr2 = new XMLHttpRequest();

function getFriends() {
    xhr3.open("GET", "Controller?action=GetFriends", true);
    xhr3.onreadystatechange = getFriendsData;
    xhr3.send(null);
}

function addFriend888(){
    var friendId = document.getElementById("addFriend").value;
    console.log(friendId)
    var information = "friendId=" + encodeURIComponent(friendId);
    console.log(information)
    xhr3.open("POST", "Controller?action=AddFriend", true);
    //xhr3.onreadystatechange = getFriendsData;
    xhr3.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr3.send(information);
    console.log(xhr3)
    getFriends();
}
function addFriend(){
    var friends = document.getElementById("addFriend").value;
    var information= "friendId=" + encodeURIComponent(friends);
    xhr2.open("POST", "Controller?action=AddFriend",true);
    xhr2.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr2.send(information);
    getFriends();

}

function getFriendsData() {
    if (xhr3.readyState == 4) {
        if (xhr3.status == 200) {
            var mapData = JSON.parse(xhr3.responseText);
            var friendsDiv = document.getElementById("friendsDiv");
            while (friendsDiv.firstChild != null) {
                friendsDiv.removeChild(friendsDiv.firstChild);
            }
            var table = document.createElement("table");
            var trh = document.createElement("tr");
            var thName = document.createElement("th");
            var thStatus = document.createElement("th");
            thName.appendChild(document.createTextNode("Name"));
            thStatus.appendChild(document.createTextNode("Status"));
            trh.appendChild(thName);
            trh.appendChild(thStatus);
            table.appendChild(trh);
            friendsDiv.appendChild(table);

            var map = new Map(Object.entries(mapData));
            map.forEach(function (value, key) {
                var obj = new Map(Object.entries(value));
                var tr = document.createElement("tr");
                table.appendChild(tr);
                obj.forEach(function (v, k) {
                    var name = document.createElement("td");
                    tr.appendChild(name);
                    name.appendChild(document.createTextNode(v));
                });
            });
            setTimeout("getFriends()", 1000);
        }
    }

}
function startChat(){
    getStatus();
    getFriends();
}