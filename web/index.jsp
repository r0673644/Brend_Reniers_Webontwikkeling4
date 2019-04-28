<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<body onload="getBlog()">
<jsp:include page="header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<main>
	<c:if test="${errors.size()>0 }">
		<div class="danger">
			<ul>
				<c:forEach var="error" items="${errors }">
					<li>${error }</li>
				</c:forEach>
			</ul>
		</div>
	</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>
		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out">
			</p>
		</form>
	</c:when>
	<c:otherwise>
		<form method="post" action="Controller?action=LogIn">
			<p>
				<label for="email">Your email </label>
				<input type="text" id="email" name="email" value="jan@ucll.be">
			</p>
			<p>
				<label for="password">Your password</label>
				<input type="password" id="password" name="password" value="t">
			</p>
			<p>
				<input type="submit" id="loginbutton" value="Log in">
			</p>
		</form>
	</c:otherwise>
</c:choose>
		<!--************************************************************************-->
		<h1>Blog</h1>
		<div id="blogDiv"></div>
		<div>
			<p>Name:</p>
			<input type="text" id="authorinput"/>
			<p>comment:</p>
			<input type="text" id="messageinput"/>
			<p>rating:</p>
			<input type="text" id="ratinginput"/>
			<p>commentnr:</p>
			<input type="text" id="commentnrinput"/>
		</div>
		<div>
			<button type="button" onclick="openSocket();" >Open</button>
			<button type="button" onclick="send();" >Send</button>
		</div>
		<div id="messages"></div>

		<script type="text/javascript">
			var webSocket;
			var messages = document.getElementById("messages");
			function openSocket(){
				webSocket = new WebSocket("ws://localhost:8080/echo");

				webSocket.onopen = function(event){
					writeResponse("Connection opened")
				};

				webSocket.onmessage = function(event){
					writeResponse(event.data);
				};

				webSocket.onclose = function(event){
					writeResponse("Connection closed");
				};
			}

			function send(){
				var text = document.getElementById("authorinput").value + ": " + document.getElementById("messageinput").value + ": " + document.getElementById("ratinginput") + ": " + document.getElementById("commentnrinput");
				webSocket.send(text);
			}

			function closeSocket(){
				webSocket.close();
			}

			function writeResponse(text){
				messages.innerHTML += "<br/>" + text;
			}
		</script>
		<script src="js/blog.js"></script>


		<!--************************************************************************-->
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>