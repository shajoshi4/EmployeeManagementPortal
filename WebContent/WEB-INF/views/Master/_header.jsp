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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>
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
				<a class="navbar-brand text-muted" href="#">Employee Task Management</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right">
				        <li><a href="#team"><span
								class="glyphicon glyphicon-user"></span> Team</a></li>
						<li><a href="#about"><span
								class="glyphicon glyphicon-user"></span> About Us</a></li>
						<li><a href="General/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
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
    <div class="container about-container wow fadeInUp">
      <div class="row">
        <div class="col-md-*  about-content">
          <h2 class="about-title">We provide great services and ideas</h2>
          <p class="about-text">
           Centre for Development of Advanced Computing (C-DAC) is the premier R&D organization of the Ministry of Electronics and 
		   Information Technology (MeitY) for carrying out R&D in IT, Electronics and associated areas.  Different areas of C-DAC, had 
			originated at different times, many of which came out as a result of identification of opportunities.
          </p>
          <p class="about-text">
            C-DAC has today emerged as a premier R&D organization in IT&E (Information Technologies and Electronics) in the 
			country working on strengthening national technological capabilities in the context of global developments in the 
			field and responding to change in the market need in selected foundation areas.  In that process, C-DAC represents a 
			unique facet working in close junction with MeitY to realize nation’s policy and pragmatic interventions and 
			initiatives in Information Technology. 
          </p>
          
        </div>
      </div>
    </div>
  </section>
  
  
   <section id="team">
    <div class="container wow fadeInUp">
      <div class="row">
        <div class="col-md-12">
          <h3 class="section-title">Our Team</h3>
          <div class="section-title-divider"></div>
        </div>
      </div>

      <div class="row">
        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="bootstrap/img/devu.jpg" alt=""></div>
            <h5>Devanshi Nagar</h5>   
            <a href="https://www.facebook.com"><i class="fa fa-facebook" style="font-size:14px;color:blue"></i></a>
            <a href="https://twitter.com/login"><i class="fa fa-twitter" style="font-size:14px;color:blue"></i></a>
            <a href="https://plus.google.com/people"><i class="fa fa-google-plus" style="font-size:14px;color:blue"></i></a>
            <a href="https://in.linkedin.com/"><i class="fa fa-linkedin" style="font-size:14px;color:blue"></i></a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="bootstrap/img/sharu.jpg" alt=""></div>
            <h5>Sharvari Joshi</h5>
            <a href="https://www.facebook.com"><i class="fa fa-facebook" style="font-size:14px;color:blue"></i></a>
            <a href="https://twitter.com/login"><i class="fa fa-twitter" style="font-size:14px;color:blue"></i></a>
            <a href="https://plus.google.com/people"><i class="fa fa-google-plus" style="font-size:14px;color:blue"></i></a>
            <a href="https://in.linkedin.com/"><i class="fa fa-linkedin" style="font-size:14px;color:blue"></i></a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="bootstrap/img/poonam.jpg" alt=""></div>
            <h5>Poonam Chopade</h5>
             <a href="https://www.facebook.com"><i class="fa fa-facebook" style="font-size:14px;color:blue"></i></a>
            <a href="https://twitter.com/login"><i class="fa fa-twitter" style="font-size:14px;color:blue"></i></a>
            <a href="https://plus.google.com/people"><i class="fa fa-google-plus" style="font-size:14px;color:blue"></i></a>
            <a href="https://in.linkedin.com/"><i class="fa fa-linkedin" style="font-size:14px;color:blue"></i></a>
          </div>
        </div>

        <div class="col-md-3">
          <div class="member">
            <div class="pic"><img src="bootstrap/img/priya.jpg" alt=""></div>
            <h5>Priyanka Pawar</h5>
             <a href="https://www.facebook.com"><i class="fa fa-facebook" style="font-size:14px;color:blue"></i></a>
            <a href="https://twitter.com/login"><i class="fa fa-twitter" style="font-size:14px;color:blue"></i></a>
            <a href="https://plus.google.com/people"><i class="fa fa-google-plus" style="font-size:14px;color:blue"></i></a>
            <a href="https://in.linkedin.com/"><i class="fa fa-linkedin" style="font-size:14px;color:blue"></i></a>
          </div>
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