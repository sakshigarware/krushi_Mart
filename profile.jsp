<%@page import="jdbc_Krushimart_sevlets.CRUD"%>
<%@page import="jdbc_Krushimart_sevlets.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="profile.css">
<title>Insert title here</title>
</head>
<body onload="getemail()">
   <%Registration regist=(Registration)request.getAttribute("regist"); %>
   <div action="prof" method="post" class="outer" align="center">
        <h3 style="top:10px;">Profile</h3>
        <label>Email</label>
        <input type="text" name="email" value=<%=regist.getEmailid() %>>
        <label>FistName</label>
        <input type="text" name="firstname" placeholder="FirstName" value=<%=regist.getFname() %>>
        <label>LastName</label>
        <input type="text" name="lastname" placeholder="LastName" value=<%=regist.getLname() %>>
        <label>Phone</label>
        <input type="tel" name="phone" placeholder="Phone" value=<%=regist.getPhone() %>><br>
        <input type="hidden" name="role" value=<%=regist.getRole() %>>
        <div class="inner">
        <a href="update?email=<%=regist.getEmailid()%>"><button>edit profile</button></a>
        <button onclick="changepass()">change password</button>
        </div>
  </div>
  <script type="text/javascript">
  function getemail()
  {
  	var receivedData = localStorage.getItem('data');
  	var inpt=document.getElementById('spam');
  	var pt=document.getElementById('in');
  	inpt.innerHTML=receivedData;
  	pt.setAttribute("value",receivedData);
  	return receivedData;
  }
  function changepass()
  {
	  location.href="changepassword.jsp";
  }
  </script>
</body>
</html>