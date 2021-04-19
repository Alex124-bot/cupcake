<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Customer of our wonderful site.
        </br>
        <table>
            <tr>
                <th>Bottoms</th>
                <th>toppings</th>
            </tr>
            <tr>
                <td>
                <select name="bottom" id="bottom">
                    <c:forEach var="bottom" items="${applicationScope.bottomList}">
                        <option value="${bottom.id}">${bottom.name}</option>
                    </c:forEach>
                </select>
                </td>
                <td>
                    <select name="topping" id="topping">
                    <c:forEach var="topping" items="${applicationScope.toppingList}">
                        <option value="${topping.id}">${topping.name}</option>
                    </c:forEach>
                </select>
                </td>
            </tr>
        </table>
    </jsp:body>

</t:genericpage>

