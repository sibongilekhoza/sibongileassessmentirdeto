  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/layout.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/button.css"/>">
</head>  
<body>
    <div class="form-container">
        <h1>User Registration</h1>
        <form method="POST" modelAttribute="user" commandName="user" class="form-horizontal" action="create">         
           <div class="form-field">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-field">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-field">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-button">
                <button type="submit" class="button primary-button">Register</button>
        </form>
         <p> Already have an account? <a href="/api/social-media/userlogin">Login</a></p>
        
    </div>
</body>
</html>
