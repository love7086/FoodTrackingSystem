<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>Welcome to Food Tracking System!</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
<!-- GLOBAL STYLES -->
<!-- PAGE LEVEL STYLES -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>" />
<link rel="stylesheet" href=" <c:url value='/resources/css/magic.css'/>" />
<!-- END PAGE LEVEL STYLES -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
<style>
body {
	background-image:
		url("<c:url value='/resources/img/Growing-Food-Security-logo_trans.png'/>");
	background-repeat: no-repeat;
	background-size: 45% 135%;
	background-position: 50% -300%;
}
</style>
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body>

	<!-- PAGE CONTENT -->
	<div class="container">
		<div class="text-center">
			<img src="<c:url value='/resources/img/logo.png'/>" id="logoimg"
				alt=" Logo" />
		</div>
		<div class="tab-content">
			<div id="login" class="tab-pane active">
				<form action="login.htm" class="form-signin" method="post">
					<c:choose>
						<c:when test="${fail}">
							<p
								class="text-muted text-center btn-block btn btn-primary btn-rect">
								The username password pair doesn't match!</p>
						</c:when>
						<c:otherwise>
							<p
								class="text-muted text-center btn-block btn btn-primary btn-rect">
								Enter your username and password
								<c:out value="${fail}" />
							</p>
						</c:otherwise>
					</c:choose>
					<input type="text" placeholder="Username" name="username"
						class="form-control" /> <input type="password"
						placeholder="Password" name="password" class="form-control" /> <input
						type="hidden" name="action" value="login" />
					<button id="loginButton"
						class="btn text-muted text-center btn-danger" type="submit">Sign
						in</button>
				</form>
			</div>
			<div id="forgot" class="tab-pane">
				<form action="" class="form-signin">
					<p
						class="text-muted text-center btn-block btn btn-primary btn-rect">Enter
						your valid e-mail</p>
					<input type="email" required="required" placeholder="Your E-mail"
						class="form-control" id="recoverEmail" /> <br /> <input
						class="btn text-muted text-center btn-success"
						value="Recover Password" id="recover" type="button" />
				</form>
			</div>
			<div id="signup" class="tab-pane">
				<form action="" id="registerForm" class="form-signin">
					<p id="ptag"
						class="text-muted text-center btn-block btn btn-primary btn-rect">Please
						Fill Details To Register</p>
					<input type="text" placeholder="Name" name="name"
						class="form-control" /> <input type="number" placeholder="Age"
						name="age" class="form-control" /> <input type="text"
						placeholder="Address" name="address" class="form-control" /> <input
						type="text" placeholder="Username" name="username" id="username"
						class="form-control" /> <input name="password1" type="password"
						placeholder="password" class="form-control" /> <input
						name="password2" type="password" placeholder="Re type password"
						class="form-control" /> <input type="hidden" name="action"
						value="register" /> <input type="button" id="registerButton"
						class="btn text-muted text-center btn-success" value="Register" />
				</form>
			</div>
		</div>
		<div class="text-center">
			<ul class="list-inline">
				<li><a class="text-muted" href="#login" data-toggle="tab">Login</a></li>
				<li><a class="text-muted" href="#forgot" data-toggle="tab">Forgot
						Password</a></li>
				<li><a class="text-muted" href="#signup" data-toggle="tab">Signup</a></li>
			</ul>
		</div>


	</div>

	<!--END PAGE CONTENT -->

	<!-- PAGE LEVEL SCRIPTS -->
	<script src="<c:url value='/resources/js/jquery-2.0.3.min.js' /> "></script>
	<script src="<c:url value='/resources/js/bootstrap.js' /> "></script>
	<script src="<c:url value='/resources/js/login.js' /> "></script>
	<!--END PAGE LEVEL SCRIPTS -->
	<script>
		$("#loginButton").click(function() {
			var username = $("input[name='username']").val();
			var password = $("input[name='password']").val();
			if (!username || username == "" || !password || password == "") {
				alert("Empty input detected");
				return false;
			}

		});
		$("#recover").click(function() {
			var recoverEmail = $("#recoverEmail").val();
			$.post("recover.htm", {
				"recoverEmail" : recoverEmail
			}).done(function(data) {
				var json = JSON.parse(data);
				var flag = json.flag;
				if (flag == 1) {
					var username = json.username;
					var password = json.password;
					alert("Username : " + username);
					alert("Password : " + password);
				} else {
					alert("This email has not been registered");
				}
			});
		});

		$("#registerButton")
				.click(
						function() {
							var password1 = $("input[name=password1]").val();
							var password2 = $("input[name=password2]").val();
							var name = $("input[name=name]").val();
							var address = $("input[name=address]").val();
							var username = $("#username").val();
							var age = $("input[name=age]").val();
														if (password1 == "" || password2 == ""
															|| name == ""|| address == ""|| username == ""|| age == "") {
														alert("Empty input detected!");
														return false;
													}
							if (password1 != password2) {
								alert("password doesn't match!")
								return false;
							}
							if (!($.isNumeric(age) && Math.floor(age) == age)) {
								alert("invalid input detected!");
								return false;
							}
							$
									.post("register.htm",
											$("#registerForm").serialize())
									.done(
											function(data) {

												var ptag = $("#ptag");
												var json = JSON.parse(data);
												ptag.text(json.message);
												var flag = json.flag;
												if (flag == 1) {
													setTimeout(
															function() {
																window.location.href = "/FoodTrackingSystem/customerIndex.htm";
															}, 2000);
												}
											});
						});
	</script>
</body>
<!-- END BODY -->
</html>
