<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Site sell a car</title>


    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="header.css">
</head>

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
                           class="nav-link link-dark px-2">SignUp
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








<%--                <c:if test="${sessionScope.currentCustomer == null && sessionScope.currentSeller == null}">--%>
<%--                    <li class="nav-item">--%>
<%--                        <a href="${pageContext.request.contextPath}/user/login" methods="get"--%>
<%--                           class="nav-link link-dark px-2">Login--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                    <li class="nav-item">--%>
<%--                        <a href="${pageContext.request.contextPath}/user/signup" methods="get"--%>
<%--                           class="nav-link link-dark px-2">Sign up--%>
<%--                        </a>--%>
<%--                    </li>--%>
<%--                </c:if>--%>

<%--                <c:if test="${sessionScope.currentCustomer!=null}">--%>
<%--                    <li class="nav-item">--%>
<%--                        <h3>--%>
<%--                            Hello, ${sessionScope.currentCustomer.get().nickName}--%>
<%--                        </h3>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
<%--                <c:if test="${sessionScope.currentSeller!=null}">--%>
<%--                    <li class="nav-item">--%>
<%--                        <h3>--%>
<%--                            Hello, ${sessionScope.currentSeller.get().nickname}--%>
<%--                        </h3>--%>
<%--                    </li>--%>
<%--                </c:if>--%>
            </ul>
        </div>
    </nav>
</header>

<body>
<%--<h2>Sell a car label</h2>--%>
<%--<div>--%>
<%--    <form action="${pageContext.request.contextPath}/catalog/transport" method="get">--%>

<%--        <form name="menu">--%>
<%--            <select th:name="allTransport" onchange="location = this.value" th:id="allTransport">--%>
<%--                <option selected value="">Select transport</option>--%>
<%--                <option value="/catalog/transport">Car</option>--%>
<%--                <option value="/catalog/transport">Truck</option>--%>
<%--                <option value="/catalog/transport">Bus</option>--%>
<%--            </select>--%>
<%--        </form>--%>

<%--        <!--<button>Transport</button> -->--%>
<%--    </form>--%>
<%--    <form action="${pageContext.request.contextPath}/catalog/tires" method="get">--%>
<%--        <button>Tires</button>--%>
<%--    </form>--%>
<%--    <form action="${pageContext.request.contextPath}/catalog/parts" method="get">--%>
<%--        <button>Parts</button>--%>
<%--    </form>--%>
<%--    <form action="${pageContext.request.contextPath}/catalog/carServices" method="get">--%>
<%--        <button>Car Services</button>--%>
<%--    </form>--%>

<%--    <form action="${pageContext.request.contextPath}/login" method="get">--%>
<%--        <button>Log In</button>--%>
<%--    </form>--%>

<%--    <form action="${pageContext.request.contextPath}/signup" method="get">--%>
<%--        <button>Sign Up</button>--%>
<%--    </form>--%>
<%--</div>--%>


<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"--%>
<%--        crossorigin="anonymous"></script>--%>
</body>
</html>
