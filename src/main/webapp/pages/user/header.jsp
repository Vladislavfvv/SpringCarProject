<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 09.12.2022
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Header</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="header.css">
</head>
<body>
<header>
    <nav class="py-2 bg-light border-bottom">
        <div class="container d-flex flex-wrap">
            <ul class="nav me-auto">
                <li class="nav-item">
                    <a action="${pageContext.request.contextPath}/catalog/transport"
                       class="nav-link link-dark px-2 active" aria-current="page">
                        <form name="menu">
                            <select name="allTransport" onchange="location = this.value" id="allTransport">
                                <option selected value="">Transport</option>
                                <option value="/catalog/usedCar">Shop used cars</option>
                                <option value="/catalog/newCar">Shop new cars</option>
                                <option value="/catalog/truck">Trucks</option>
                                <option value="/catalog/bus">Buses</option>
                                <option value="/catalog/trailer">Trailers</option>
                                <option value="/catalog/motorcycle">Motorcycles</option>
                            </select>
                        </form>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/catalog/tires" methods="get"
                       class="nav-link link-dark px-2">Tires
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/catalog/parts" methods="get"
                       class="nav-link link-dark px-2">Parts
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/catalog/carServices" methods="get"
                       class="nav-link link-dark px-2">Car Services
                    </a>
                </li>
            </ul>
            <ul class="nav">

                <c:if test="${sessionScope.currentUser == null}">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/user/login" methods="get"
                           class="nav-link link-dark px-2">LogIn
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/user/signup" methods="get"
                           class="nav-link link-dark px-2 btn btn-primary">SignUp
                        </a>
                    </li>
                </c:if>

                <c:if test="${sessionScope.currentUser!=null}">
                    <li class="nav-item">
                        <h3>
                            Hello, ${sessionScope.currentUser.email}
                        </h3>
                        <br>
                        <a href="/user/logout">LogOut</a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>

</body>
</html>
