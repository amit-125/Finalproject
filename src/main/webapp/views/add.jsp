<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/saveitem" method="post">
Please Enter Details of the item to be added
<br>
Name:<input type="text" name="name">
<br>
Quantity:<input type="text" name="quantity">
<br>
Date:<input type="date"  name="date"
       value="2018-07-22"
       min="2018-01-01" max="2022-12-31">
<button type="submit">Submit</button>       
      </form>
</body>
</html>