<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<body>
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
		<!--******************************************************************************************************-->
		<h2>Wat vind u van het nieuwste liedje van Marshmello?</h2>
		<div id="messages1"></div>
		<div>
			<p>
				<input type="text" id="comment1" value="comment"/>
				<input type="number"id="number1" value="5"/>
				<button type="button" id="button1" onclick="send1();" >Send</button>
			</p>
			<script type="text/javascript">
				var webSocket= new WebSocket("ws://localhost:8080/echo");
				var messages1=document.getElementById("messages1");



				function send1(){
					var comment = document.getElementById("comment1").value;
					var numberUnchecked = document.getElementById("number1").value;
					var number;

					if(numberUnchecked<=10&&numberUnchecked>=0){
						number = numberUnchecked;
					}
					else if (numberUnchecked>10){
						number = 10;
					}
					else{
						number = 0;
					}


					webSocket.onmessage = function(event){
						writeResponse1(event.data);
					}
					webSocket.send( comment + "| score : " + number);

				}

				function writeResponse1(text){
					messages1.innerHTML += "<br/>" + text;

				}
			</script>
			<!--************************************************************************-->
			<h2>Wat vind is uw favoriete game?</h2>
			<div id="messages2"></div>
			<div>
				<p>
					<input type="text" id="comment2" value="comment"/>
					<input type="number"id="number2" value="5"/>
					<button type="button" id="button2" onclick="send2();" >Send</button>
				</p>
				<script type="text/javascript">
					var webSocket= new WebSocket("ws://localhost:8080/echo");
					var messages2=document.getElementById("messages2");



					function send2(){
						var comment = document.getElementById("comment2").value;
						var numberUnchecked = document.getElementById("number2").value;
						var number;

						if(numberUnchecked<=10&&numberUnchecked>=0){
							number = numberUnchecked;
						}
						else if (numberUnchecked>10){
							number = 10;
						}
						else{
							number = 0;
						}

						webSocket.onmessage = function(event){
							writeResponse2(event.data);
						}
						webSocket.send( comment + "| score : " + number);
					}

					function writeResponse2(text){
						messages2.innerHTML += "<br/>" + text;
					}
				</script>
				<!--************************************************************************-->
				<h2>Wie is uw favoriete twitch Streamer/youtuber?</h2>
				<div id="messages3"></div>
				<div>
					<p>
						<input type="text" id="comment3" value="comment"/>
						<input type="number"id="number3" value="5"/>
						<button type="button" id="button3" onclick="send3();" >Send</button>
					</p>
					<script type="text/javascript">
						var webSocket= new WebSocket("ws://localhost:8080/echo");
						var messages3=document.getElementById("messages3");



						function send3(){
							var comment = document.getElementById("comment3").value;
							var numberUnchecked = document.getElementById("number3").value;
							var number;

							if(numberUnchecked<=10&&numberUnchecked>=0){
								number = numberUnchecked;
							}
							else if (numberUnchecked>10){
								number = 10;
							}
							else{
								number = 0;
							}

							webSocket.onmessage = function(event){
								writeResponse3(event.data);
							}
							webSocket.send( comment + "| score : " + number);

						}

						function writeResponse3(text){
							messages3.innerHTML += "<br/>" + text;
						}
					</script>
					<!--************************************************************************-->
					<h2>Wie is uw favoriete bekende persoon?</h2>
					<div id="messages4"></div>
					<div>
						<p>
							<input type="text" id="comment4" value="comment"/>
							<input type="number"id="number4" value="5"/>
							<button type="button" id="button4" onclick="send4();" >Send</button>
						</p>
						<script type="text/javascript">
							var webSocket= new WebSocket("ws://localhost:8080/echo");
							var messages4=document.getElementById("messages4");



							function send4(){
								var comment = document.getElementById("comment4").value;
								var numberUnchecked = document.getElementById("number4").value;
								var number;

								if(numberUnchecked<=10&&numberUnchecked>=0){
									number = numberUnchecked;
								}
								else if (numberUnchecked>10){
									number = 10;
								}
								else{
									number = 0;
								}

								webSocket.onmessage = function(event){
									writeResponse4(event.data);
								}
								webSocket.send( comment + "| score : " + number);

							}

							function writeResponse4(text){
								messages4.innerHTML += "<br/>" + text;
							}
						</script>
						<!--************************************************************************-->
						<h2>Wat vind u ervan dat 100T cwl London heeft gewonnen?</h2>
						<div id="messages5"></div>
						<div>
							<p>
								<input type="text" id="comment5" value="comment"/>
								<input type="number"id="number5" value="5"/>
								<button type="button" id="button5" onclick="send5();" >Send</button>
							</p>
							<script type="text/javascript">
								var webSocket= new WebSocket("ws://localhost:8080/echo");
								var messages5=document.getElementById("messages5");



								function send5(){
									var comment = document.getElementById("comment5").value;
									var numberUnchecked = document.getElementById("number5").value;
									var number;

									if(numberUnchecked<=10&&numberUnchecked>=0){
										number = numberUnchecked;
									}
									else if (numberUnchecked>10){
										number = 10;
									}
									else{
										number = 0;
									}

									webSocket.onmessage = function(event){
										writeResponse5(event.data);
									}
									webSocket.send( comment + "| score : " + number);

								}

								function writeResponse5(text){
									messages5.innerHTML += "<br/>" + text;
								}
							</script>
<!----------------------------------------------------------------------------------------------------->
		<jsp:include page="footer.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>