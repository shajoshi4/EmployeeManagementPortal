<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 100%;
	margin: auto;
}
</style>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container navbar-inner">


			<div class="navbar-header">
				<a class="navbar-brand text-muted" href="#">Hi,<br> Welcome 
	              ${sessionScope.user.firstName}</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
						<li><a href="feedback"><span
								class="glyphicon glyphicon-comment"></span>Feedback</a></li>
						<li><a href="leave"><span
								class="glyphicon glyphicon-calendar"></span>Leave Request</a></li>
					    <li><a href="showAllotedTask"><span
								class="glyphicon glyphicon-folder-open"></span>View Task</a></li>
						<li><a href="editProfile"><span
								class="glyphicon glyphicon-edit"></span>Update Profile</a></li>
						<li><a href="changePassword"><span
								class="glyphicon glyphicon-pencil"></span>Change Password</a></li>
						 <li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span>Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<jsp:include page="_header_2.jsp"></jsp:include>
	
	 <section id="about">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-*">
          <h3 class="section-title" text-align="center">About Us</h3>
          <div class="section-title-divider"></div>
		  </div>
      </div>
    </div>

  </section>
	

	<%
		/*image start*/
		
	%>
	

	<%
		/*image end*/
		
	%>





</body>

</html>