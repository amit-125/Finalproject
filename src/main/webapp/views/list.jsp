<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Name</th>
<th>Quantity</th>
<th>Date</th>

</tr>
 <tr>
   <c:forEach items="${list}" var="l">
        <tr>
            <td>${l.name}</td>
            <td>${l.quantity}</td>
            <td>${l.date}</td>
            
             
        </tr>
        </c:forEach>
</table>
</body>
</html>