<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link
    href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
    rel="stylesheet" type="text/css">
<script type="text/javascript">
    $(document).ready(function() {
        $('#productName').autocomplete({
            source : '${pageContext.request.contextPath }/search'
        });
    });
</script>
</head>
<body>
<h2 style="text-align:center">ADDRESS ENGINE</h2>
	<form action="saveaddress">
		<h2>Enter the Address Below:</h2><br>
		<textarea rows="3" cols="20" name="addr"></textarea>
		 <input style="color: red" type="submit">
	</form>

	
	<form action="savefile" enctype="multipart/form-data" method="post">
		<h2>File Input:</h2><br>
		<input type="file" name="fil"><br>
		<br>
		<input	type="submit"><br>
	</form>
	
	
	<form autocomplete="on" action="searchsimilar" >
		<h2>Enter address to search for similar:</h2><br>
		<input type="text" id="productName" name="simi">
		<input style="color: red" type="submit"><br>
	</form>
</body>

<body style="color: black">
<div style="text-align: center" >
	<br> ---------------- SIMILAR SEARCHES ------------------
	<br>
	<br>
	<c:forEach var="var" items="${sms}">
     ${var.addr}<br>
	</c:forEach>
</div>
</body>
</html>

