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

    <link rel="stylesheet" type="text/css" href="/pages/header.css">
</head>
<header>
    <jsp:include page="/pages/header.jsp"></jsp:include>
</header>


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
<footer>
    <jsp:include page="/pages/date.jsp"></jsp:include>
    <jsp:include page="/pages/footer.jsp"></jsp:include>
</footer>
</body>
</html>
