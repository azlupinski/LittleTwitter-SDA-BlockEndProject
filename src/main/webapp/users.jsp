<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Hello JSP</title>
</head>
<body>

    <c:forEach items="${ requestScope.users }" var="user" >
        <section>
            <ul>
                <li>Login: ${ user.login }</li>
                <li>Password: ${ user.password }</li>
                <li>Role: ${ user.role }</li>
            </ul>
        </section>
    </c:forEach>

</body>
</html>