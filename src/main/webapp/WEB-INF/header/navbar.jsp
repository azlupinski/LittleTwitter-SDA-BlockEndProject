<%--
  Created by IntelliJ IDEA.
  User: azlup
  Date: 27.03.2019
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Little twitter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}/">Home</a></li>
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