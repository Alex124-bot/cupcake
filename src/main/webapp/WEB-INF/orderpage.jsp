<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Ordrebekræftligelse
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h2>Hej<c:if test="${sessionScope.user != null }">, ${sessionScope.email}</c:if></h2>
        <hr>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th scope="col">Top</th>
                        <th scope="col">Bund</th>
                        <th scope="col">Antal</th>
                        <th scope="col">Pris</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="basketItem" items="${sessionScope.basket.list}">
                        <tr>
                            <td scope="row"><b>${applicationScope.toppingList.get(basketItem.toppingId-1).name}</b></td>
                            <td><strong>${applicationScope.bottomList.get(basketItem.bottomId-1).name}</strong></td>
                            <td><strong>${basketItem.amount} stk.</strong></td>
                            <td><strong>${applicationScope.toppingList.get(basketItem.toppingId-1).price
                                    + applicationScope.bottomList.get(basketItem.bottomId-1).price
                                    * basketItem.amount},- kr.</strong></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
    </jsp:body>

</t:genericpage>