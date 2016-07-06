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
<link rel="stylesheet"
	href="/FoodTrackingSystem/resources/css/googleMap.css" />
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
				<header class="navbar-header">
					<img
						src="<c:url value='/resources/img/logo.png'/>" alt="" />
				</header>

				<ul class="nav navbar-top-links navbar-right">

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="icon-user "></i>&nbsp;
							<i class="icon-chevron-down "></i>
					</a>
						<ul class="dropdown-menu dropdown-user">
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
					<h5 class="media-heading">${user.username}</h5>
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
					data-target="#Food-nav"> <i class="icon-tasks"> </i> Food <span
						class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${foodCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="Food-nav">
						<li class=""><a href="addFood.htm"><i
								class="icon-angle-right"></i> Add Food </a></li>
						<li class=""><a href="updateFood.htm"><i
								class="icon-angle-right"></i> Update Food </a></li>
					</ul></li>

				<li class="panel "><a href="#" data-parent="#menu"
					data-toggle="collapse" class="accordion-toggle"
					data-target="#transportation-nav"> <i class="icon-tasks"> </i> Transportation <span
						class="pull-right"> <i class="icon-angle-left"></i>
					</span> &nbsp; <span class="label label-info">${transportationCount}</span>&nbsp;
				</a>
					<ul class="collapse" id="transportation-nav">
					<li class=""><a href="addTransportation.htm"><i
								class="icon-angle-right"></i> Add Transportation </a></li>
					</ul></li>

			</ul>
		</div>
		<!--left -->
		<div id="content">
			<div class="panel panel-default">
				<div class="panel-heading">Available Food</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table" id="foodTable">
							<thead>
								<tr>
									<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
									<th>Food Name</th>
									<th>Harvest Date</th>
									<th>Quantity</th>
									<th>Description</th>
									<th>Transport By</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="food" items="${foodList}">
									<tr>
										<td><input style="margin-top: 0px"
											class="form-control form-input" type="radio"
											value="${food.foodId}" /></td>
										<td><input class="form-control form-input" type="text"
											value="${food.name}" name="foodName" readonly /></td>
										<td><input class="form-control " type="text"
											value="${food.harvestDate}" name="foodHarvestDate" readonly /></td>
										<td><input class="form-control " type="number"
											value="${food.quantity}" name="foodQuantity" readonly /></td>
										<td><input class="form-control form-input" type="text"
											value="${food.description}" name="foodDescrption" readonly /></td>
										<td><c:choose>
												<c:when test="${food.transportation==null}">
													<input class="form-control form-input" type="text"
														value="Not applied" readonly />
													<br />
												</c:when>
												<c:otherwise>
													<input class="form-control form-input" type="text"
														value=" ${food.transportation.processor}" readonly />
													<br />
												</c:otherwise>
											</c:choose></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<form id="form1" role="form" action="" method="post">
				<h3 id="success">Transportation successfully added!</h3>
				<h3 id="fail">Transportation adding failed</h3>
				<div class="form-group">
					<h2>
						<label>Please select an food which has not been
							transported and choose destination </label>
					</h2>
					<div id="googleMap" class="col-lg-8"></div>
					<div class="col-lg-2 form-group">
						<label>Latitude of departure</label><input
							class="form-control form-input" id="lat1" type="text" value="" /><label>Longitude
							of departure</label> <input id="lon1" class="form-control form-input"
							type="text" value="" /> <label>Latitude of destination</label><input
							class="form-control form-input" type="text" value="" id="lat2" /><label>Longitude
							of destination</label> <input id="lon2" class="form-control form-input"
							type="text" value="" /> <input type="button" id="btn_submit"
							class="btn btn-success btn-lg btn-line" value="submit" /> <input
							type="button" id="btn_refresh"
							class="btn btn-primary btn-lg btn-line" value="delete marker"
							onclick="deleteMarkers()" />
					</div>

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
		<script src="<c:url value='/resources/js/jquery-ui.min.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.resize.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.time.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.stack.js' /> "></script>
		<script src="<c:url value='/resources/js/for_index.js' /> "></script>
		<script
			src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCsSqvpcNwF3oRRBuc817eU_oBxLpwmhVc"></script>


		<script>
			var lon1 = $("#lon1");
			var lat1 = $("#lat1");
			var lon2 = $("#lon2");
			var lat2 = $("#lat2");

			var map;
			var markers = [];

			function initMap() {
				var center = {
					lat : 42.3398106,
					lng : -71.0913604
				};

				map = new google.maps.Map(document.getElementById('googleMap'),
						{
							zoom : 17,
							center : center,
							mapTypeId : google.maps.MapTypeId.TERRAIN
						});
				map.addListener('click', function(event) {
					if (markers.length <= 1) {
						addMarker(event.latLng);
					}
				});

				google.maps.event.addListener(map, 'mousemove',
						function(event) {
							if (markers.length == 0) {
								lat1.val(event.latLng.lng());
								lon1.val(event.latLng.lat());
							} else if (markers.length == 1) {
								lat2.val(event.latLng.lng());
								lon2.val(event.latLng.lat());
							}
						});
			}
			var infowindow1 = new google.maps.InfoWindow({
				content : "Departure"
			});

			var infowindow2 = new google.maps.InfoWindow({
				content : "Destination"
			});
			function addMarker(location) {
				var marker = new google.maps.Marker({
					position : location,
					map : map
				});
				markers.push(marker);
				if (markers.length == 1)
					infowindow1.open(map, marker);
				else
					infowindow2.open(map, marker);
			}

			function setMapOnAll(map) {
				for (var i = 0; i < markers.length; i++) {
					markers[i].setMap(map);
				}
			}

			function clearMarkers() {
				setMapOnAll(null);
			}

			function deleteMarkers() {
				lon1.val("");
				lat1.val("");
				lon2.val("");
				lat2.val("");

				clearMarkers();
				markers = [];
			}
			google.maps.event.addDomListener(window, 'load', initMap);
//ENDS
			$("#fail").hide();
			$("#success").hide();
			$("#btn_submit")
					.click(
							function() {
								var foodId = $("input[type='radio']:checked")
										.val();
								var lat1 = $("#lat1").val();
								var lon1 = $("#lon1").val();
								var lat2 = $("#lat2").val();
								var lon2 = $("#lon2").val();
								if (foodId === undefined) {
									alert("Please select a food to add transportation!");
									return false;
								}
								if (lat1 == "" || lon1 == "" || lat2 == ""
										|| lon2 == "" || markers.length != 2) {
									alert("please choose the location!");
									return false;
								}

								$
										.post(
												"addTransportation.htm",
												{
													"foodId" : foodId,
													"lat1" : lat1,
													"lon1" : lon1,
													"lat2" : lat2,
													"lon2" : lon2
												},
												function(data) {
													var json = JSON.parse(data);
													if (json.flag == 1) {
														$("#fail").hide();
														$("#success").show();
														$("#foodTable")
																.children(
																		"tbody")
																.append(
																		"<tr><td><input class='form-control form-input' type='text' value='"
																				+ foodName
																				+ "'/></td><td><input class='form-control form-input' type='text' value='"
																				+ harvestDate
																				+ "'/></td><td><input class='form-control form-input' type='text' value='"
																				+ quantity
																				+ "'/></td><td><input class='form-control form-input' type='text'  value='"
																				+ json.enterprise
																				+ "'/></td><td><input class='form-control form-input' type='text'  value='"
																				+ description
																				+ "'/></td></tr>");
													}
													if (json.flag == 2) {
														$("#success").hide();
														$("#fail").show();
													}
												});
								$(".del").val("");
							});
		</script>
	</div>
</body>
<!-- END BODY -->
</html>
