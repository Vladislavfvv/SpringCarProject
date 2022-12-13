<jsp:useBean id="currentUser" scope="session" type="by.tms.entity.User"/>
<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 07.12.2022
  Time: 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Personal data</title>
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<p><b>First name:</b>${currentUser.firstName}</p>
<a href="/user/editFirstName">Change first name</a>
<br>
<p><b>Second name:</b>${currentUser.secondName}</p>
<a href="/user/editSecondName">Change second name</a>
<br>
<p><b>Email:</b>${currentUser.email}</p>
<a href="/user/editEmail">Change email</a>
<br>
<p><b>Phone:</b>${currentUser.phone}</p>
<a href="/user/editPhone">Change phone</a>
<br>
<p><b>Address:</b>${currentUser.address}</p>
<a href="/user/editAddress">Change address</a>
<br>
<p><b>Password:</b>${currentUser.password}</p>
<a href="/user/editPassword">Change password</a>
<br>
<br>
<a href="${pageContext.request.contextPath}/offer/selectProductCategory">To add an ad</a>
<br>
<a href="/addOfferUser/offerListOfSeller">Yours offers: </a>
<h3>Your offers : </h3>

<ul>
    <c:if test="${listOfOffers != null}">
        <c:forEach items="${listOfOffers}" var="offer">
            <li>
                <c:out value="${offer.abstractProduct.nameProduct}"></c:out>
                <c:out value="${offer.description}"></c:out>
                <c:out value="${offer.price}"></c:out>
                <c:out value="${offer.offerDateTime}"></c:out>
            </li>
        </c:forEach>
    </c:if>
</ul>


<c:if test="${listOfOffers == null}">
    <p>You haven't offers</p>
</c:if>
    <br>
    <a href="${pageContext.request.contextPath}/user/logout">Logout</a>
    <br>


<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>

</html>