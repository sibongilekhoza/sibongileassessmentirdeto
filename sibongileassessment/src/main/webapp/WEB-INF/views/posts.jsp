<%@ page import="java.util.List" %>
<%@ page import="com.irdeto.sibongileassessment.model.Post" %>
<% List<Post> postList = (List<Post>) request.getAttribute("postList"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Posts</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/main.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/layout.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/button.css"/>">
     <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/posts.css"/>">
      
</head>
<body>
   <div class="container">
        <h1>Post List</h1>
         <div>
        <ul class="nav nav-tabs">
         
            <li class="nav-item">
                <a class="nav-link" href="/api/social-media/hashtag.jsp">Hashtags</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/api/social-media/hashtags.jsp">All Hashtags</a>
            </li>
        </ul>
    </div>
        <hr>
        <c:if test="${not empty postList}">
            <c:forEach var="post" items="${postList}">
                <div class="post">
                    <p>${thepost.content}</p>
                    <p>${thepost.date}</p>
                    <p class="author">Posted by ${thepost.id}</p>
                    <p class="likes">Likes: ${thepost.likes}</p>
                    <form action="comment/${thepost.id}" method="post">
                        <input type="text" name="comment" placeholder="Enter your comment">
                        <button type="submit">Comment</button>
                    </form>
                    <form action="like/${thepost.id}" method="post">
                        <button type="submit">Like</button>
                    </form>
                    <form action="unlike/${thepost.id}" method="post">
                        <button type="submit">Unlike</button>
                    </form>
                </div>
                <hr>
            </c:forEach>
        </c:if>
        <c:if test="${empty postList}">
            <p>No posts found.</p>
        </c:if>
    </div>
</body>
</html>







