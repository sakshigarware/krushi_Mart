<%@page import="jdbc_Krushimart_sevlets.Post"%>
<%@page import="java.util.List"%>
<%@page import="jdbc_Krushimart_sevlets.CRUD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% CRUD crud=new CRUD();
    List<Post> list=crud.getPost();
        for(Post post: list){%>
<form action="listpost">
<div class="main-div">
    <div class="maininner1">
       
    </div>
    <div class="maininner2">
          <h5><span>Product Name :</span><%=post.getProduct() %></h5>
          <h5><p>Price :</p><%=post.getPrice()%></h5><span>per kg</span>
          <h6><%=post.getQuatity()%></h6>
          <div class="btn">
              <a href=""><button>Edit Post</button></a>
              <button>Delete Post</button>        
          </div>
    </div>
</div>
<%} %>

</body>
</html>