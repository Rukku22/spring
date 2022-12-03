<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
   <html> 
   <head>   
  <style>
   .grid-container{
   margin-left:40px;
   display:inline-grid;
   padding: 10px;
   }
  </style> 
  </head>
  <body> 
   <c:forEach var="emp" items="${list}">   
  <div class="grid-container">
   <a href='pdp?id=${emp.id}'><img style="width:300px;height:500px" src='${emp.image}'> </a>
   <h4><b>Name<b>:${emp.name}</h6>  
   <h4><b>Cost:<b>${emp.cost}Rs/-</h6>  
   <h4><b>Description<b>:${emp.description}</h4>  
    </div>
   </c:forEach>  
  </body>
  </html>