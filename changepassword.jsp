<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <div class="main" align="center">
		<div class="Childdiv">
			<br><h3>Change Password</h3>
		</div>
		<div class="Childdiv1">
		<form action="change" method="post">
			  <label>Enter your email</label><br>
			  <input type="text" name="email" placeholder="email"><br><br>
			  <label>New Password</label><br>
			  <input type="Password" name="password" placeholder="New Password" autocomplete="current-password"><br><br>
			  <label>Confirm New Password</label><br>
			  <input type="Password" name="" placeholder="Confirm Password" autocomplete="current-password"><br><br>
			  <div class="but">
		        <button>change</button>
		      </div>
		      <div class="but">
			    <input type="button" name="" value="CANCEL">
		      </div>
		      </form>	
		</div>
	</div>
    

</body>
</html>