<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hashtags</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/layout.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/form.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/table.css"/>">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/static/button.css"/>">
</head>
<body>
    <div class="container">
        <h1>Hashtags</h1>

        <form action="<c:url value="/hashtags/create"/>" method="post">
            <label for="name">Hashtag Name:</label>
            <input type="text" id="name" name="name" required>
            <button type="submit" class="btn">Create</button>
        </form>

        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="hashtag" items="${hashtags}">
                    <tr>
                        <td>${hashtag.id}</td>
                        <td>${hashtag.name}</td>
                        <td>
                            <a href="<c:url value="/hashtags/${hashtag.id}"/>">View</a>
                            <a href="<c:url value="/hashtags/${hashtag.id}/delete"/>" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
