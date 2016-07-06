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
									<th>Food Name</th>
									<th>Harvest Date</th>
									<th>Quantity</th>
									<th>Enterprise</th>
									<th>Description</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="food" items="${foodList}">
									<tr>
										<td><input class="form-control form-input" type="text"
											value="${food.name}" /><input class="" type="hidden"
											name="foodId" value="${food.foodId}" /></td>
										<td><input class="form-control " type="text"
											value="${food.harvestDate}" /></td>
										<td><input class="form-control " type="number"
											value="${food.quantity}" /></td>
										<td><input class="form-control form-input" type="text"
											value="${food.supplier}" /></td>
										<td><input class="form-control form-input" type="text"
											value="${food.description}" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<form id="form1" role="form" action="" method="post">
				<h3 id="success">Food successfully added!</h3>
				<h3 id="fail">Food adding failed</h3>
				<div class="form-group">
					<h2>
						<label>Please input the following details </label>
					</h2>
					<h3>
						<input class="form-control del" id="foodName" name="foodName"
							placeholder="Food Name">
					</h3>
					<h3>
						<input class="form-control del" id="foodHarvestDate"
							name="foodHarvestDate" placeholder="Food Harvest Date mm-dd-yyyy">
					</h3>
					<h3>
						<input class="form-control del" id="foodQuantity"
							name="foodQuantity" placeholder="Food quantity">
					</h3>
					<h3>
						<input class="form-control del" id="foodDescription"
							name="foodDescription" placeholder="Food description">
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
		<script src="<c:url value='/resources/js/jquery-ui.min.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.resize.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.time.js' /> "></script>
		<script src="<c:url value='/resources/js/jquery.flot.stack.js' /> "></script>
		<script src="<c:url value='/resources/js/for_index.js' /> "></script>


		<script>
			$("#fail").hide();
			$("#success").hide();
			$(function() {
				$('#datetimepicker1').datetimepicker();
			});
			$("#btn_submit")
					.click(
							function() {
								var foodName = $("input[name='foodName']")
										.val();
								var harvestDate = $(
										"input[name='foodHarvestDate']").val();
								var quantity = $("input[name='foodQuantity']")
										.val();
								var description = $(
										"input[name='foodDescription']").val();
								if (foodName == "" || harvestDate == ""
										|| quantity == "" || description == "") {
									alert("please input the details below!");
									return false;
								}
								if(quantity>10000||quantity<=0){
									alert("quantity invalid");
									return false;
								}
								var validformat = /^\d{2}\/\d{2}\/\d{4}$/ //Basic check for format validity
								var returnval = false

								var monthfield = harvestDate.split("-")[0]
								var dayfield = harvestDate.split("-")[1]
								var yearfield = harvestDate.split("-")[2]
								var dayobj = new Date(yearfield,
										monthfield - 1, dayfield)
								if ((dayobj.getMonth() + 1 != monthfield)
										|| (dayobj.getDate() != dayfield)
										|| (dayobj.getFullYear() != yearfield))
									alert("Invalid Day, Month, or Year range detected. Please correct and submit again.")
								else
									returnval = true

								if (returnval == false)

									return returnval;

								if (!($.isNumeric(quantity) && Math
										.floor(quantity) == quantity)) {
									alert("invalid input detected!");
									return false;
								}
								$
										.post(
												"addFood.htm",
												{
													"foodName" : foodName,
													"harvestDate" : harvestDate,
													"quantity" : quantity,
													"description" : description
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
