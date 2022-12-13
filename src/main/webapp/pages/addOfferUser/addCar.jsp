<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 08.12.2022
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add car</title>
</head>
<body>
<header>
    <jsp:include page="../header.jsp"></jsp:include>
</header>
<s:form action="/offer/addCar" method="post" modelAttribute="newCar">
    <p>Enter Add a link to your car image:</p>
    <s:input path="srcPicture" size="30" placeholder="srcPicture"/>
    <br>
    <s:errors path="srcPicture"/>
    <p>Enter name of car</p>
    <s:input path="nameProduct" size="30" placeholder="Car name"/>
    <br>
    <s:errors path="nameProduct"/>
    <p>Enter release date of your car:</p>
    <s:input path="releaseDate" size="30" placeholder="Release date"/>
    <br>
    <s:errors path="releaseDate"/>
    <p>Enter color of your car:</p>
    <s:input path="color" size="30" placeholder="Color"/>
    <br>
    <s:errors path="color"/>
    <p>Enter the producer of your vehicle:</p>
    <s:input path="producer" size="30" placeholder="Producer"/>
    <br>
    <s:errors path="producer"/>
    <p>Enter the passenger capacity of your car:</p>
    <s:input path="passengerCapacity" size="30" placeholder="Passenger capacity"/>
    <br>
    <s:errors path="passengerCapacity"/>
    <br>
    <s:button>Submit</s:button>
</s:form>
<p style="color: red">${message}</p>
<footer>
    <jsp:include page="../date.jsp"></jsp:include>
    <jsp:include page="../footer.jsp"></jsp:include>
</footer>
</body>
</html>
