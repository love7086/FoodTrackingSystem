<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 8]> 
<html lang="en" class="ie8">
   <![endif]-->
<!--[if IE 9]> 
   <html lang="en" class="ie9">
      <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="UTF-8" />
<title>FoodTrackingSystem</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="" name="description" />
<meta content="" name="author" />
<!--[if IE]>
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <![endif]-->
<!-- GLOBAL STYLES -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/main.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/theme.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/MoneAdmin.css' />" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/font-awesome.css' />" />
<!--END GLOBAL STYLES -->
<!-- PAGE LEVEL STYLES -->
<link href="<c:url value='/resources/css/layout2.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/examples.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/timeline.css'/>"
	rel="stylesheet" />
<!-- END PAGE LEVEL  STYLES -->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
            <![endif]-->
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="padTop53 ">
	<!-- MAIN WRAPPER -->
	<div id="wrap">
		<!-- HEADER SECTION -->
		<div id="top">
			<nav class="navbar navbar-inverse navbar-fixed-top "
				style="padding-top: 10px;">
				<a data-original-title="Show/Hide Menu" data-placement="bottom"
					data-tooltip="tooltip"
					class="accordion-toggle btn btn-primary btn-sm visible-xs"
					data-toggle="collapse" href="#menu" id="menu-toggle"> <i
					class="icon-align-justify"></i>
				</a>
				<!-- LOGO SECTION -->
				<header class="navbar-header">
					<img src="<c:url value='/resources/img/logo.png'/>" alt="" />

				</header>

				<ul class="nav navbar-top-links navbar-right">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="icon-user "></i>&nbsp;
							<i class="icon-chevron-down "></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<!-- 							<li><a href="updateProfile.htm"><i class="icon-user"></i> -->
							<!-- 									User Profile </a></li> -->
							<!-- 							<li><a href="uploadPhoto.htm"><i class="icon-user"></i> -->
							<!-- 									Upload Photo </a></li> -->
							<li class="divider"></li>
							<li><a href="login.htm"><i class="icon-signout"></i>
									Logout </a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
		<div id="left">
			<div class="media user-media well-small">
				<a class="user-link" href="#"> <img
					class="media-object img-thumbnail user-img" alt="User Picture"
					src="<c:url value='/resources/img/user.gif' />" />
				</a> <br />
				<div class="media-body">
					<h5 class="media-heading">Admin</h5>
					<ul class="list-unstyled user-info">
						<li><a class="btn btn-success btn-xs btn-circle"
							style="width: 10px; height: 12px;"></a> Online</li>
					</ul>
				</div>
				<br />
			</div>
			<ul id="menu" class="collapse">
				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#network-nav"> <i class="icon-tasks"> </i> Network
						<span class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${networkCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="network-nav">
						<li class=""><a href="addNetwork1.htm"><i
								class="icon-angle-right"></i> Add Network </a></li>
						<li class=""><a href="updateNetwork.htm"><i
								class="icon-angle-right"></i> Update Network </a></li>
					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#enterprise-nav"> <i class="icon-tasks"> </i>
						Enterprise <span class="pull-right"> <i
							class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${enterpriseCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="enterprise-nav">
						<li class=""><a href="addEnterprise.htm"><i
								class="icon-angle-right"></i> Add Enterprise </a></li>
						<li class=""><a href="updateEnterprise.htm"><i
								class="icon-angle-right"></i> Update Enterprise </a></li>
					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#user-nav"> <i class="icon-file-text-alt"> </i>
						User <span class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${userCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="user-nav">
						<li class=""><a href="addUser.htm"><i
								class="icon-angle-right"></i> Add User </a></li>
						<li class=""><a href="updateUser.htm"><i
								class="icon-angle-right"></i> Update User </a></li>
					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#person-nav"> <i class="icon-user-md"> </i> Person
						<span class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${personCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="person-nav">
						<li class=""><a href="addPerson.htm"><i
								class="icon-angle-right"></i> Add Person </a></li>
						<li class=""><a href="updatePerson.htm"><i
								class="icon-angle-right"></i> Update Person </a></li>
					</ul></li>
			</ul>
		</div>
		<!--left-->

		<div id="content">
			<div class="panel panel-default">
				<div class="panel-heading">Available People</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table" id="PersonTable">
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Age</th>
									<th>User</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="person" items="${people}">
									<tr>
										<td><input class="" type="radio"
											value="${person.personId}" name="personId" /></td>
										<td><input class="formInput form-control" type="text"
											value="${person.name}" disabled /></td>
										<td><input class="formInput form-control" type="text"
											value="${person.age}" disabled /></td>
										<td><input class="formInput form-control" type="text"
											value="${person.user}" disabled /><input class=""
											type="hidden" value="${person.personId}"
											name="targetPersonId" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<form id="form1" role="form" action="" method="post">
				<h3 id="success">User successfully added!</h3>
				<h3 id="fail">User adding failed</h3>
				<div class="form-group">
					<h2>
						<label>Please input the detail information for user </label>
					</h2>
					<h3>
						<input class="form-control " id="userUsername" name="userUsername"
							placeholder="Username" type="text" />
					</h3>
					<h3>
						<input class="form-control" id="userPassword" name="userPassword"
							placeholder="Password" type="text">
					</h3>
					<h3>
						<input class="form-control" id="userRole" name="userRole"
							placeholder="Role" type="text">
					</h3>
					<input type="button" id="btn_submit"
						class="btn btn-success btn-lg btn-line" value="submit" />
				</div>
			</form>
		</div>
		<script src="<c:url value='/resources/js/jquery-2.1.1.min.js'/>"></script>
		<script src="<c:url value='/resources/js/bootstrap.min.js' /> "></script>
		<script
			src="<c:url value='/resources/js/modernizr-2.6.2-respond-1.1.0.min.js' /> "></script>
		<!-- END GLOBAL SCRIPTS -->
		<!-- PAGE LEVEL SCRIPTS -->
		<script src="<c:url value='/resources/js/jquery.flot.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.resize.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.time.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.stack.js' /> "></script>
		<script src="<c:url value='/resources/js/for_index.js' /> "></script>
		<script>
			$("#fail").hide();
			$("#success").hide();
			$("#btn_submit").click(
					function() {
						var personId = $("input:checked[name='personId']")
								.val();
						var userUsername = $("input[name='userUsername']")
								.val();
						var userPassword = $("input[name='userPassword']")
								.val();
						var userRole = $("input[name='userRole']").val();
						if (userUsername == "" || userPassword == ""
								|| userRole == "") {
							alert("Empty input detected!");
							return false;
						}
						if (personId == null) {
							alert("please select a person!");
							return false;
						}
						$.post("addUser2.htm", {
							"personId" : personId,
							"userUsername" : userUsername,
							"userPassword" : userPassword,
							"userRole" : userRole
						}, function(data) {
							var json = JSON.parse(data);
							if (json.flag == 1) {
								var personId = json.personId;
								var username = json.username;
								$("#fail").hide();
								$("#success").show();
								$("input+input[value=" + personId + "]").prev()
										.val(username);
							}
							if (json.flag == 2) {
								$("#success").hide();
								$("#fail").show();
							}
						});
						$("#userUsername").val("");
						$("#userPassword").val("");
						$("#userRole").val("");
					});
		</script>
	</div>
</body>
<!-- END BODY -->
</html>
