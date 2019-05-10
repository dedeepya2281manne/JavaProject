<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
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
a{
position :remainder;
}
</style>
</head>
<body>
<form action="AddNewCar" method="post" class="form-horizontal">
<fieldset>
<a href="AdminHome.html" class="btn btn-danger" >
<span class="glyphicon glyphicon-arrow-left"></span> Back</a>
<!-- Form Name -->


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="carModel"><font size="3">Car Model</font></label>  
  <div class="col-md-4">
  <input id="carModel" name="carModel" type="text" placeholder="Enter car model" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="carColor"><font size="3">Car Color</font></label>  
  <div class="col-md-4">
  <input id="carColor" name="carColor" type="text" placeholder="Enter car color" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="capacity"><font size="3">Capacity</font></label>  
  <div class="col-md-4">
  <input id="capacity" name="capacity" type="text" placeholder="Enter car capacity" class="form-control input-md" required="">
    
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="basePrice"><font size="3">BasePrice</font></label>  
  <div class="col-md-4">
  <input id="basePrice" name="basePrice" type="text" placeholder="Enter basePrice" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="costPerKm"><font size="3">CostPerKm</font></label>  
  <div class="col-md-4">
  <input id="costPerKm" name="costPerKm" type="text" placeholder="Enter costPerKm" class="form-control input-md" required="">
    
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="penality"><font size="3">Penality</font></label>  
  <div class="col-md-4">
  <input id="penality" name="penality" type="text" placeholder="Enter penality per day" class="form-control input-md" required="">
    
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


</fieldset>
</form>
</body>
</html>