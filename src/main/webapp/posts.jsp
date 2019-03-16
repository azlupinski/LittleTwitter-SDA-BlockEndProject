<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello JSP</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <style>
        .panel-heading{
            font-size: 16px;
        }
    </style>
</head>
<body>

<c:forEach var="tempPost" items="${requestScope.posts}">


        <div class="panel panel-default">
            <div class="panel-heading">
                <div>
                    <h1 style="align-content: flex-start">${tempPost.name} </h1>
                    <h6 style="align-content: flex-end">Author: ${tempPost.user.login} ${tempPost.date}</h6>
                    <c:url value = "/deletePost" var = "deletePost">
                        <c:param name = "postId" value = "${tempPost.postId}"/>
                    </c:url>
                    <h6> <a href="${deletePost}"> Delete post</a> </h6>


                </div>
            </div>
            <div  style="padding:10px" class="panel-body ">${tempPost.postContent}</div>
        </div>

</c:forEach>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>