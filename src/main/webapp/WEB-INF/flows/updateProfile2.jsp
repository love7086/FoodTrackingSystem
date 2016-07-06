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
<style>
input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
	margin: 0;
}
</style>
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
					<a href="index.html" class="navbar-brand"> <img
						src="<c:url value='/resources/img/logo.png'/>" alt="" />
					</a>
				</header>

				<ul class="nav navbar-top-links navbar-right">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="icon-user "></i>&nbsp;
							<i class="icon-chevron-down "></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="updateProfile.htm"><i class="icon-user"></i>
									User Profile </a></li>
							<li><a href="http://localhost:8080/FoodTrackingSystem/uploadPhoto.htm"><i class="icon-user"></i>
									Upload Photo </a></li>
							<li class="divider"></li>
							<li><a href="login.htm"><i class="icon-signout"></i>
									Logout </a></li>
						</ul></li>
				</ul>
			</nav>
		</div>
		<div id="left">
			<div class="media user-media well-small">
				<c:if test="${user.photoName!=null}">
					<img src="<c:url value='/resources/img/${user.photoName}'/>" alt=""
						height="150px" width="200px" />
				</c:if>
				<br />
				<div class="media-body">
					<h5 class="media-heading">${user.username }</h5>
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
					data-target="#transportation-nav"> <i class="icon-tasks"> </i>
						Transportation <span class="pull-right"> <i
							class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${transportationCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="transportation-nav">
						<li class=""><a
							href="http://localhost:8080/FoodTrackingSystem/viewTransportation.htm"><i
								class="icon-angle-right"></i> View transportation </a></li>

					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#food-nav"> <i class="icon-tasks"> </i> Food <span
						class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${foodCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="food-nav">
						<li class=""><a
							href="http://localhost:8080/FoodTrackingSystem/viewFood.htm"><i
								class="icon-angle-right"></i> View Food </a></li>

					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#comment-nav"> <i class="icon-tasks"> </i>
						Comments <span class="pull-right"> <i
							class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${commentCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="comment-nav">
						<li class=""><a
							href="http://localhost:8080/FoodTrackingSystem/addComment.htm"><i
								class="icon-angle-right"></i> Comment </a></li>
						<li class=""><a
							href="http://localhost:8080/FoodTrackingSystem/viewComments.htm"><i
								class="icon-angle-right"></i> View Comments </a></li>
					</ul></li>

			</ul>
		</div>
		<!--left-->
		<div id="content" class="pull-right">
			<form>
				<table>
					<tr>
						<td><label class="control-label">Region</label></td>
						<td><input type="text" class="form-control"
							value="${user.region}" name="region" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><label class="control-label">Phone</label></td>
						<td><input id="phoneInput" type="number" class="form-control"
							name="phone" value="${user.phone}" /></td>
					</tr>
					<tr>
						<td><label class="control-label">email address</label></td>
						<td><input id="phoneInput" type="email" class="form-control"
							name="emailAddress" value="${user.emailAddress}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><label class="control-label">Birth date
								mm-dd-yyyy</label></td>
						<td><input type="text" class="form-control" name="birthDate"
							value="${user.birthDate}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td><label class="control-label">Nick Name</label></td>
						<td><input type="text" class="form-control" name="nickName"
							value="${user.nickname}" /></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2"><a href="${flowExecutionUrl}&_eventId=back"><input
								id="back" class="btn btn-warning btn-lg" type="button"
								value="Back" /></a></td>
						<td colspan="2"><input id="next"
							class="btn btn-success btn-lg" type="button" value="Save Changes" />
						</td>
					</tr>
				</table>
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
	</div>
	<script>
		$("#next")
				.click(
						function() {
							var region = $("input[name=region]");
							var phone = $("input[name=phone]");
							var birthDate = $("input[name=birthDate]");
							var nickName = $("input[name=nickName]");
							var emailAddress = $("input[name=emailAddress]");
							if (region.val() == "" || !region.val()) {
								alert("Empty region!");
								return false;
							}
							if (phone.val() == "" || !phone.val()) {
								alert("Empty phone!");
								return false;
							}
							if (birthDate.val() == "" || !birthDate.val()) {
								alert("Empty birthDate!");
								return false;
							}
							if (nickName.val() == "" || !nickName.val()) {
								alert("Empty nickName!");
								return false;
							}
							var validformat = /^\d{2}\/\d{2}\/\d{4}$/ //Basic check for format validity
							var returnval = false

							var monthfield = birthDate.val().split("-")[0]
							var dayfield = birthDate.val().split("-")[1]
							var yearfield = birthDate.val().split("-")[2]
							var dayobj = new Date(yearfield, monthfield - 1,
									dayfield)
							if ((dayobj.getMonth() + 1 != monthfield)
									|| (dayobj.getDate() != dayfield)
									|| (dayobj.getFullYear() != yearfield))
								alert("Invalid Day, Month, or Year range detected. Please correct and submit again.")
							else
								returnval = true

							if (returnval == false)

								return returnval;
							$.post("updateEnd2.htm", {
								"region" : region.val(),
								"phone" : phone.val(),
								"birthDate" : birthDate.val(),
								"nickname" : nickName.val(),
								"emailAddress" : emailAddress.val()
							});
							var str = "${flowExecutionUrl}&_eventId=next";
							window.location.href = str;
						});
	</script>
</body>
<!-- END BODY -->
</html>
