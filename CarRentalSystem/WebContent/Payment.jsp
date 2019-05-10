<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<jsp:useBean id="customerData" class="com.ts.carrental.dto.Customer" scope="request" />
<jsp:include page = "CustomerHome.jsp"></jsp:include>
<div align="center">
</br></br></br></br></br></br>
<a href="CustomerHome.jsp" class='btn btn-danger btn-lg'><span class = "glyphicon glyphicon-remove"></span> Cancel</a>
<a href="Payment?receiptNo=${rent.receiptNo}" class='btn btn-info btn-lg'><i class="fa fa-rupee"></i> Pay Money</a> 
</div>
</body>
</html>