<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 04.12.2022
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seller registration</title>
</head>
<body>
<s:form action="/seller/sellerRegistration" method="post" modelAttribute="newSeller">
    <p>Enter your e-mail:</p>
    <s:input path="email" size="30" placeholder="Email"/>
    <br>
    <s:errors path="email"/>

    <p>Enter your password:</p>
    <s:input path="password" size="30" type="password" placeholder="Password"/>
    <br>
    <s:errors path="password"/>

    <p>Enter name of your company:</p>
    <s:input path="companyName" size="30" placeholder="Company name"/>
    <br>
    <s:errors path="companyName"/>

    <p>Enter address of your company:</p>
    <s:input path="storeAddress" size="30" placeholder="Country"/>
    <br>
    <s:errors path="storeAddress"/>

    <p>Enter phone number of your store with +375:</p>
    <s:input path="phoneNumber" size="20" placeholder="Store phone number"/>
    <br>
    <s:errors path="phoneNumber"/>

    <s:button>Submit</s:button>
</s:form>
</body>
</html>
