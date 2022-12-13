<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 07.12.2022
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create offer</title>
</head>
<body>
<s:form action="/offer/createOffer" method="post" modelAttribute="OfferDTO">
    <p>Enter your offer description:</p>
    <s:input path="description" size="30" placeholder="Description"/>
    <br>
    <s:errors path="description"/>
    <br>
    <p>Enter your offer price:</p>
    <s:input path="price" size="30" placeholder="Price"/> BYN</br>
    <br>
    <s:errors path="price"/>
    <br>
    <s:button>Submit</s:button>
</s:form>

</body>
</html>
