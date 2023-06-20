<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/layout.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/button.css"/>">
    
</head>
<body>
    <div class="container">
        <div class="centered-form">
            <header class="header">
                <h1>Login</h1>
            </header>
            <form action="/social-media/post" method="post" class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                
                <button type="submit" class="button">Login</button>
            </form>
            <p>Don't have an account? <a href="/api/social-media/userform">Register</a></p>
        </div>
    </div>
</body>
</html>
