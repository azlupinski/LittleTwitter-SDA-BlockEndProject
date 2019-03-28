<%--
  Created by IntelliJ IDEA.
  User: azlup
  Date: 10.03.2019
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

</head>
<body>
<%@include file="/WEB-INF/header/navbar.jsp"%>
<div class="container" style="margin-top:70px">
    <div class="row content">
        <div class="panel panel-default">
            <div class="panel-heading"><h1>add post</h1></div>
            <div class="panel-body">
                <form class="form-horizontal" action="/addPost" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name">Post Title:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" placeholder="enter post name" name="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="postContent">Post Content:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="postContent" placeholder="enter post content" name="postContent">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <div class="checkbox">
                                <label><input type="checkbox" name="remember"> Remember me</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>
