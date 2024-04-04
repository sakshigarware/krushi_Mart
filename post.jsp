<%@page import="jdbc_Krushimart_sevlets.Login"%>
<%@page import="jdbc_Krushimart_sevlets.LoginController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <div class="main-div" align="center">
        <div class="postdiv">
             
        
        </div>
        <input type="file">
        <form action="posting" method="post">
             <%Login log=new Login();%>
             <input type="text" placeholder="Product-Name" name="product_name">
             <input type="number" placeholder="price" name="price">
             <input type="number" placeholder="quantity" name="Qty">
             <input type="hidden" name="email_id" value="" id="in">
             <button onclick="getemail()">post</button>
             <button>Cancel</button>             
        </form> 
   </div>
   <script>
        function getemail()
        {
        	var receivedData = localStorage.getItem('data');
        	var inpt=document.getElementById('in');
        	inpt.value=receivedData;
        }
    </script>

</body>
</html>