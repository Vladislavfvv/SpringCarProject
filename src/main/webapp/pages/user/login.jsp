<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 01.12.2022
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>

<s:form action="/user/login" method="post" modelAttribute="loginUser">
    <s:input path="email" size="50" placeholder="Email"></s:input>
    <br>
    <s:errors path="email" cssStyle="color: red"></s:errors>
    <br>
    <s:input path="password" size="50" placeholder="Password"></s:input>
    <br>
    <s:errors path="password" cssStyle="color: red"></s:errors>
    <br>
    <s:button class="btn btn-primary">Login</s:button>
</s:form>
<p style="color: red">${message}</p>
<h1>Not registered yet?</h1>
<a href="/user/signup" class="btn btn-primary">SignUp</a>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</body>
</html>
