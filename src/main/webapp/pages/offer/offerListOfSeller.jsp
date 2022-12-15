<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 09.12.2022
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Offer List of seller</title>
</head>
<body>
<%--<jsp:useBean id="listOfOffers" scope="request" type="by.tms.web.OfferController"/>--%>
<c:if test="${listOfOffers != null}">
    <ul>
        <c:forEach items="${listOfOffers}" var="offer">
            <li>
                <c:out value="${offer.abstractProduct.nameProduct}"></c:out>
                <c:out value="${offer.description}"></c:out>
                <c:out value="${offer.price}"></c:out>
                <c:out value="${offer.offerDateTime}"></c:out>
            </li>
        </c:forEach>
    </ul>
</c:if>


<c:if test="${listOfOffers == null}">
    <p>You haven't offers</p>
</c:if>

<form action="/user/login">
    <button>To your account</button>
</form>
</body>
</html>
