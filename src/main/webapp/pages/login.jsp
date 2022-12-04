<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 01.12.2022
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>

<s:form action="/user/login" method="post" modelAttribute="user">
    <s:input path="email" size="50" placeholder="Email"></s:input>
    <br>
    <s:errors path="email" cssStyle="color: red"></s:errors>
    <br>
    <s:input path="password" size="50" placeholder="Password"></s:input>
    <br>
    <s:errors path="password" cssStyle="color: red"></s:errors>
    <br>
    <s:button>Login</s:button>
</s:form>
<p style="color: red">${message}</p>
<h1>Not registered yet?</h1>
<a href="/seller/sellerRegistration">Register as a Seller</a>
<a href="/customer/customerRegistration">Register as a Customer</a>

</body>
</html>
