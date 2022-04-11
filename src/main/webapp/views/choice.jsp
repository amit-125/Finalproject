<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@  page import="org.springframework.ui.Model" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${msg != null}">
 <div class="alert alert-success">
  <strong>Success!</strong> ${msg}
</div>

</c:if>

  
 
<h2> Please Enter your Choice. </h2>  
<form method = "post" action = "submit" >
<select name="choice" id="cars">
  <option value="1">1 Show List of Items</option>
  <option value="2">2 Add an Item </option>
  <option value="3">3 Delete an Item</option>
 </select>
 <button type="submit">Submit</button>
 </form>
 </body>
 </html>
