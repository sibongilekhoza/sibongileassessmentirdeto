<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Comment</title>
   <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/layout.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/button.css"/>">
     <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/posts.css"/>">
</head>
<body>
    <div class="form-container">
        <h1>Add Comment</h1>
        <form action="addComment" method="POST">
            <div class="form-field">
                <label for="postId">Post ID</label>
                <input type="text" id="postId" name="postId" value="<%= request.getParameter("postId") %>" readonly>
            </div>
            <div class="form-field">
                <label for="comment">Comment</label>
                <textarea id="comment" name="comment" required></textarea>
            </div>
            <div class="form-button">
                <button type="submit" class="button primary-button">Add Comment</button>
            </div>
        </form>
    </div>
    <script>
        // Optional: Add JavaScript logic for form validation or other client-side functionality
    </script>
</body>
</html>
