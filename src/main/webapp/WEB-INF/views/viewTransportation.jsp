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
	href="/FoodTrackingSystem/resources/css/googleMap.css" />
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
							<li><a href="uploadPhoto.htm"><i class="icon-user"></i>
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
						<li class=""><a href="viewTransportation.htm"><i
								class="icon-angle-right"></i> View transportation </a></li>

					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#food-nav"> <i class="icon-tasks"> </i> Food <span
						class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${foodCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="food-nav">
						<li class=""><a href="viewFood.htm"><i
								class="icon-angle-right"></i> View Food </a></li>

					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#comment-nav"> <i class="icon-tasks"> </i>
						Comments <span class="pull-right"> <i
							class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${CommentsCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="comment-nav">
						<li class=""><a href="addComment.htm"><i
								class="icon-angle-right"></i> Comment </a></li>
						<li class=""><a href="viewComments.htm"><i
								class="icon-angle-right"></i> View Comments </a></li>
					</ul></li>

			</ul>
		</div>
		<!--left-->
		<div id="content">
			<div class="panel panel-default">
				<div class="panel-heading">Available Transportation</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table" id="foodTable">
							<thead>
								<tr>
									<th>Food Name</th>
									<th>Supplier</th>
									<th>Harvest Date</th>
									<th>lat1</th>
									<th>lon1</th>
									<th>lat2</th>
									<th>lon2</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var="transportation" items="${transportationList}">
									<tr>
										<td><input style="margin-top: 0px"
											class="form-control form-input" type="text"
											value="${transportation.food.name}" /></td>
										<td><input class="form-control form-input" type="text"
											value="${transportation.food.supplier}" /></td>
										<td><input class="form-control " type="text"
											value="${transportation.food.harvestDate}" /></td>
										<td><input class="form-control " type="text"
											value="${transportation.lat1}" /></td>
										<td><input class="form-control " type="text"
											value="${transportation.lon1}" /></td>
										<td><input class="form-control " type="text"
											value="${transportation.lat2}" /></td>
										<td><input class="form-control " type="text"
											value="${transportation.lon2}" /></td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>



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
		<script
			src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCsSqvpcNwF3oRRBuc817eU_oBxLpwmhVc"></script>
	</div>
	<script>
		// 		var map;
		// 		var markers = [];

		// 		function initMap() {
		// 			var center = {
		// 				lat : 42.3398106,
		// 				lng : -71.0913604
		// 			};

		// 			map = new google.maps.Map(document.getElementById('googleMap'), {
		// 				zoom : 17,
		// 				center : center,
		// 				mapTypeId : google.maps.MapTypeId.TERRAIN
		// 			});
		// 		}
		// 		var infowindow1 = new google.maps.InfoWindow({
		// 			content : "Departure"
		// 		});

		// 		var infowindow2 = new google.maps.InfoWindow({
		// 			content : "Destination"
		// 		});
		// 		function addMarker(location) {
		// 			var marker = new google.maps.Marker({
		// 				position : location,
		// 				map : map
		// 			});

		// 		}

		// 		function setMapOnAll(map) {
		// 			for (var i = 0; i < markers.length; i++) {
		// 				markers[i].setMap(map);
		// 			}
		// 		}

		// 		function clearMarkers() {
		// 			setMapOnAll(null);
		// 		}

		// 		function deleteMarkers() {
		// 			lon1.val("");
		// 			lat1.val("");
		// 			lon2.val("");
		// 			lat2.val("");

		// 			clearMarkers();
		// 			markers = [];
		// 		}
		// 		google.maps.event.addDomListener(window, 'load', initMap);

		// 		var transportationId = $("input[name='transportationId']");
		// 		var showTransrportation = $("input[name='showTransportation']");
		// 		showTransrportation.click(function() {
		// 			alert(transportationId.val());
		// 			$.post("showTransportation.htm", {
		// 				"transportationId" : transportationId.val()
		// 			});
		// 		});
	</script>
</body>
<!-- END BODY -->
</html>
