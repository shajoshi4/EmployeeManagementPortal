
<%@ include file="/WEB-INF/views/Master/includes.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

<!-- Page Content -->
	<div class="container">

		<div class="row">
			<jsp:include page="/WEB-INF/views/Master/_header.jsp"></jsp:include>
		</div>

	</div>


	<jsp:include page="/WEB-INF/views/Master/_footer.jsp"></jsp:include>

</body>

<%  //<td><img src="${pageContext.request.contextPath}/image?code=${book.bookId}" width="100"/></td> %>



</html>