<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
<jsp:useBean id="customerData" class="com.ts.carrental.dto.Customer" scope="request" />
<jsp:include page = "CustomerHome.jsp"></jsp:include>
<div align="center">
<form action="UpdateExtendedRentDate" method="post">
</br></br></br>
</br></br></br>
</br>
<br><b>ENTER EXTENDED RETURN DATE:</b> <input type="date" name="returnDate"></br>
</br>
<input type="submit">
</form>
</div>
</body>
</html>