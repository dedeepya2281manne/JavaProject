<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.ts.carrental.dto.Customer" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"> <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
body{
width:100%;
height:100vh;
background-image:url("images/plainbackground.jpg");
background-size:cover;
}
nav{
width:100%;
height:80px;
background-color:#000;
line-height:80px;
}
nav ul{
float:right;
marign-right:30px;
}
nav ul li{
list-style-type:none;
display:inline-block;
transition:0.8s all;
font-size:130%;
}
nav ul li:hover{
background-color:#f39d1a;
}
nav ul li a{
text-decoration:null;
color:#fff;
padding:30px;
}
.dropbtn {
  background-color:#000;
  color: white;
  width:150px;
  padding: 0px;
  font-size: 20px;
  border: none;
  cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
  background-color:#f39d1a;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 100px;
  overflow: auto;
  box-shadow: 0px 8px 10px 0px rgba(0,0,0,0.2);
  z-index: 2;
}

.dropdown-content a {
  color: black;
  padding: 5px 5px;
  text-decoration: none;
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}
</style>
</head>
<body>
<%
Customer customer = (Customer)session.getAttribute("customer");
%>
<nav>
   <img src="images/logo-home.png">
   <ul>
     <div class="dropdown">
  <button onclick="myFunction()" class="dropbtn"><i class="glyphicon glyphicon-user"></i> PROFILE</button>
  <div id="myDropdown" class="dropdown-content">
    <a href="DisplayCustomerProfile">View</a>
    <a href="EditCustomer?cId=${customer.cId}">Edit</a> 
    <a href="Main.html">Logout</a>
  </div>
</div>
      <li><a href="AvailableCars"><span class="glyphicon glyphicon-ok"></span>  BOOK A CAR</a></li>
      <li><a href="CurrentBookedCarsOfCustomer"><i class='fas fa-lock'></i>  CURRENT BOOKING</a></li>
      <li><a href="BookingHistoryOfCustomer"><i class="fas fa-history"></i>  MY BOOKINGS</a></li>
</ul>
</nav>
<script>
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
</body>
</html>