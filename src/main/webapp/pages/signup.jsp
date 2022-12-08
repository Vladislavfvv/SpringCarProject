<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 03.12.2022
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign Up page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<s:form action="/user/signup" method="post" modelAttribute="newUser">

    <s:input path="firstName" placeholder="Input first name"/>
    <br>
    <s:errors path="firstName" cssStyle="color: red"/>
    <br>
    <s:input path="secondName" placeholder="Input second name"/>
    <br>
    <s:errors path="secondName" cssStyle="color: red"/>
    <br>
    <s:input path="email" placeholder="Input email"/>
    <br>
    <s:errors path="email" cssStyle="color: red"/>
    <br>
    <s:input path="phone" placeholder="Input phone Number +375"/>
    <br>
    <s:errors path="phone" cssStyle="color: red"/>
    <br>
    <s:input path="address" placeholder="Input address"/>
    <br>
    <s:errors path="address" cssStyle="color: red"/>
    <br>
    <s:input path="password" type="password" placeholder="Input password"/>
    <br>
    <s:errors path="password" cssStyle="color: red"/>
    <br>
    <s:button>Register</s:button>
    <a href="/" class="btn btn-primary">Back</a>
    </s:form>
    <p style="color: red">${message}</p>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
</body>
</html>
