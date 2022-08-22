<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Auto Complete with Spring MVC</title>
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
<form action="addusers" >
<h2>Add and Search Address</h2>
<label for="H-no">Enter Address</label>
<input type="text" name="address"><br><br>
<button type="submit" class="btn btn-primary">Submit</button>
</form>
<br>
<br>
Search Product
    <input type="text" id="productName">



</body>
</html>