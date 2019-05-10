<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.center{
margin : auto;
width :60%;
border: 3px solid #0000;
paddind:8px;
}
</style>
</head>
<body>
<jsp:useBean id="customerData" class="com.ts.carrental.dto.Customer" scope="request" />
<jsp:include page = "CustomerHome.jsp"></jsp:include>
<div class="center">
</br></br></br></br></br></br></br>
<form action="CalculateCostAndUpdate" method="post">
<label class="col-md-2 control-label" for="meterReading"><font size="3">MeterReading</font></label> 
<input type = "text" name="meterReading" size="30" placeholder="Please Enter Meter Reading"  required="">
<input type="submit">
</form>
</div>
</body>
</html>