<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList,com.ts.carrental.dto.Car"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
.custab{
    border: 1px solid #ccc;
    padding: 5px;
    margin: 5% 0;
    box-shadow: 3px 3px 2px #ccc;
    transition: 0.5s;
    }
.custab:hover{
    box-shadow: 3px 3px 0px transparent;
    transition: 0.5s;
    }
#main{
width:100%;
height:1500px;
background-image:url("images/plainbackground.jpg");
background-size:cover;
}
td{
font-size:150%;
}
th{
font-size:150%;

}
nav{
width:100%;
height:130px;
background-color:#0007;
line-height:80px;
}
img{

float:right;
}
table{
border:100px;
}
</style>
</head>
<body>
<div id = "main">
<div>
<a href="AdminHome.html" class="btn btn-danger" >
<span class="glyphicon glyphicon-arrow-left"></span>    Back</a>
<img src="images/logo-home.png">
</div>
    <div class="row col-md-8 col-md-offset-1 custyle">
    <table class="table table-hover ">
    <thead>
        <tr>
           <th>CarNo</th>
			<th>CarModel</th>
			<th>CarColor</th>
			<th>Status</th>
			<th>Capacity</th>
			<th>BasePrice</th>
			<th>CostPerKm</th> 
			<th>penality</th>
			<th>image</th> 
			
			<th colspan="2" text="center">Actions</th> 
        </tr>
    </thead>
            <c:forEach var="car" items="${carsData}">
            <tr>
                <td>${car.carNo}</td>
				<td>${car.carModel}</td>
				<td>${car.carColor}</td>
				<td>${car.status}</td>
				<td>${car.capacity}</td>
				<td>${car.basePrice}</td>
				<td>${car.costPerKm}</td>
				<td>${car.penality}</td>
				<td><a href="displayCar.jsp?image=${car.image}">
				<img src = "images/${car.image}" height="90" width="150"></a></td>
				<td>
                <a href="EditCar?carNo=${car.carNo}" class='btn btn-info btn-large'><span class="glyphicon glyphicon-pencil"></span> Edit</a> 
                
            </tr>
        </c:forEach>
    </table>
    </div>
</div>
</body>
</html>




