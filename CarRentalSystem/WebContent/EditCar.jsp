<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.ts.carrental.dto.Car,com.ts.carrental.dao.CarDao"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Car Details</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
body {
  margin: 0;
  padding: 0;
  background-image:url("images/registerhomepage.gif");
  background-size:cover;
  height: 100vh;
}
#main{
width:100%;
height:100vh;
background-image:url("images/registerhomepage.gif");
background-size:cover;
}
</style>
</head>
<body>
<div id = main>
<form action="UpdateCar" method="POST" class="form-horizontal">
<fieldset>
<a href="AdminHome.html" class="btn btn-danger" >
<span class="glyphicon glyphicon-arrow-left"></span> Back</a>
<!-- Form Name -->
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="carNo"><font size="3">Car No</font></label>  
  <div class="col-md-4">
  <input id="carNo" name="carNo" type="text"  value="${car.carNo}" readonly="true" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="carModel"><font size="3">Enter Car Model: </font></label>  
  <div class="col-md-4">
  <input id="carModel" name="carModel" type="text"  value="${car.carModel}" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="carColor"><font size="3">Enter Car Color: </font></label>  
  <div class="col-md-4">
  <input id="carColor" name="carColor" type="text" value="${car.carColor}" class="form-control input-md">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="status"><font size="3">Enter Car Status: </font></label>  
  <div class="col-md-4">
  <input id="status" name="status" type="status" value="${car.status}" class="form-control input-md">
    
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="capacity"><font size="3">Enter Car Capacity: </font></label>  
  <div class="col-md-4">
  <input id="capacity" name="capacity" type="text" value="${car.capacity}" class="form-control input-md">
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="basePrice"><font size="3">Enter Base Price : </font></label>  
  <div class="col-md-4">
  <input id="basePrice" name="basePrice" type="text" value="${car.basePrice}" class="form-control input-md">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="costPerKm"><font size="3">Cost Per Km</font></label>  
  <div class="col-md-4">
  <input id="costPerKm" name="costPerKm" type="text" value="${car.costPerKm}" class="form-control input-md">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="penality"><font size="3">Penality</font></label>  
  <div class="col-md-4">
  <input id="penality" name="penality" type="text"  value="${car.penality}" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="image"><font size="3">Image Name</font></label>  
  <div class="col-md-4">
  <input id="image" name="image" type="text" placeholder="Enter image" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-5 control-label" for="submit"></label>
 
    <button type="submit" class="btn btn-danger" >SUBMIT</button>
  </div>
</div>
</fieldset>

</form>
</div>
</body>
</html>