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
    <label for="friendsDiv"></label>
    <div id="friendsDiv"></div>

    <script src="js/status.js"></script>
    <script src="js/friends.js"></script>

    <input type="text" id="addFriend" onkeydown="if (event.keyCode == 13) document.getElementById('addFriendButton').click()"/>
    <input type="button" id="addFriendButton" value="Add Friend" onclick="addFriend();">
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>
</body>
</html>