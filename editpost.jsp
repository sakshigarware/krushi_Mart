<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        <form action="editposting" method="post">
             <input type="text" placeholder="Product-Name" name="product_name">
             <input type="number" placeholder="price" name="price">
             <input type="number" placeholder="quantity" name="Qty">
             <input type="hidden" name="email_id" value="" id="in">
             <button>post</button>
             <button>Cancel</button>             
        </form>

</body>
</html>