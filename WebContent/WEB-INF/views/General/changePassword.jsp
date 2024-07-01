 <%@ page errorPage="../../../error.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
<link href="<spring:url value='/bootstrap/css/bootstrap.css'/>"
	type="text/css" rel="stylesheet" />
	<script>
            $(document).ready(function (){
                $("#hh1").bind("cut copy paste",function (e){
                    alert("hi");
                    e.preventDefault();
                });
                $("#t1").bind("cut copy paste",function (e){
                    
                    e.preventDefault();
                });
            });
     </script>
</head>
<body>
<c:choose>
		<c:when test="${sessionScope.designation=='M'}">
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headermgr.jsp"></jsp:include>
		</div><br><br>
	</c:when>
	
	<c:otherwise>
	<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_headeremp.jsp"></jsp:include>
		</div><br><br>
	</c:otherwise>
</c:choose>


	
<div class="container">

<form:form action="setNewPassword" >
	<div class="form-group row">
				<label for="number" class="col-sm-2 col-form-label">Employee ID</label>
				<div class="col-sm-4">
					<input type="number" name="empId" value="${sessionScope.user.empId}" readonly />
				</div>
			</div>
	<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Old Password</label>
				<div class="col-sm-4">
					<input type="password" name="oldPass"/>
				</div>
			</div>
	<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">New Password</label>
				<div class="col-sm-4">
				<input type="password" name="newPass"/>
				</div>
			</div>
	<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label"> Confirm Password</label>
				<div class="col-sm-4">
				<input type="password" name="confirmPass"/>
				</div>
			</div>
	
	<div class="form-group row">
				<label for="text" class="col-sm-2 col-form-label"> Capcha Code</label>
				<div class="col-sm-4">
					  <h3 id="hh1"><s>${sessionScope.code}</s></h3>
					   <input type="hidden" value="${sessionScope.code}" name="hcapcha"/>
				</div>
	</div>			
				
      <div class="form-group row">
				<label for="text" class="col-sm-2 col-form-label"> Enter Capcha Code</label>
				<div class="col-sm-4">
						<input name="captcha" id="t1">	
				</div>
		</div>		
                            
                      
                       
                       		
	<div class="form-group row">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" name="btn" value="Register"
						class="btn btn-success">Register</button>
				</div>
				<div class="offset-sm-2 col-sm-10">
					<button type="reset" name="btn" value="Reset"
						class="btn btn-success">Reset</button>
				</div>
	</div>
</form:form>
</div>
	<script src="<spring:url value='/js/jquery.1.9.1.min.js'/>"></script>
	<script src="<spring:url value='/bootstrap/js/bootstrap.min.js'/>"></script>

</body>
</html>