<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.ts.carrental.dto.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title "WebContent/DisplayAllCars.jsp"here</title>
<style>
#tableContainer-1 {
    height: 100%;
    width: 100%;
    display: table;
  }
  #tableContainer-2 {
    vertical-align: middle;
    display: table-cell;
    height: 100%;
  }
  #myTable {
    margin: 0 auto;
  }
  li{
  font-size:20px;
  }
</style>
</head>
<body>
	<jsp:useBean id="customerData" class="com.ts.carrental.dto.Customer" scope="request" />
		<jsp:include page = "CustomerHome.jsp"></jsp:include>
<div id="tableContainer-1">
  <div id="tableContainer-2">
  <div class="row col-md-8 col-md-offset-4 custyle">
    <ul style = "list-style-type:none;">
	<li><b>Customer Id:</b><i> <%=customerData.getcId()%></i></li>
	<li><b>Name       :</b><i> <%=customerData.getcName()%></i></li>
	<li><b>PhoneNo: </b><i><%=customerData.getcPhoneno() %></i></li>
	<li><b>EmailId    : </b><i><%=customerData.getcEmailid()%></i></li>
	<li><b>UserName   : </b><i><%=customerData.getcUsername()%></i></li>
	<li><b>Password   : </b><i><%=customerData.getcPassword()%></i></li>
	<li><b>Address    : </b><i><%=customerData.getcAddress()%></i></li>
	<li><b>LicenseNo  :</b> <i><%=customerData.getcLicenseNo()%></i></li>
	</ul>
	</div>
	</div>
	</div>
</body>
</html>