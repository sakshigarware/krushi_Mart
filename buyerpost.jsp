<%@page import="java.util.List"%>
<%@page import="jdbc_Krushimart_sevlets.Post"%>
<%@page import="jdbc_Krushimart_sevlets.CRUD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="homepost.css">
<title>Insert title here</title>
</head>
<body action="buyerpost">
<% String email=(String)request.getAttribute("loged"); %>
   <nav class="navbar navbar-expand-lg" action="">
		<a class="navbar-brand" href="#"
			style="color: black; f font-size: 25px;">OnlineShopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="#hero">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="profile?email=<%=email%>">profile</a>
				</li>
				<li class="nav-item "><a class="nav-link " href="#contacts">
						contact </a></li>
				<li class="nav-item"><a class="nav-link" href="#aboutus">About
						us</a></li>
			</ul>
		</div>
	</nav>
   <%CRUD crud=new CRUD();
  List<Post> list= crud.getPost();
  Registration register=(Registration)request.getAttribute("systemreg");
  for(Post post: list){%>
<form action="listpost">
<div class="main-div" style="margin-left:100px; left:0px;">
    <div class="maininner1">
       
    </div>
    <div class="maininner2">
          <h5><span>Product Name :</span><%=post.getProduct() %></h5>
          <h5><p>Price :</p><%=post.getPrice()%></h5><span>per kg</span>
          <h6><%=post.getQuatity()%></h6>
          <div class="btn">
              <a href=""><button>BUY</button></a>        
          </div>
    </div>
</div>
<%} %>
<input type="hidden" value=<%=email%> id="inpt" name="email">
</body>
<script>
  function loc()
  {
          var dataToSend = document.getElementById('inpt').value;
          localStorage.setItem('data', dataToSend);
          window.location.href = "profile.jsp";      
  }
  </script>
</html>