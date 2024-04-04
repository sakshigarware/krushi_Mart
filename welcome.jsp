<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="welcome.css">
<title>Insert title here</title>
</head>
<body>
<div class="Signup" align="center">
		<div class="sign1" style="background-color: rgb(255, 255, 255,0.2);">
			<div class="sign1inner"></div>
			<button onclick="signup()" style="border-radius: 10px;">SignUp</button>
			<button onclick="myFunction()" style="border-radius: 10px;">Login</button>
			<h3>FARMER</h3>
		</div>
        <div class="sign2" style="background-color: rgb(255, 255, 255,0.2);">>
        	<div class="sign2inner"></div>
        	<button onclick="signUp()" style="border-radius: 10px;">SignUp</button>
        	<button onclick="myFunction()" style="border-radius: 10px;">Login</button>
        	<h3>BUYER</h3>
        </div>
	</div>
	<script>
	let count=0;
function myFunction() {
  for(let i=count; i<1; i++)
  {
       let a=document.createElement("DIV");
  a.setAttribute("class","div1");
  a.setAttribute("align","center");
  document.body.appendChild(a);
  let heading=document.createElement("h3");
  document.body.appendChild(a).appendChild(heading).innerHTML="Login";
  
  let frm=document.createElement("FORM");
  frm.setAttribute("action","login");
  frm.setAttribute("method","post");
  
  let mail=document.createElement("INPUT");
  mail.setAttribute("type","text");
  mail.setAttribute("placeholder","Email");
  mail.setAttribute("name","email");
  document.body.appendChild(a).appendChild(frm).appendChild(mail);

  let password=document.createElement("INPUT");
  password.setAttribute("type","password");
  password.setAttribute("placeholder","password");
  password.setAttribute("name","password");
  document.body.appendChild(a).appendChild(frm).appendChild(password);

  let bt1=document.createElement("BUTTON");
  // bt1.setAttribute("type","button");
  bt1.setAttribute("placeholder","login");
  bt1.setAttribute("id","btn");
  document.body.appendChild(a).appendChild(frm).appendChild(bt1).innerHTML="Login";
  count++;
  }
}

function signup()
{
	location.href="Krushiregistration.jsp";
	}
function signUp()
{
	location.href="userRegistration.jsp";
}
</script>

</body>
</html>