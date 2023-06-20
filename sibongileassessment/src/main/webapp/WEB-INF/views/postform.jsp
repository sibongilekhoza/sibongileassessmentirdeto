<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create Post</title>
   <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/layout.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/button.css"/>">
     <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/posts.css"/>">
</head>
<body>
    <div class="form-container">
        <h1>Create Post</h1>
        <form action="createPost" method="POST">
            <div class="form-field">
                <label for="title">Title</label>
                <input type="text" id="title" name="title" required>
            </div>
            <div class="form-field">
                <label for="content">Content</label>
                <textarea id="content" name="content" required></textarea>
            </div>
            <div class="form-button">
                <button type="submit" class="button primary-button">Create Post</button>
            </div>
        </form>
    </div>
    
</body>
</html>
