<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 20-04-2021
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Resultatside for beregning af BMI
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div>
        <div class="row">
            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <h2>indkøbskurv</h2>

                <p>Du har valgt(${requestScope.topping} topping<br/>
                    og ${requestScope.bottom} bottom</p>
                <p>
                    Dit BMI er beregnet til ${requestScope.amount}
                </p>
                <p>
                    Du er ${requestScope.category}
                </p>
                <p>Køn: ${requestScope.gender}</p>
                <p>Sports_id: ${requestScope.sport_id}</p>

                <c:forEach var="hobbieItem" items="${requestScope.hobbies}" >
                    hobby: ${hobbieItem}<br/>
                </c:forEach>




                <div class="col-sm-4"></div>
            </div>


        </div>

    </jsp:body>
</t:genericpage>