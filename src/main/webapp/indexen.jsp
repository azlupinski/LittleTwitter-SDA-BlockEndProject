<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Home Table</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">


</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Little twitter</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="post-form.jsp">Add post</a></li>
            <li><a href="#">User Info</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${not empty sessionScope.user}">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </c:if>
            <c:if test="${empty sessionScope.user}">
                <li><a href="form.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <li><a href="registration.jsp"><span class="glyphicon glyphicon-flash"></span>Register</a></li>
        </ul>
    </div>
</nav>
<div class="container" style="margin-top:70px">
    <div class="row content">
        <div class="panel panel-default">
            <div class="panel-heading"><h1>Post Feed</h1></div>
            <div class="panel-body">
                <jsp:include page="posts.jsp"/>



                <%--<table class="table table-striped">--%>
                    <%--<thead>--%>
                    <%--<tr>--%>
                        <%--<th>Username</th>--%>
                        <%--<th>First Name</th>--%>
                        <%--<th>Last Name</th>--%>
                        <%--<th>Email</th>--%>
                        <%--<th>Action</th>--%>
                    <%--</tr>--%>
                    <%--</thead>--%>
                    <%--<tbody>--%>
                    <%--<!-- loop over and print our customers -->--%>
                    <%--<c:forEach var="tempUser" items="${users}">--%>



                        <%--&lt;%&ndash;constructing update link&ndash;%&gt;--%>
                        <%--<c:url var="updateUserLink" value="/update/users/showFormForUpdate">--%>
                            <%--<c:param name="userId" value="${tempUser.id}"/>--%>
                        <%--</c:url>--%>


                        <%--&lt;%&ndash;constructing delete link&ndash;%&gt;--%>
                        <%--<c:url var="deleteUserLink" value="/update/users/deleteUser">--%>
                            <%--<c:param name="userId" value="${tempUser.id}"/>--%>
                        <%--</c:url>--%>


                        <%--<tr>--%>
                            <%--<td> ${tempUser.userName} </td>--%>
                            <%--<td> ${tempUser.firstName} </td>--%>
                            <%--<td> ${tempUser.lastName} </td>--%>
                            <%--<td> ${tempUser.email} </td>--%>

                            <%--<td>--%>
                                    <%--&lt;%&ndash;display lkink&ndash;%&gt;--%>
                                <%--<a href="${updateUserLink}">Update</a>--%>
                                <%--|--%>
                                <%--<a href="${deleteUserLink}"--%>
                                   <%--onclick="if (!(confirm('Are you sure you want to delete this customer'))) return false">Delete</a>--%>

                            <%--</td>--%>


                        <%--</tr>--%>

                    <%--</c:forEach>--%>
                    <%--</tbody>--%>
                <%--</table>--%>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</body>
</html>








