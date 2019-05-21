<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<body onload="startChat()">
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Chat"/>
</jsp:include>
<main>
    <p>Chat</p>
    <label for="statusDiv">Status : </label>
    <div id="statusDiv"></div>
    <input type="text" id="statusSubmit" onkeydown="if (event.keyCode == 13) document.getElementById('statusButton').click()"/>
    <input type="button" id="statusButton" value="Change" onclick="changeStatus();">
    <!--****************************************************************************************************************************************************-->
    <label for="friendsDiv"></label>
    <div id="friendsDiv"></div>

    <script src="js/status.js"></script>
    <script src="js/friends.js"></script>

    <input type="text" id="addFriend" onkeydown="if (event.keyCode == 13) document.getElementById('addFriendButton').click()"/>
    <input type="button" id="addFriendButton" value="Add Friend" onclick="addFriend();">
    <!--****************************************************************************************************************************************************-->
    <div id="chat"></div>
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $.ajax({
                type: "GET",
                url: "ChatServlet?action=overview",
                dataType: "json",
                success: function(json){
                    $(json).each(function(index, message){
                        $('#chat').append($('<p />').text(message.author.firstName + " : " + message.text));
                    })
                },
                error: function () {
                    alert("An error occured while loading chat.");
                }

            })
        })

    </script>
    <!--****************************************************************************************************************************************************-->
    <form method="post">
        <label>Message:</label>
        <input id="msgtext" name="msgtext" type="text"/>
        <input id="sendmsg" name="sendmsg" type ="button" value="send message"/>
    </form>

    <div id="newmsg" class="outputTextArea"></div>
    <script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#sendmsg").click(function () {
                $msgtext = document.getElementById("msgtext").value;
                $.post("ChatServlet",{msgtext:$msgtext},function(data){
                    var newParagraph = $('<p />').text(data);
                    $('#newmsg').append(newParagraph);
                });
            });

        });
    </script>

</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html