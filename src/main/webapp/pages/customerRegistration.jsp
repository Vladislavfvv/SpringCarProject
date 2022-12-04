<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 04.12.2022
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer registration</title>
</head>
<body>
<s:form action="customer/customerRegistration" method="post" modelAttribute="newCustomer">

    <p>Enter your nickname:</p>
    <s:input path="nickName" size="30" placeholder="Nickname"/>
    <br>
    <s:errors path="nickName"/>

    <p>Enter your firstname:</p>
    <s:input path="firstName" size="30" placeholder="First name"/>
    <br>
    <s:errors path="firstName"/>

    <p>Enter your lastname:</p>
    <s:input path="lastName" size="30" placeholder="Last name"/>
    <br>
    <s:errors path="lastName"/>

    <p>Enter your Phone number:</p>
    <s:input path="phoneNumber" size="30" placeholder="Last name"/>
    <br>
    <s:errors path="phoneNumber"/>

    <p>Enter your e-mail:</p>
    <s:input path="email" size="30" placeholder="e-mail"/>
    <br>
    <s:errors path="email"/>

    <p>Enter your password:</p>
    <s:input path="password" size="30" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>
    <br>

    <s:button>Submit</s:button>
</s:form>

</body>
</html>
