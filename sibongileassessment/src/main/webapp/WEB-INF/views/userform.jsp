<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <link rel="stylesheet" type="text/css" href="CSS/main.css">
    <link rel="stylesheet" type="text/css" href="CSS/form.css">
</head>
<body>
    <div class="form-container">
        <h1>User Registration</h1>
        <form:form method="POST" modelAttribute="user" commandName="user" class="form-horizontal" action="create">         
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
            </form:form>
        </form>
    </div>
</body>
</html>
