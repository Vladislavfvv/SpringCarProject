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
<s:form action="/offer/createOffer/addCar" method="post" modelAttribute="newCar">
    <p>Enter name of car</p>
    <s:input path="nameProduct" size="30" placeholder="Car name"/>
    <br>
    <s:errors path="nameProduct"/>
    <p>Enter Add a link to your car image:</p>
    <s:input path="srcPicture" size="30" placeholder="srcPicture"/>
    <br>
    <s:errors path="srcPicture"/>
    <p>Enter release date of your car:</p>
    <s:input path="releaseDate" size="30" placeholder="Release date"/>
    <br>
    <s:errors path="releaseDate"/>
    <p>Enter color of your car:</p>
    <s:input path="color" size="30" placeholder="Color"/>
    <br>
    <s:errors path="color"/>
    <p>Enter type of engine your car:</p>
<%--    <s:input path="engine" size="30" placeholder="Engine type"/>--%>
<%--    <br>--%>
<%--    <s:errors path="engine"/>    <br>--%>
    <p>Enter the producer of your vehicle:</p>
    <s:input path="producer" size="30" placeholder="Producer"/>
    <br>
    <s:errors path="producer"/>
    <p>Enter your car description:</p>
<%--    <s:input path="description" size="30" placeholder="Description"/>--%>
<%--    <br>--%>
<%--    <s:errors path="description"/>    <br>--%>
<%--    <p>Enter your car price:</p>--%>
<%--    <s:input path="price" size="30" placeholder="Price"/> BYN</br>--%>
<%--    <br>--%>
<%--    <s:errors path="price"/>--%>
    <br>
    <s:button>Submit</s:button>
</s:form>
</body>
</html>
