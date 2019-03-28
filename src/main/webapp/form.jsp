<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: azlup
  Date: 10.03.2019
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <div class="panel-heading"><h1>Log In</h1></div>
            <div class="panel-body">
                <form class="form-horizontal" action="/login" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="login">Username:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="login" placeholder="Enter username" name="login">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
                        </div>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<div class="col-sm-offset-2 col-sm-10">--%>
                            <%--<div class="checkbox">--%>
                                <%--<label><input type="checkbox" name="remember"> Remember me</label>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
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
