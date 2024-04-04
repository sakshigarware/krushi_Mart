<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Registration.css">
<title>Insert title here</title>
</head>
<body>
     	<div class="main-div" align="center">
		<div class="image"></div>
		<input type="file" name="" id="file1">
		<form action="register" method="post">
		<div class="form">
             <input type="text" name="firstname" placeholder="FirstName">
             <input type="text" name="lastname" placeholder="LastName">
             <input type="tel" name="phone" placeholder="Phone"><br>
             <input type="hidden" name="role" value="farmer">
             <input type="text" name="email" placeholder="Email">
             <input type="password" name="password" placeholder="Password">
             <input type="password" name="password" placeholder="Confirm Password">			
		</div>
		<div class="button">
			 <button>SIGN UP</button>
			 <button>CANCEL</button>
		</div>
		</form>

	</div>

</body>
</html>