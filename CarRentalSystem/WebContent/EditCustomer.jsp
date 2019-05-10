<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-image:url("images/registerhomepage.gif");
  background-size:cover;
  height: 100vh;
}
a{
position :remainder;
}
</style>
</head>
<body>
<form action="UpdateCustomer" method="post" class="form-horizontal">
<fieldset>
<a href="CustomerHome.jsp" class="btn btn-danger" >
<span class="glyphicon glyphicon-arrow-left"></span> Back</a>
<!-- Form Name -->
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Id"><font size="3">Customer Id</font></label>  
  <div class="col-md-4">
  <input id="Id" name="cId" type="text" value="${customer.cId}" readonly="true" class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name"><font size="3">Name</font></label>  
  <div class="col-md-4">
  <input id="Name" name="cName" type="text" value="${customer.cName}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email"><font size="3">Email ID</font></label>  
  <div class="col-md-4">
  <input id="email" name="cEmailid" type="email" value="${customer.cEmailid}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="UserName"><font size="3">User Name</font></label>  
  <div class="col-md-4">
  <input id="username" name="cUsername" type="text" value="${customer.cUsername}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password"><font size="3">Password</font></label>  
  <div class="col-md-4">
  <input id="password" name="cPassword" type="password" value="${customer.cPassword}" class="form-control input-md" required="">
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="cAddress"><font size="3">Address</font></label>  
  <div class="col-md-4">
  <input id="cAddress" name="cAddress" type="text" value="${customer.cAddress}" class="form-control input-md" required="">
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="MobileNumber"><font size="3">MobileNumber</font></label>  
  <div class="col-md-4">
  <input id="mobilenumber" name="cPhoneno" type="tel" pattern = "[0-9]{10}" value="${customer.cPhoneno}"  class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="cLicenseNo"><font size="3">LicenseNumber</font></label>  
  <div class="col-md-4">
  <input id="cLicenseNo" name="cLicenseNo" type="text" value="${customer.cLicenseNo}" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-5 control-label" fhttp://www.arcticlighthotel.fi/files/5614/7737/8810/ArcticLightHotel_car_rental.jpgor="submit"></label>
    <button type="submit" class="btn btn-danger" >SUBMIT</button>
  </div>
</div>
</fieldset>
</form>
</body>
</html>