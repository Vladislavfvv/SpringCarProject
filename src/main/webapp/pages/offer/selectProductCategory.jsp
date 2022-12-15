<%--
  Created by IntelliJ IDEA.
  User: Dimaf
  Date: 13.12.2022
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>selectProductCategory page</title>
</head>
<body>
<p>Choose what you are product category:</p>
<%--<form action="/offer/selectProductCategory" method="post">--%>
<%--<button type="button" onclick=""--%>

<%--&lt;%&ndash;    <c:forEach items="${sessionScope.offer.abstractProduct. sessionScope.currentUser.productCategories}" var="productCategory">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input id="radioId" type="radio" name="productCategory" value="${productCategory}">&ndash;%&gt;--%>
<%--&lt;%&ndash;        <label for="radioId">${productCategory}</label>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <br>&ndash;%&gt;--%>
<%--&lt;%&ndash;    </c:forEach>&ndash;%&gt;--%>
<%--   // <button>Continue</button>--%>
<%--</form>--%>





<a href="/offer/selectProductCategory/?product=newCar">Add car</a><br>
<a href="/offer/selectProductCategory/?product=newBus">Add bus</a><br>
<a href="/offer/selectProductCategory/?product=newTruck">Add truck</a><br>
<a href="/offer/selectProductCategory/?product=newMotorbike">Add motorbike</a><br>
<a href="/offer/selectProductCategory/?product=newTrailer">Add trailer</a><br>
<a href="/offer/selectProductCategory/?product=newTire">Add tire</a><br>
<a href="/offer/selectProductCategory/?product=newPart">Add part</a><br>


<br>
<a href="/offer/addCar">Add car</a>
<br>
<a href="/offer/addBus">Add bus</a>
<br>
<a href="/offer/addTruck">Add truck</a>
<br>
<a href="/offer/addTrailer">Add trailer</a>
<br>
<a href="/offer/addTire">Add tire</a>
<br>
<a href="/offer/addPart">Add part</a>
<br>
<a href="/offer/addCarService">Add carService</a>
<br><br>


<s:form action="/offer/selectProductCategory" method="post" modelAttribute="newCategory">
    <c:forEach items="${sessionScope.offer.}" var="productCategory">
        <input id="radioId" type="radio" name="productCategory" value="${productCategory}">
        <label for="radioId">${productCategory}</label>
        <br>
    </c:forEach>
    <s:button class="btn btn-primary">Car</s:button>

</s:form>
</body>
</html>
