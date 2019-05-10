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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
<a href="CustomerHome.jsp" class="btn btn-danger" >
<span class="glyphicon glyphicon-arrow-left"></span>    Back</a>
<img src="images/logo-home.png">
</div>
    <div class="row col-md-8 col-md-offset-2 custyle">
    <table class="table table-hover ">
    <thead>
        <tr>
           <th>CarNo</th>
			<th>CarModel</th>
			<th>CarColor</th>
			<th>Capacity</th>
			<th>BasePrice</th>
			<th>CostPerKm</th>
			<th>Image</th>
			<th colspan="2" text="center">Actions</th> 
        </tr>
    </thead>
            <c:forEach var="car" items="${carsData}">
            <tr>
                <td>${car.carNo}</td>
				<td>${car.carModel}</td>
				<td>${car.carColor}</td>
				<td>${car.capacity}</td>
				<td>${car.basePrice}</td>
				<td>${car.costPerKm}</td>
				<td><a href="displayCar.jsp?image=${car.image}">
				<img src = "images/${car.image}" height="90" width="150"></a></td>
				<td><a href='BookACar?carNo=${car.carNo}' class="btn btn-info"><span class="fa fa-automobile"></span> Book</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</div>
</body>
</html>




