<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="jdbc_Krushimart_sevlets.Registration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="profileedit.css">
</head>
<body>
  <form action="edit" method="post" id="outer">
   <div action="" method="post" >
       <% Registration register=(Registration)request.getAttribute("reg"); %>
       <input type="text" name="firstname" placeholder="firstname">
       <input type="text" name="lastname" placeholder="Lastname">
       <input type="tel" name="phone" placeholder="phone"><br>
       <input type="text" name="role" value="<%=register.getRole()%>" readonly>
       <input type="text" name="email" placeholder="Email">
       <input type="password" name="password" placeholder="password"readonly>
       <div>
          <button>saveprofile</button>
          <% if(register.getRole().equals("buyer")){ %>
          <a href="buyerpost.jsp"><button>cancel</button></a>
          <% }else{ %>
           <a href="homepage.jsp"><button>cancel</button></a>
           <%} %>
       </div>             
   </div>
   </form>

</body>
</html>